package com.ams.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;

@Controller
public class CustomErrorController implements ErrorController {
	 @RequestMapping("/error")
	    public String handleError(HttpServletRequest request) {
	        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);

	        if (status != null) {
	            Integer statusCode = Integer.valueOf(status.toString());

	            if (statusCode == 403) {
	                return "error/403"; 
	            }
	        }
	        return "error/403";
	    }

}
