package com.compsys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.compsys.session.SessionParams;

@Controller
public class MainController {

    @RequestMapping("/")
    public String index() {
    	return main();
    }

    @RequestMapping("/main")
    public String main() {
//    	if(userIsLogged()) 
//    	{
//    		return "main";	
//    	}
//    	else
//    	{
    	return "login";
//    	}
    	
    }
    
    
    public String start() {
    
        return "main";
    }
    
    public boolean firstStart() {
    	if(SessionParams.getLoggedUser().getNickname()=="")
    		return true;
    	return false;
    	
    }

}
