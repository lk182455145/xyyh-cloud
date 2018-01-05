package com.xyyh.cloud.auth.server.controllers;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@SessionAttributes("authorizationRequest")
@Controller
public class SelfApprovalEndpoint {

	@RequestMapping("/oauth/error")
	public ModelAndView handleError() {
		return null;
	}

	@RequestMapping("/oauth/confirm_access")
	public ModelAndView getAccessConfirmation(Map<String, Object> model, HttpServletRequest request) throws Exception {
		if (request.getAttribute("_csrf") != null) {
			model.put("_csrf", request.getAttribute("_csrf"));
		}
		System.out.println(model);
		return new ModelAndView("oauth2/confirm_access", model);
	}

}
