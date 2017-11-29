package com.compsys.controller;

import com.compsys.exception.RightAlreadyExistsException;
import com.compsys.model.Right;
import com.compsys.service.RightService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.inject.Inject;

@Controller
public class RightController {

    private static final Logger LOGGER = LoggerFactory.getLogger(RightController.class);

    private final RightService rightService;

    @Inject
    public RightController(RightService rightService) {
        this.rightService = rightService;
    }

    @RequestMapping(value = "RightRegister", method = RequestMethod.GET)
    public ModelAndView getCreateUserView() {

        LOGGER.debug("Received request for addRight");
        return new ModelAndView("RightRegister", "form", new RightForm());
    }


    @RequestMapping(value = "RightRegister", method = RequestMethod.POST)
    public String createRight(@ModelAttribute("form") RightForm form ) {
        LOGGER.debug("Received request to create {}, with result={}", form);

        try {
        	rightService.save(new Right(form.getName()));
        } catch (RightAlreadyExistsException e) {
            LOGGER.debug("Tried to create right with existing id", e);
            return "right_create";
        }
        return "redirect:/";
    }

}
