package com.compsys.controller;

import com.compsys.exception.RightsGroupAlreadyExistsException;
import com.compsys.forms.RightsGroupForm;
import com.compsys.model.RightsGroup;
import com.compsys.service.RightService;
import com.compsys.service.RightsGroupService;
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
import java.util.List;

@Controller
@RequestMapping(value = "rightsGroupController")
public class RightsGroupController {

    private static final Logger LOGGER = LoggerFactory.getLogger(RightsGroupController.class);

    private final RightsGroupService rightsGroupService;

    private final RightService rightService;

    @Inject
    public RightsGroupController(RightsGroupService rightsGroupService, RightService rightService) {
        this.rightsGroupService = rightsGroupService;
        this.rightService = rightService;
    }

    @RequestMapping( method = RequestMethod.GET)
    public ModelAndView getRightsGroupView() {
        LOGGER.debug("Received request for addRight");
        ModelAndView model = new ModelAndView("RightsGroupRegister", "form", new RightsGroupForm());
        model.addObject("rights",rightService.getAllAsMap());
        return model;
    }

    @RequestMapping(method = RequestMethod.POST)
    public String createRightsGroup(@ModelAttribute("form") RightsGroupForm form) {
        LOGGER.debug("Received request to create {}, with result={}", form); 
        
        try {
        	rightsGroupService.save(new RightsGroup(form.getName(),form.getRights()));
        } catch (RightsGroupAlreadyExistsException e) {
            LOGGER.debug("Tried to create rightsgroup with existing id", e);
            return "right_create";
        }
        return "redirect:/rightsGroupController/list";
    }


    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ModelAndView getList() {
        LOGGER.debug("Received request to get rightsGroup list view");
        ModelMap model = new ModelMap();
        model.addAttribute("RightsGroupList", rightsGroupService.getList());
        return new ModelAndView("RightsGroupList",model);
    }

}
