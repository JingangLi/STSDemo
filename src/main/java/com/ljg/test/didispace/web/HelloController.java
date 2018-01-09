package com.ljg.test.didispace.web;

import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	
	public static String strHelloWorld = "hello world!";
	
	private final Logger logger = Logger.getLogger( getClass() );
	
	@Autowired
	private DiscoveryClient client;

	@RequestMapping( value = "/hello", method = RequestMethod.GET )
	public String index() {
		return "<br> " + strHelloWorld + " </br>" 
				+ "<br> " + getServiceInfo() + " </br>";
	}
	
	@RequestMapping( value = "/hello1", method = RequestMethod.GET )
	public String hello ( @RequestParam String name ) {
		return "<br> " + "Hello " + name + " </br>" 
				+ "<br> " + getServiceInfo() + " </br>";
	}
	
	@RequestMapping( value = "/hello2", method = RequestMethod.GET )
	public String hello ( @RequestHeader String name, @RequestHeader Integer age ) {

		return "<br> " + "Hello " + new User( name, age ) + " </br>" 
				+ "<br> " + getServiceInfo() + " </br>";
	}
	
	@RequestMapping( value = "/hello3", method = RequestMethod.GET )
	public String hello ( @RequestBody User user ) {

		return "<br> " + "Hello " + user + " </br>" 
				+ "<br> " + getServiceInfo() + " </br>";
	}

	String getServiceInfo()
	{
		String serviceInfo = "";
		
		List<String> serviceList = client.getServices();
		for ( String serviceId : serviceList ) {
			for ( ServiceInstance instance : client.getInstances( serviceId ) ) {
				serviceInfo += "[Service name: " + instance.getHost() + " --- Service Id: " + instance.getServiceId() + ":" +instance.getPort() + "] ";  
				logger.info( serviceInfo );
			}
		}
		
		return serviceInfo;
	}
}
