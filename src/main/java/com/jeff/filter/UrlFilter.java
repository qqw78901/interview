package com.jeff.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.ContextLoader;

import com.jeff.service.FormService;

public class UrlFilter implements Filter {
	FormService formService = null;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		formService =(FormService) ContextLoader.getCurrentWebApplicationContext().getBean("formServiceImpl");
	}

	@Override
	public void doFilter(ServletRequest servletRequest,
			ServletResponse servletresponse, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletresponse;
		System.out.println("二级域名拦截");
		String serverName = request.getServerName();
		System.out.println(serverName+request.getRequestURL());
		int endIndex = serverName.indexOf(".");
		if (endIndex != -1) {//输入的是域名而不是localhost
			String domain = serverName.substring(0, endIndex);// 获取二级域名
			System.out.println("截取到的二级域名是:"+domain);
			if(isNumeric(domain)) {
				chain.doFilter(servletRequest, servletresponse);
				return;
			}else {
				if (domain != null) {
					if (!domain.equalsIgnoreCase("www")
							&& !domain.equalsIgnoreCase("")) {
						// 判断是否在输入自定义二级域名

						try {
							String URI = request.getRequestURI();
							if (URI.equalsIgnoreCase("/")) {
								/*String formId = formService.getIdByDomain(domain);// 获取域名对应的id
								System.out.println(domain+"获取的formid是"+formId);
								request.getSession();
								response.sendRedirect("/pages/entry/entry.jsp?form="+formId);
								System.out.println(URI+"外网服务器转发完成"+request.getRequestURL());*/
								
								System.out.println("本次转发uri"+URI);
								String formId = formService.getIdByDomain(domain);// 获取域名对应的id
								System.out.println(domain+"获取的formid是"+formId);
								request.getSession();
								request.getRequestDispatcher("//pages/entry/entry.jsp?form="+formId).forward(servletRequest, servletresponse);
								System.out.println("本地服务器转发完成"+request.getRequestURL());
							}else if(URI.equalsIgnoreCase("/community/")) {//本地tomcat
								System.out.println("本次转发uri"+URI);
								String formId = formService.getIdByDomain(domain);// 获取域名对应的id
								System.out.println(domain+"获取的formid是"+formId);
								request.getSession();
								request.getRequestDispatcher("//pages/entry/entry.jsp?form="+formId).forward(servletRequest, servletresponse);
								System.out.println("本地服务器转发完成"+request.getRequestURL());
								
//								response.sendRedirect("/community/pages/entry/entry.jsp?form="+formId);
							}

						} catch (Exception e) {
						
							System.out.println("重定向过程出错,URI:"+request.getRequestURI());
							System.out.println(request.getRequestURL());
							System.out.println(request.getContextPath());
							System.out.println(request.getRequestURI());
							System.out.println(request.getQueryString());
							System.out.println(request.getPathInfo());
							System.out.println(request.getRemoteHost());
							System.out.println(request.getServerName());
							e.printStackTrace();
						}
					}
				}
			}

		}
		chain.doFilter(servletRequest, servletresponse);
	}

	@Override
	public void destroy() {
		// TODO 自动生成的方法存根

	}
	public static boolean isNumeric(String str){
		  for (int i = 0; i < str.length(); i++){
		   System.out.println(str.charAt(i));
		   if (!Character.isDigit(str.charAt(i))){
		    return false;
		   }
		  }
		  return true;
		 }


	public String getPage(String URI, String contextPath) {

		try {
			System.out.println("输入的URI:" + URI);
			String[] sp = URI.split("/");
			if (sp.length == 0)
				return URI;
			String page = sp[sp.length - 1];
			System.out.println("AGE:" + page);
			if (URI.equalsIgnoreCase("") || URI.equalsIgnoreCase("/")
					|| URI.equalsIgnoreCase("community")) {
				URI = "/pages/admin/index.jsp?form=088f868a-8bd2-4c17-845f-9c1f94555962";
			}

		} catch (Exception e) {
			// TODO: handle exception
		}

		return URI;
	}

}
