package com.compsys.controller;

import com.compsys.exception.RightsGroupAlreadyExistsException;
import com.compsys.model.Rightsgroup;
import com.compsys.service.RightsGroupService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.inject.Inject;

@Controller
public class RightsGroupController {

    private static final Logger LOGGER = LoggerFactory.getLogger(RightsGroupController.class);

    private final RightsGroupService rightsGroupService;

    @Inject
    public RightsGroupController(RightsGroupService rightsGroupService) {
        this.rightsGroupService = rightsGroupService;
    }

    @RequestMapping(value = "RightsGroupRegister", method = RequestMethod.GET)
    public ModelAndView getRightsGroupView() {

        LOGGER.debug("Received request for addRight");
        return new ModelAndView("RightsGroupRegister", "form", new RightsGroupForm());
    }
    
    
    


    @RequestMapping(value = "RightsGroupRegister", method = RequestMethod.POST)
    public String createRightsGroup(@ModelAttribute("form") RightsGroupForm form ) {
        LOGGER.debug("Received request to create {}, with result={}", form);

        try {
        	rightsGroupService.save(new Rightsgroup(form.getName(),form.getRights()));
        } catch (RightsGroupAlreadyExistsException e) {
            LOGGER.debug("Tried to create rightsgroup with existing id", e);
            return "right_create";
        }
        return "redirect:/";
    }

}
