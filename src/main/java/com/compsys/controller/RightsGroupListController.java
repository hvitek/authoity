package com.compsys.controller;

import com.compsys.model.Rightsgroup;
import com.compsys.service.RightsGroupService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

import javax.inject.Inject;

@Controller
public class RightsGroupListController {

    private static final Logger LOGGER = LoggerFactory.getLogger(RightsGroupListController.class);

    private final RightsGroupService rightsGroupService;

    @Inject
    public RightsGroupListController(final RightsGroupService rightsGroupService) {
        this.rightsGroupService = rightsGroupService;
    }

    @RequestMapping("/RightsGroupList")
    public ModelAndView getListUsersView() {
        LOGGER.debug("Received request to get rightsGroup list view");
        ModelMap model = new ModelMap();
        model.addAttribute("RightsGroupList", rightsGroupService.getList());
        return new ModelAndView("RightsGroupList", model);
    }
    
   
    
    
    @RequestMapping("/RightsGroupGetList")
    public List<Rightsgroup> getList() {
        LOGGER.debug("Received request to get rightsGroup list view");
        //ModelMap model = new ModelMap();
        List<Rightsgroup> rightsgroups = rightsGroupService.getList();
        return rightsgroups;
    }

}
