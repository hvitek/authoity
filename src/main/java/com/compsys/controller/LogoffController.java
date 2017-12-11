package com.compsys.controller;



import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.compsys.cookie.CookieCheck;


@Controller
@RequestMapping(value = "logoffController")
public class LogoffController {

	 private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);
	 

	    @RequestMapping(method = RequestMethod.GET)
	    public String getCreateLoginView(HttpServletResponse response) {

	        LOGGER.debug("Received request for logoff");
	        response.addCookie(CookieCheck.deleteLoginCookie());
	        return "/main";
	    }
	    
	 

}