package in.co.movie.ticket.ctl;


import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import in.co.movie.ticket.entity.MovieEntity;
import in.co.movie.ticket.entity.TheaterEntity;
import in.co.movie.ticket.form.MovieForm;
import in.co.movie.ticket.form.TheaterForm;
import in.co.movie.ticket.service.MovieServiceInt;
import in.co.movie.ticket.service.TheaterServiceInt;
import in.co.movie.ticket.util.DataUtility;



@Controller
public class WelcomeCtl extends BaseCtl {

	@Autowired
	private TheaterServiceInt service;
	
	@Autowired
	private MovieServiceInt movieService;
	
	@GetMapping({"/home","/"})
	public String getWelcome(Model model) {
		return "home";
	}
	
	@RequestMapping(value = "/welcome", method = { RequestMethod.GET, RequestMethod.POST })
	public String searchList(@ModelAttribute("form") TheaterForm form,
			@RequestParam(required = false) String operation,Long pidd,HttpSession session, Model model) {

		if (OP_RESET.equalsIgnoreCase(operation)) {
			return "redirect:/welcome";
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

		
		TheaterEntity bean=(TheaterEntity)form.getBean();
		List<TheaterEntity> list =service.search(bean);
		List<TheaterEntity> totallist =service.search(bean);
		model.addAttribute("list", list);
		

		if (list.size() == 0 && !OP_DELETE.equalsIgnoreCase(operation)) {
			model.addAttribute("error","Record Not found");
			// return "redirect:/welcome";
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
		return "welcome";
	}
	
	@RequestMapping(value = "/home/movie", method = { RequestMethod.GET, RequestMethod.POST })
	public String searchList(@ModelAttribute("form") MovieForm form,
			@RequestParam(required = false) String operation,Long tid,HttpSession session, Model model) {

		if (OP_RESET.equalsIgnoreCase(operation)) {
			return "redirect:/home";
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
		
		MovieEntity bean=(MovieEntity)form.getBean();
		if(tid>0) {
			bean.setTheaterId(tid);
		}
		List<MovieEntity> list =movieService.search(bean);
		List<MovieEntity> totallist =movieService.search(bean);
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
		return "homeMovie";
	}
	
}
