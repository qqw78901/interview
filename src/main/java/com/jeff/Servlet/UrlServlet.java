package com.jeff.Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class UrlServlet extends HttpServlet{
	   
    /** 
     * 查看httpservlet实现的service一看便知，起到了一个controll控制器的作用(转向的) 
     * 之后便是跳转至我们熟悉的doget,dopost等方法中  
     */  
/*    @Override  
    protected void service(HttpServletRequest req, HttpServletResponse resp)  
            throws ServletException, IOException {  
        System.out.println("doservice..."+this.getInitParameter("encoding"));  
          
        super.service(req, resp);  
    }  */
   
    @Override  
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)  
            throws ServletException, IOException {  
        System.out.println("doget...");  
        
		System.out.println(req.getRequestURL());
		System.out.println(req.getContextPath());
		System.out.println(req.getRequestURI());
		System.out.println(req.getQueryString());
		System.out.println(req.getPathInfo());
		System.out.println(req.getRemoteHost());


        doPost(req, resp);  
    }  
   
    @Override  
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)  
            throws ServletException, IOException {  
        System.out.println("dopost...");  
		String serverName = req.getServerName();
		//获得二级域名
		int end=serverName.indexOf(".");
		String SLD =serverName.substring(0,end);
		System.out.println(SLD);
		if(SLD.equalsIgnoreCase("bm")) {

		       return;
		}
		 doGet(req, resp);
    }  

}
