package com.compsys.controller;

import com.compsys.forms.RegisterForm;
import com.compsys.exception.UserAlreadyExistsException;
import com.compsys.forms.RightGroup;
import com.compsys.model.RightsGroup;
import com.compsys.model.User;
import com.compsys.service.RightsGroupService;
import com.compsys.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.inject.Inject;
import java.util.Optional;

@Controller
@RequestMapping(value = "users")
public class UserController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    private final UserService userService;

    private final RightsGroupService rightsGroupService;

    @Inject
    public UserController(UserService userService, RightsGroupService rightsGroupService) {
        this.userService = userService;
        this.rightsGroupService = rightsGroupService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView getCreateUserView() {
        LOGGER.debug("Received request for register");
        ModelAndView model = new ModelAndView("UserRegister", "register-form", new RegisterForm());
        model.addObject("rightsgroup", rightsGroupService.getAllAsMap());
        model.addObject("rightgroup", new RightsGroup());
        model.addObject("users",userService.getList());
        return model;
    }
  

    @RequestMapping(method = RequestMethod.POST)
    public String createUser(@ModelAttribute("RegisterForm") RegisterForm form) {
        LOGGER.debug("Received request to create {}, with result={}", form);

        try {
            Optional<RightsGroup> rightGroup = rightsGroupService.getById(Long.valueOf(form.getRightgroup()));
            User user = new User(form.getFirstName(), form.getLastName(), form.getNickName(), form.isActive());

            if(rightGroup.isPresent()){
                user.setRightsGroup(rightGroup.get());
            }

            userService.save(user);
        } catch (UserAlreadyExistsException e) {
            LOGGER.debug("Tried to create user with existing id", e);
            return "user";
        }
        return "redirect:/users";
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ModelAndView getListUsersView() {
        LOGGER.debug("Received request to get user list view");
        ModelMap model = new ModelMap();
        model.addAttribute("UserList", userService.getList());
        return new ModelAndView("UserList", model);
    }

}
