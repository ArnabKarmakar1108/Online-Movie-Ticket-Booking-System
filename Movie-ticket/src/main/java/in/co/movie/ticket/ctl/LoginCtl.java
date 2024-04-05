package in.co.movie.ticket.ctl;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

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

import in.co.movie.ticket.entity.UserEntity;
import in.co.movie.ticket.exception.DuplicateRecordException;
import in.co.movie.ticket.form.ChangePasswordForm;
import in.co.movie.ticket.form.LoginForm;
import in.co.movie.ticket.form.MyProfileForm;
import in.co.movie.ticket.form.UserRegistrationForm;
import in.co.movie.ticket.service.UserServiceInt;
import in.co.movie.ticket.util.DataUtility;

@Controller
public class LoginCtl extends BaseCtl {

	protected static final String OP_SIGNIN = "SignIn";
	protected static final String OP_SIGNUP = "SignUp";
	protected static final String OP_LOGOUT = "Logout";

	@Autowired
	private UserServiceInt service;

	@GetMapping("/login")
	public String display(@RequestParam(required = false)Long tid,@ModelAttribute("form") LoginForm form, HttpSession session, Model model) {

		System.out.println("In doget LoginCtl");

		if(DataUtility.getLong(String.valueOf(tid))>0) {
			session.setAttribute("mid",tid);
		}
		
		if (session.getAttribute("user") != null) {
			session.invalidate();
			model.addAttribute("success", "You have logged out Successfully!!!");
		}
		return "login";
	}

	@PostMapping("/login")
	public String display( HttpSession session,
			@Valid @ModelAttribute("form") LoginForm form, BindingResult result, Model model) {
		if (OP_SIGNUP.equalsIgnoreCase(form.getOperation())) {
			return "redirect:signUp";
		}
		if (result.hasErrors()) {
			System.out.println(result);
			return "login";
		}
		UserEntity bean = service.authenticate((UserEntity) form.getBean());
		if (bean != null) {
			System.out.println(bean.toString());
			session.setAttribute("user", bean);
			long tid=DataUtility.getLong(String.valueOf(session.getAttribute("mid")));
			if(tid>0) {
				return "redirect:/invoice?mId="+tid;
			}else {
				return "redirect:/home";
			}
		}
		model.addAttribute("error", "Login Id Password Invalid");
		return "login";
	}
	

	@GetMapping("/signUp")
	public String display(@ModelAttribute("form") UserRegistrationForm form, Model model) {
		Map<String, String> genderMap = new LinkedHashMap<String, String>();
		genderMap.put("Female", "Female");
		genderMap.put("Male", "Male");
		model.addAttribute("genderMap", genderMap);
		return "signUp";
	}

	@PostMapping("/signUp")
	public String submit(@RequestParam String operation,@Valid @ModelAttribute("form") UserRegistrationForm form, BindingResult bindingResult,
			Model model,HttpServletRequest request) {
		if (OP_RESET.equalsIgnoreCase(operation)) {
			return "redirect:signUp";
		}
		Map<String, String> genderMap = new LinkedHashMap<String, String>();
		genderMap.put("Female", "Female");
		genderMap.put("Male", "Male");
		model.addAttribute("genderMap", genderMap);
		try {
			if (OP_SAVE.equalsIgnoreCase(operation)) {
				System.out.println("in Save");
				if (bindingResult.hasErrors()) {
					System.out.println(bindingResult);
					return "signUp";
				}
				UserEntity bean = (UserEntity) populateDTO(form.getBean(), request);
				System.out.println(bean.toString());
				bean.setRoleId(2L);
				service.registerUser(bean);
				model.addAttribute("success", "User Registerd Successfully!!!!");
				return "signUp";
			}
		} catch (DuplicateRecordException e) {
			model.addAttribute("error", e.getMessage());
			return "signUp";
		}
		return "signUp";
	}
	
	@RequestMapping(value = "/ctl/profile", method = RequestMethod.GET)
	public String displayProfile(HttpSession session, @ModelAttribute("form") MyProfileForm form, Model model) {
		UserEntity entity = (UserEntity) session.getAttribute("user");
		form.populate(entity);

		System.out.println("/Myprofile");
		return "myprofile";
	}

	
	@RequestMapping(value = "/ctl/profile", method = RequestMethod.POST)
	public String submitProfile(HttpSession session, @ModelAttribute("form") @Valid MyProfileForm form,BindingResult bindingResult,
			@RequestParam(required = false) String operation,  Model model) {


		if (OP_RESET.equalsIgnoreCase(operation)) {
			return "redirect:/ctl/profile";
		}

		if (bindingResult.hasErrors()) {
			return "myprofile";
		}
		UserEntity entity = (UserEntity) session.getAttribute("user");
		entity = service.findByPK(entity.getId());
		entity.setFirstName(form.getFirstName());
		entity.setLastName(form.getLastName());
		entity.setMobileNo(form.getMobileNo());
		try {
			service.update(entity);
		} catch (DuplicateRecordException e) {

		}
		model.addAttribute("success", "Profile Update successfully");

		return "myprofile";
	}

	@RequestMapping(value = "/ctl/changepassword", method = RequestMethod.GET)
	public String displayChangePassword(@ModelAttribute("form") ChangePasswordForm form, Model model) {
		return "changePassword";
	}
	
	@RequestMapping(value = "/ctl/changepassword", method = RequestMethod.POST)
	public String submitChangePassword(HttpSession session,
			@ModelAttribute("form") @Valid ChangePasswordForm form, BindingResult bindingResult, Model model) {

		if (bindingResult.hasErrors()) {
			return "changePassword";
		}
		if(form.getNewPassword().equalsIgnoreCase(form.getConfirmPassword())) {

		UserEntity dto = (UserEntity) session.getAttribute("user");
		dto = service.findByPK(dto.getId());
		
		if (service.changePassword(dto.getId(), form.getOldPassword(),form.getNewPassword())) {
			model.addAttribute("success","Password Changed Successfully");
		} else {
			model.addAttribute("error","Old Passoword Not Matched");
		}
		}else {
			model.addAttribute("error","New Password and Confirm Password Not Matched");
		}
		return "changePassword";
	}

}