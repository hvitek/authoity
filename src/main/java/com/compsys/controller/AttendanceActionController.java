package com.compsys.controller;

import com.compsys.forms.AttendanceActionForm;
import com.compsys.forms.LoginForm;
import com.compsys.forms.RegisterForm;
import com.compsys.cookie.CookieCheck;
import com.compsys.cookie.Cookies;
import com.compsys.exception.AttendanceActionAlreadyExistsException;
import com.compsys.model.AttendanceAction;
import com.compsys.model.RightsGroup;
import com.compsys.service.AttendanceActionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "attendanceActionController")
public class AttendanceActionController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AttendanceActionController.class);

    private final AttendanceActionService attendanceActionService;

    @Inject
    public AttendanceActionController(AttendanceActionService attendanceActionService) {
        this.attendanceActionService = attendanceActionService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView getCreateAttendanceActionView(HttpServletRequest request) {

    	
    	
    	if(CookieCheck.checkIfExistsCookie(request, Cookies.CookieLogin))
		{

            LOGGER.debug("Received request for addAttendandeActinon");
            return new ModelAndView("AttendanceActionRegister", "form", new AttendanceActionForm());
		}
	else 
		{
			LOGGER.debug("Not logged");
			return new ModelAndView("login", "form", new LoginForm());
		}
    	
    	
    }


    @RequestMapping(method = RequestMethod.POST)
    public String createAttendanceAction(@ModelAttribute("form") AttendanceActionForm form ) {
        LOGGER.debug("Received request to create {}, with result={}", form);

        try {
        	attendanceActionService.save(new AttendanceAction(form.getName(), form.getIsincoming(), form.getIsoutcoming()));
        } catch (AttendanceActionAlreadyExistsException e) {
            LOGGER.debug("Tried to create attendanceAction with existing id", e);
            return "list";
        }
        return "redirect:/attendanceActionController/list";
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ModelAndView getListAttendanceActionsView() {
        LOGGER.debug("Received request to get attendanceAction list view");
        ModelMap model = new ModelMap();
        model.addAttribute("AttendanceActionList", attendanceActionService.getList());
        return new ModelAndView("AttendanceActionList", model);
    }

}
