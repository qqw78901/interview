<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.*"%> 
<%@ page import="com.jeff.common.*"%>
<%
		//检查session 的值是否存在，如果不存在着显示错误信息
		try{
			if(request.getSession().getAttribute("username")==null){
			
				//不存在的话，自动退出。
				System.out.println("show time");
				response.sendRedirect(request.getContextPath()+"/");
				return;
			}
		}catch(Exception e){
			if(request.getSession().getAttribute("username")==null){
				//不存在的话，自动退出。
				response.sendRedirect(request.getContextPath()+"/pages/admin/index.jsp");
				return;
			}
		}	
%>	

