package com.ljg.test.didispace.web;

import org.springframework.boot.autoconfigure.web.ErrorProperties;
import org.springframework.boot.autoconfigure.web.servlet.error.BasicErrorController;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.web.bind.annotation.RequestMapping;

// @RestController
public class ErrorController extends BasicErrorController{

	public ErrorController(ErrorAttributes errorAttributes, ErrorProperties errorProperties) {
		super(errorAttributes, errorProperties);
		// TODO Auto-generated constructor stub
	}

	@RequestMapping("/error")
	public String error () {
		return "Go to my error";
	}
}
