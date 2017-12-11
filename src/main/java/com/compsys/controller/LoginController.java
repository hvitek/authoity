
package com.compsys.controller;

import com.compsys.cookie.CookieCheck;
import com.compsys.cookie.Cookies;
import com.compsys.forms.LoginForm;

import com.compsys.model.User;
import com.compsys.service.UserService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


import javax.inject.Inject;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping(value = "loginController")
public class LoginController {

	 private static final Logger LOGGER = LoggerFactory.getLogger(LogoffController.class);
	 
	 private  String nickname = null;
	 private  String password = null;
	 
	 private final UserService userService;

	 
	    @Inject
	    public LoginController(UserService userService) {
	        this.userService = userService;
	        
	    }
	    
	   
	
	    
	    @RequestMapping(method = RequestMethod.GET)
	    public ModelAndView getCreateLoginView() {

	        LOGGER.debug("Received request for login");
	        return new ModelAndView("login", "form", new LoginForm());
	    }
	    
	    
	@RequestMapping(method = RequestMethod.POST)
	public String hello(@ModelAttribute("form") LoginForm form, HttpServletResponse response, HttpServletRequest request) {
		nickname=form.getNickname();
		password=form.getPassword();
		
		
		User user = userService.getUserByNicknameAndPassword(nickname, password);
		
		if(user!=null) 
		{
			LOGGER.debug("User exists - creating cookie");
			
			//if login cookie not exists
			if(!CookieCheck.checkIfExistsCookie(request, Cookies.CookieLogin))
			{
				//create them and return main
				response.addCookie(CookieCheck.createLoginCookie(user)); //create put cookie in response 
				return "/main";
			}
			else
			{
				return "/main";
			}
			
			
		}
		
		LOGGER.debug("User not exists");
		//return main, main class will controll it
		return "redirect:/";
		//..		
	}

}

