package com.compsys.controller;

import com.compsys.forms.RegisterForm;
import com.compsys.forms.RightForm;
import com.compsys.exception.RightAlreadyExistsException;
import com.compsys.model.Right;
import com.compsys.model.User;
import com.compsys.service.RightService;
import com.compsys.service.UserService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.inject.Inject;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping(value = "rights")
public class LoginController {

	 private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);
	 
	 private  String username = null;
	 private  String password = null;
	 
	 private final UserService userService;

	 
	    @Inject
	    public LoginController(UserService userService) {
	        this.userService = userService;
	    }
	    
	@RequestMapping(method = RequestMethod.POST)
	public String hello(@ModelAttribute("RegisterForm") RegisterForm form) {
		username=request.getParameter("username");
		password=request.getParameter("password");
		
		
		if(loginSucced()) 
		{
			//create cookie
			Cookie cookieAuthority = new Cookie("foo", "bar"); //bake cookie
			cookieAuthority.setMaxAge(1000); //set expire time to 1000 sec
			response.addCookie(cookieAuthority); //put cookie in response 
		}
		
		
		//return main, main class will controll it
		return "redirect:/main";
		//..		
	}
	
	
	private boolean loginSucced() {
		
	        LOGGER.debug("Received request login");
	        User user = userService.getUserByUsernamePassword(this.username, this.password);
	        
	        if(user!=null)
	        	return false;
	        else
	        	return true;
	    
		
	}

}
