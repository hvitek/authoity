package com.compsys.controller;

import com.compsys.service.RightsGroupService;
import com.compsys.service.RightsGroupServiceImpl;
import com.compsys.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.inject.Inject;

@Controller
public class UserListController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserListController.class);

    private final UserService userService;

    
    @Inject
    public UserListController(final UserService userService) {
        this.userService = userService;
    }
    
    

    @RequestMapping("/UserList")
    public ModelAndView getListUsersView() {
        LOGGER.debug("Received request to get user list view");
        ModelMap model = new ModelMap();
        model.addAttribute("UserList", userService.getList());
        
        
        model.addAttribute("RightsList", userService.getList());
        return new ModelAndView("UserList", model);
    }
    
    
    
    
   

}
