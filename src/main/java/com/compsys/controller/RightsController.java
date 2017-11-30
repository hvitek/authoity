package com.compsys.controller;

import com.compsys.forms.RightForm;
import com.compsys.exception.RightAlreadyExistsException;
import com.compsys.model.Right;
import com.compsys.service.RightService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.inject.Inject;

@Controller
@RequestMapping(value = "rights")
public class RightsController {

    private static final Logger LOGGER = LoggerFactory.getLogger(RightsController.class);

    private final RightService rightService;

    @Inject
    public RightsController(RightService rightService) {
        this.rightService = rightService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView getCreateUserView() {

        LOGGER.debug("Received request for addRight");
        return new ModelAndView("RightRegister", "form", new RightForm());
    }


    @RequestMapping(method = RequestMethod.POST)
    public String createRight(@ModelAttribute("form") RightForm form ) {
        LOGGER.debug("Received request to create {}, with result={}", form);

        try {
        	rightService.save(new Right(form.getName()));
        } catch (RightAlreadyExistsException e) {
            LOGGER.debug("Tried to create right with existing id", e);
            return "list";
        }
        return "redirect:/rights/list";
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ModelAndView getListUsersView() {
        LOGGER.debug("Received request to get user list view");
        ModelMap model = new ModelMap();
        model.addAttribute("RightList", rightService.getList());
        return new ModelAndView("RightList", model);
    }

}
