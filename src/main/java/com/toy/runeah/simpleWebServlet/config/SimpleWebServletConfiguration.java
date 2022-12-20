package com.toy.runeah.simpleWebServlet.config;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class SimpleWebServletConfiguration implements Servlet {
	
	private ServletConfig config;
    // web container will call this 
    // method by passing ServletConfig 
    public void init(ServletConfig config){
       this.config=config;
    }
 
    public void service(ServletRequest request, ServletResponse response){
       // pass <param-name> to get <param-value>
       String username=config.getInitParameter("username"); // xyz
       String password=config.getInitParameter("password"); // welcome@123
       System.out.println(username);
       System.out.println(password);
    }
 
    public void destroy(){
 
    }
 
    public ServletConfig getServletConfig(){
       return config;
    }
 
    public String getServletInfo(){
       return this.getClass().getName();
    }

}
