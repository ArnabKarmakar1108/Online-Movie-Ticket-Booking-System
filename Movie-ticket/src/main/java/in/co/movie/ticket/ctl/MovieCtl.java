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

import in.co.movie.ticket.entity.MovieEntity;
import in.co.movie.ticket.entity.TheaterEntity;
import in.co.movie.ticket.exception.DuplicateRecordException;
import in.co.movie.ticket.form.MovieForm;
import in.co.movie.ticket.service.MovieServiceInt;
import in.co.movie.ticket.service.TheaterServiceInt;
import in.co.movie.ticket.util.DataUtility;

@Controller
@RequestMapping("/movie")
public class MovieCtl extends BaseCtl {

	@Autowired
	private MovieServiceInt service;
	
	@Autowired
	private TheaterServiceInt theaterService;
	
	@ModelAttribute
	public void preload(Model model) {
		TheaterEntity entity=null;
		model.addAttribute("theaterList",theaterService.search(entity));
	}
	
	@GetMapping
	public String display(@RequestParam(required = false) Long id,@ModelAttribute("form") MovieForm form, Model model) {
		if (form.getId() > 0) {
			MovieEntity bean=service.findByPk(id);
			form.populate(bean);
		}
		return "movie";
	}
	
	
	@PostMapping
	public String submit(@RequestParam("image") MultipartFile file,@Valid @ModelAttribute("form")  MovieForm form, BindingResult bindingResult,
			Model model,HttpServletRequest request) {
		if (OP_RESET.equalsIgnoreCase(form.getOperation())) {
			return "redirect:movie";
		}
		try {
			if (OP_SAVE.equalsIgnoreCase(form.getOperation())) {
				if (bindingResult.hasErrors()) {
					return "movie";
				}
				MovieEntity bean = (MovieEntity) populateDTO(form.getBean(), request);
				bean.setImage(file.getBytes());
				bean.setTheaterName(theaterService.findByPk(bean.getTheaterId()).getName());
				if(bean.getId()>0) {
					service.update(bean);
					model.addAttribute("success", "MOVIE updated Successfully!!!!");
				}else {
				service.add(bean);
				model.addAttribute("success", "MOVIE Added Successfully!!!!");
				}
				return "movie";
			}
		} catch (DuplicateRecordException e) {
			model.addAttribute("error", e.getMessage());
			return "movie";
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}
	@RequestMapping(value = "/search", method = { RequestMethod.GET, RequestMethod.POST })
	public String searchList(@ModelAttribute("form") MovieForm form,
			@RequestParam(required = false) String operation,Long pidd,HttpSession session, Model model) {

		if (OP_RESET.equalsIgnoreCase(operation)) {
			return "redirect:/movie/search";
		}

		int pageNo = form.getPageNo();
		int pageSize = form.getPageSize();

		if (OP_NEXT.equals(operation)) {
			pageNo++;
		} else if (OP_PREVIOUS.equals(operation)) {
			pageNo--;
		}else if (OP_NEW.equals(operation)) {
			return "redirect:/movie";
		}

		pageNo = (pageNo < 1) ? 1 : pageNo;
		pageSize = (pageSize < 1) ? 10 : pageSize;

		if (OP_DELETE.equalsIgnoreCase(operation)) {
			if (form.getIds() != null) {
				for (long id : form.getIds()) {
					MovieEntity dto = new MovieEntity();
					dto.setId(id);
					service.delete(dto);
				}
				Integer[] lengths = { form.getIds().length };
				model.addAttribute("success", "Record Delete Successfully");
			} else {
				model.addAttribute("error","Select at least one Record");
			}
		}
		MovieEntity bean=(MovieEntity)form.getBean();
		List<MovieEntity> list =service.search(bean);
		List<MovieEntity> totallist =service.search(bean);
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
		return "movieList";
	}
	
	

	
	@GetMapping("/getImage/{id}")
	public void getStudentPhoto(HttpServletResponse response, @PathVariable("id") long id) throws Exception {
		response.setContentType("image/jpeg");
		Blob blb=service.getImageById(id);
		byte[] bytes = blb.getBytes(1, (int) blb.length());
		InputStream inputStream = new ByteArrayInputStream(bytes);
		IOUtils.copy(inputStream, response.getOutputStream());
	}
	
	
	
}
