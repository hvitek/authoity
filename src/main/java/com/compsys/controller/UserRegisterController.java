package com.compsys.controller;

import com.compsys.exception.UserAlreadyExistsException;
import com.compsys.model.Rightsgroup;
import com.compsys.model.User;
import com.compsys.service.RightsGroupService;
import com.compsys.service.RightsGroupServiceImpl;
import com.compsys.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

import javax.inject.Inject;

@Controller
public class UserRegisterController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserRegisterController.class);

    private final UserService userService;

    @Inject
    public UserRegisterController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "UserRegister", method = RequestMethod.GET)
    public ModelAndView getCreateUserView() {

        LOGGER.debug("Received request for register");
        return new ModelAndView("UserRegister", "form", new RegisterForm());
    }

  

    @RequestMapping(value = "UserRegister", method = RequestMethod.POST)
    public String createUser(@ModelAttribute("form") RegisterForm form ) {
        LOGGER.debug("Received request to create {}, with result={}", form);

        try {
            userService.save(new User(form.getFirstName(), form.getLastName(), form.getNickName(), form.isActive()));
        } catch (UserAlreadyExistsException e) {
            LOGGER.debug("Tried to create user with existing id", e);
            return "user_create";
        }
        return "redirect:/";
    }

}
