package in.co.movie.ticket.ctl;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.hibernate.service.internal.ServiceDependencyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import in.co.movie.ticket.entity.InvoiceDetailEntity;
import in.co.movie.ticket.entity.InvoiceEntity;
import in.co.movie.ticket.entity.MovieEntity;
import in.co.movie.ticket.entity.UserEntity;
import in.co.movie.ticket.exception.DuplicateRecordException;
import in.co.movie.ticket.form.InvoiceDetailForm;
import in.co.movie.ticket.form.InvoiceForm;
import in.co.movie.ticket.form.MovieForm;
import in.co.movie.ticket.service.InvoiceDetailServiceInt;
import in.co.movie.ticket.service.InvoiceServiceInt;
import in.co.movie.ticket.service.MovieServiceInt;
import in.co.movie.ticket.util.DataUtility;


@Controller
@RequestMapping("/invoice")
public class InvoiceCtl extends BaseCtl {

	@Autowired
	private InvoiceServiceInt service;
	
	@Autowired
	private MovieServiceInt movieService;
	
	@Autowired 
	private InvoiceDetailServiceInt invoiceDetailService;
	
	@ModelAttribute
	public void preload(Model model) {
		Map<String,String> map=new HashMap<String, String>();
		map.put("09:00 AM","09:00 AM");
		map.put("12:00 PM","12:00 PM");
		map.put("03:00 PM","03:00 PM");
		map.put("06:00 PM","06:00 PM");
		map.put("09:00 PM","09:00 PM");
		model.addAttribute("showTime",map);
	}
	
	
	@GetMapping
	public String display(HttpSession session,@RequestParam(required = false) Long id,Long mId,@ModelAttribute("form") InvoiceForm form, Model model) {
		if(mId>0) {
			session.setAttribute("mid",mId);	
		}
		return "invoice";
	}
	@PostMapping
	public String submit(HttpSession session,@Valid @ModelAttribute("form") InvoiceForm form, BindingResult bindingResult,
			Model model,HttpServletRequest request) {
			
			System.out.println("Operation-----"+form.getOperation());
			try {
			if (OP_PAYMENT.equalsIgnoreCase(form.getOperation())) {
				
				if(bindingResult.hasErrors()) {
					System.out.println(bindingResult.hasErrors());
					return "invoice";
				}
				
				InvoiceEntity entity=(InvoiceEntity)populateDTO(form.getBean(), request);
				long mid=DataUtility.getLong(String.valueOf(session.getAttribute("mid")));
				MovieEntity movieEntity=movieService.findByPk(mid);
				entity.setDate(new Date());
				entity.setMovieId(movieEntity.getId());
				entity.setMovieName(movieEntity.getName());
				entity.setTheatorId(movieEntity.getTheaterId());
				entity.setTheatorName(movieEntity.getTheaterName());
				entity.setScreenNo(movieEntity.getScreenNo());
				entity.setPrice(movieEntity.getPrice());
				entity.setTotal(String.valueOf(DataUtility.getLong(movieEntity.getPrice())*DataUtility.getLong(entity.getNoOfSeat())));
				entity.setInvoiceNumber(String.valueOf(getRandom()));
				session.setAttribute("invoiceDetail", entity);
				return "payment";
			}
			
			if(OP_CONFIRM_PAYMENT.equalsIgnoreCase(form.getOperation())) {
					InvoiceEntity entity=(InvoiceEntity)session.getAttribute("invoiceDetail");
					UserEntity uEntity=(UserEntity)session.getAttribute("user");
					entity.setUserId(uEntity.getId());
					service.add(entity);
					int seat=1;
					InvoiceDetailEntity inDetail=new InvoiceDetailEntity();
					inDetail.setMovieName(entity.getMovieName());
					inDetail.setShow_time(entity.getShow_time());
					inDetail.setDate(entity.getDate());
					List<InvoiceDetailEntity> list=invoiceDetailService.search(inDetail);
					System.out.println("List size-dd==d0"+list.size());
					Iterator<InvoiceDetailEntity> it=list.iterator();
					while (it.hasNext()) {
						InvoiceDetailEntity invoiceDetailEntity = (InvoiceDetailEntity) it.next();
						System.out.println("Seat no -SD-C-SD---------"+invoiceDetailEntity.getSeatNo());
						seat=DataUtility.getInt(invoiceDetailEntity.getSeatNo());
					}
					System.out.println("Seat======"+seat);
					
					int nop=DataUtility.getInt(entity.getNoOfSeat());
					InvoiceDetailEntity invoiceDetail=new InvoiceDetailEntity();
					invoiceDetail.setInvoiceNumber(entity.getInvoiceNumber());
					invoiceDetail.setDate(entity.getDate());
					invoiceDetail.setScreenNo(entity.getScreenNo());
					invoiceDetail.setTheaterName(entity.getTheatorName());
					invoiceDetail.setMovieName(entity.getMovieName());
					invoiceDetail.setPrice(entity.getPrice());
					invoiceDetail.setShow_time(entity.getShow_time());
					invoiceDetail.setUserId(uEntity.getId());
					for(int i=1;i<=nop;i++) {
						invoiceDetail.setSeatNo(String.valueOf(seat++));
						invoiceDetailService.add(invoiceDetail);
					}
					return "redirect:/invoice/success?inNo="+entity.getInvoiceNumber();
			}
			} catch (DuplicateRecordException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return "";
	}
	
	@RequestMapping(value = "/success", method = { RequestMethod.GET, RequestMethod.POST })
	public String searchList(@ModelAttribute("form") InvoiceDetailForm form,
			@RequestParam(required = false) String operation,String inNo ,HttpSession session, Model model) {
		
		InvoiceDetailEntity bean=(InvoiceDetailEntity)form.getBean();
		bean.setInvoiceNumber(inNo);
		List<InvoiceDetailEntity> list =invoiceDetailService.search(bean);
		model.addAttribute("list", list);
		
		if (list.size() == 0 && !OP_DELETE.equalsIgnoreCase(operation)) {
			model.addAttribute("error","Record not found");
		}
		model.addAttribute("success","Ticket Booking Succesfully");
		return "success";
	}
	
	@RequestMapping(value = "/search", method = { RequestMethod.GET, RequestMethod.POST })
	public String searchList(@ModelAttribute("form") InvoiceForm form,
			@RequestParam(required = false) String operation,HttpSession session, Model model) {

		if (OP_RESET.equalsIgnoreCase(operation)) {
			return "redirect:/invoice/search";
		}

		int pageNo = form.getPageNo();
		int pageSize = form.getPageSize();

		if (OP_NEXT.equals(operation)) {
			pageNo++;
		} else if (OP_PREVIOUS.equals(operation)) {
			pageNo--;
		}

		pageNo = (pageNo < 1) ? 1 : pageNo;
		pageSize = (pageSize < 1) ? 10 : pageSize;

		
		InvoiceEntity bean=(InvoiceEntity)form.getBean();
		
		UserEntity uEntity=(UserEntity)session.getAttribute("user");
		if(uEntity.getRoleId()==2){
			bean.setUserId(uEntity.getId());
		}
		
		List<InvoiceEntity> list =service.search(bean);
		List<InvoiceEntity> totallist =service.search(bean);
		model.addAttribute("list", list);
		

		if (list.size() == 0 && !OP_DELETE.equalsIgnoreCase(operation)) {
			model.addAttribute("error","Record not found");
		}

		int listsize = list.size();
		int total = totallist.size();
		int pageNoPageSize = pageNo * pageSize;

		form.setPageNo(pageNo);
		form.setPageSize(pageSize);
		model.addAttribute("pageNo", pageNo);
		model.addAttribute("pageSize", pageSize);
		model.addAttribute("listsize", listsize);
		model.addAttribute("total", total);
		model.addAttribute("pagenosize", pageNoPageSize);
		model.addAttribute("form", form);
		return "invoiceList";
		
	}
	
	@RequestMapping(value = "/detail/search", method = { RequestMethod.GET, RequestMethod.POST })
	public String searchList(@ModelAttribute("form") InvoiceDetailForm form,
			@RequestParam(required = false) String operation,HttpSession session, Model model) {

		if (OP_RESET.equalsIgnoreCase(operation)) {
			return "redirect:/invoice/detail/search";
		}

		int pageNo = form.getPageNo();
		int pageSize = form.getPageSize();

		if (OP_NEXT.equals(operation)) {
			pageNo++;
		} else if (OP_PREVIOUS.equals(operation)) {
			pageNo--;
		}

		pageNo = (pageNo < 1) ? 1 : pageNo;
		pageSize = (pageSize < 1) ? 10 : pageSize;
		InvoiceDetailEntity bean=(InvoiceDetailEntity)form.getBean();
		UserEntity uEntity=(UserEntity)session.getAttribute("user");
		if(uEntity.getRoleId()==2){
			bean.setUserId(uEntity.getId());
		}
		
		List<InvoiceDetailEntity> list =invoiceDetailService.search(bean);
		List<InvoiceDetailEntity> totallist =invoiceDetailService.search(bean);
		model.addAttribute("list", list);
		

		if (list.size() == 0 && !OP_DELETE.equalsIgnoreCase(operation)) {
			model.addAttribute("error","Record not found");
		}

		int listsize = list.size();
		int total = totallist.size();
		int pageNoPageSize = pageNo * pageSize;

		form.setPageNo(pageNo);
		form.setPageSize(pageSize);
		model.addAttribute("pageNo", pageNo);
		model.addAttribute("pageSize", pageSize);
		model.addAttribute("listsize", listsize);
		model.addAttribute("total", total);
		model.addAttribute("pagenosize", pageNoPageSize);
		model.addAttribute("form", form);
		return "invoiceDetailList";
	}
	
	
	public static int getRandom() {
		Random rnum = new Random();
		 return rnum.nextInt(50000);
	}
	
}
