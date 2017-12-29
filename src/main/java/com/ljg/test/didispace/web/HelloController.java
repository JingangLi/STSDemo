package com.ljg.test.didispace.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	
	public static String strHelloWorld = "hello world!";

	@RequestMapping("/hello")
	public String index () {
		return strHelloWorld;
	}
}
