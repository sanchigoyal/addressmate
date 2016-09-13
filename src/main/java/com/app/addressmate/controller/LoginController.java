package com.app.addressmate.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.addressmate.constants.UserConstants;

@Controller
public class LoginController {
	
	@RequestMapping("/index")
	public String getIndexPage(HttpServletRequest request, ModelMap model) {
		HttpSession session = request.getSession();
		String login = null;
		if (session.getAttribute(UserConstants.ATTR_LOGIN) != null) {
			login = (String) session.getAttribute(UserConstants.ATTR_LOGIN);
			if (UserConstants.REQUEST_SUCCESS.equals(login) && session.getAttribute(UserConstants.USER_NAME) != null) {
				return "redirect:/home"; // This URL is for welcome page of USER
			}
			
			model.addAttribute("success","false");
			model.addAttribute("message",session.getAttribute("message"));
			/*
			 * Invalidate the session otherwise attribute "login" will continue
			 * to persist.
			 */
			session.invalidate();
		}

		// Not logged in then continue...
		return "access/index";
	}
}
