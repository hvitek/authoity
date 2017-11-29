package com.compsys.controller;

import com.compsys.service.RightService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.inject.Inject;

@Controller
public class RightListController {

    private static final Logger LOGGER = LoggerFactory.getLogger(RightListController.class);

    private final RightService rightService;

    @Inject
    public RightListController(final RightService rightService) {
        this.rightService = rightService;
    }

    @RequestMapping("/RightList")
    public ModelAndView getListUsersView() {
        LOGGER.debug("Received request to get user list view");
        ModelMap model = new ModelMap();
        model.addAttribute("RightList", rightService.getList());
        return new ModelAndView("RightList", model);
    }

}
