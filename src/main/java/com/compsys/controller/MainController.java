package com.compsys.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.compsys.cookie.CookieCheck;
import com.compsys.cookie.Cookies;
import com.compsys.session.SessionParams;

@Controller
public class MainController {

    @RequestMapping("/")
    public String index( HttpServletRequest request) {
    	return main(request);
    }

    @RequestMapping("/main")
    public String main( HttpServletRequest request) {
    	
    	if(CookieCheck.checkIfExistsCookie(request, Cookies.CookieLogin))
    		return "/main";
    	else
    		//return "/main";
    		return "/login";
    		
    	
    }
  
}
