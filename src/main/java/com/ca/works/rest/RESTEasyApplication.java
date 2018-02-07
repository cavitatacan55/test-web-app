package com.ca.works.rest;

import java.util.HashSet;
import java.util.Set;

//import java.util.HashSet;
//import java.util.Set;
 
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/rest")
public class RESTEasyApplication extends Application {

	public RESTEasyApplication() {
		
	}
	
	@Override
	public Set<Object> getSingletons() {
		HashSet<Object> set = new HashSet<Object>();
		return set;
	}
}
