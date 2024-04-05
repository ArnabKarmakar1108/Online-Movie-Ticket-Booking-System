package in.co.movie.ticket.ctl;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import in.co.movie.ticket.entity.TheaterEntity;
import in.co.movie.ticket.exception.DuplicateRecordException;
import in.co.movie.ticket.form.TheaterForm;
import in.co.movie.ticket.service.TheaterServiceInt;
import in.co.movie.ticket.util.DataUtility;





@Controller
@RequestMapping("/theater")
public class TheaterCtl extends BaseCtl {

	@Autowired
	private TheaterServiceInt service;
	
	
	
	@ModelAttribute
	public void preload(Model model) {		

		HashMap<String,String> map=new HashMap<String, String>();
		map.put("Single Screen", "Single Screen");
		map.put("Multiplex", "Multiplex");
		model.addAttribute("type",map);
		
	}
	
	@GetMapping
	public String display(@RequestParam(required = false) Long id,@ModelAttribute("form") TheaterForm form, Model model) {
		if (form.getId() > 0) {
			TheaterEntity bean=service.findByPk(id);
			form.populate(bean);
		}
		return "theater";
	}
	
	
	/*
	 * @RequestMapping(value = "/detail", method = { RequestMethod.GET,
	 * RequestMethod.POST }) public String display(@RequestParam("pid") Long
	 * pId,HttpSession session,@ModelAttribute("form") BookTheatreForm form, Model
	 * model) {
	 * 
	 * if(pId>0) { TheatreEntity bean=service.findByPk(pId);
	 * session.setAttribute("prod",bean); model.addAttribute("prod", bean); } return
	 * "Theatre-detail"; }
	 */
	
	@PostMapping
	public String submit(@RequestParam("image") MultipartFile file,@Valid @ModelAttribute("form")  TheaterForm form, BindingResult bindingResult,
			Model model,HttpServletRequest request) {
		if (OP_RESET.equalsIgnoreCase(form.getOperation())) {
			return "redirect:theater";
		}
		try {
			if (OP_SAVE.equalsIgnoreCase(form.getOperation())) {
			
				if (bindingResult.hasErrors()) {
					return "theater";
				}
				
				TheaterEntity bean = (TheaterEntity) populateDTO(form.getBean(), request);
				bean.setImage(file.getBytes());
				if(bean.getId()>0) {
					service.update(bean);
					model.addAttribute("success", "Theatre update Successfully!!!!");
				}else {
				service.add(bean);
				model.addAttribute("success", "Theatre Added Successfully!!!!");
				}
				return "theater";
			}
		} catch (DuplicateRecordException e) {
			model.addAttribute("error", e.getMessage());
			return "theater";
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}
	@RequestMapping(value = "/search", method = { RequestMethod.GET, RequestMethod.POST })
	public String searchList(@ModelAttribute("form") TheaterForm form,
			@RequestParam(required = false) String operation,Long pidd,HttpSession session, Model model) {

		if (OP_RESET.equalsIgnoreCase(operation)) {
			return "redirect:/theater/search";
		}

		int pageNo = form.getPageNo();
		int pageSize = form.getPageSize();

		if (OP_NEXT.equals(operation)) {
			pageNo++;
		} else if (OP_PREVIOUS.equals(operation)) {
			pageNo--;
		}else if (OP_NEW.equals(operation)) {
			return "redirect:/theater";
		}

		pageNo = (pageNo < 1) ? 1 : pageNo;
		pageSize = (pageSize < 1) ? 10 : pageSize;

		
		if (OP_DELETE.equalsIgnoreCase(operation)) {
			if (form.getIds() != null) {
				for (long id : form.getIds()) {
					TheaterEntity dto = new TheaterEntity();
					dto.setId(id);
					service.delete(dto);
				}
				Integer[] lengths = { form.getIds().length };
				model.addAttribute("success", "Record Delete Successfully");
			} else {
				model.addAttribute("error","Select at least one Record");
			}
		}
		
		TheaterEntity bean=(TheaterEntity)form.getBean();
		List<TheaterEntity> list =service.search(bean);
		List<TheaterEntity> totallist =service.search(bean);
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
		return "theaterList";
	}
	
	
	/*
	 * @RequestMapping(value = "/home/search", method = { RequestMethod.GET,
	 * RequestMethod.POST }) public String searchTheatreHome(@ModelAttribute("form")
	 * TheatreForm form,
	 * 
	 * @RequestParam(required = false) String operation,Long cId,HttpSession
	 * session, Model model) {
	 * 
	 * int pageNo = form.getPageNo(); int pageSize = form.getPageSize();
	 * 
	 * if (OP_NEXT.equals(operation)) { pageNo++; } else if
	 * (OP_PREVIOUS.equals(operation)) { pageNo--; } pageNo = (pageNo < 1) ? 1 :
	 * pageNo; pageSize = (pageSize < 1) ? 10 : pageSize;
	 * 
	 * TheatreEntity bean=(TheatreEntity)form.getBean();
	 * if(DataUtility.getLong(String.valueOf(cId))>0) {
	 * bean.setCategoryId(DataUtility.getLong(String.valueOf(cId))); }
	 * List<TheatreEntity> list =service.search(bean); List<TheatreEntity> totallist
	 * =service.search(bean); model.addAttribute("list", list);
	 * 
	 * 
	 * 
	 * if (list.size() == 0 && !OP_DELETE.equalsIgnoreCase(operation)) {
	 * model.addAttribute("error","Record not found"); }
	 * 
	 * int listsize = list.size(); int total = totallist.size(); int pageNoPageSize
	 * = pageNo * pageSize;
	 * 
	 * form.setPageNo(pageNo); form.setPageSize(pageSize);
	 * model.addAttribute("pageNo", pageNo); model.addAttribute("catList",
	 * catService.search(null)); model.addAttribute("pageSize", pageSize);
	 * model.addAttribute("listsize", listsize); model.addAttribute("total", total);
	 * model.addAttribute("pagenosize", pageNoPageSize); model.addAttribute("form",
	 * form); return "home-Theatre-list"; }
	 */
	
	@GetMapping("/getImage/{id}")
	public void getStudentPhoto(HttpServletResponse response, @PathVariable("id") long id) throws Exception {
		response.setContentType("image/jpeg");
		Blob blb=service.getImageById(id);
		byte[] bytes = blb.getBytes(1, (int) blb.length());
		InputStream inputStream = new ByteArrayInputStream(bytes);
		IOUtils.copy(inputStream, response.getOutputStream());
	}
	
	/*
	 * @GetMapping("/getSize/{id}") public int getStudentPhoto(@PathVariable("id")
	 * long id) throws Exception { TheatreEntity bean=new TheatreEntity();
	 * bean.setId(id); return service.search(bean).size(); }
	 */
	
}
