package com.ljg.test.didispace.web;

import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	
	public static String strHelloWorld = "hello world!";
	
	private final Logger logger = Logger.getLogger( getClass() );
	
	@Autowired
	private DiscoveryClient client;

	@RequestMapping( value = "/hello", method = RequestMethod.GET )
	public String index () {
		String serviceInfo = "";
		List<String> serviceList = client.getServices();
		for ( String serviceId : serviceList ) {
			for ( ServiceInstance instance : client.getInstances( serviceId ) ) {
				serviceInfo += "ELLLJJJ Service name: " + instance.getHost() + " Service Id: " + instance.getServiceId() + "\n";  
				logger.info( serviceInfo );
			}
		}

		return strHelloWorld + "\n" + serviceInfo;
	}
}
