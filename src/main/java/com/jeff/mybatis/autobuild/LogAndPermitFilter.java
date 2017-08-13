package com.jeff.mybatis.autobuild;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 将分页的pager数据嵌入localthread中
 * 
 * @author jeff he
 *
 */
public class LogAndPermitFilter implements Filter {

	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		HttpSession session = request.getSession();
		String userId = "";
		String gId = "";
		String url = "";
		try {
			/*String displayName = request.getContextPath();
			//System.out.println(displayName);
			url = request.getRequestURL().toString();
			int i = url.indexOf("/", url.indexOf(displayName) + 1);
			int j = url.lastIndexOf(".do");
			url = url.substring(i, j);
			//System.out.println(url);
			UserLoginVo user = (UserLoginVo) session
					.getAttribute(Constant.USERSESSION);
			if (user != null) {
				userId = user.getUserId();
				gId = user.getGradeId();
				// System.out.println(gId);
			} else
				userId = "session中没有user";
			// System.out.println(userId);
			// 将LOG数据放入当前线程
			MybatisContext.setUserId(userId);
			// System.out.println(MybatisContext.getUserId());
			if (AuthContext.checkAuth(gId, url))
				chain.doFilter(req, resp);
			else {
				System.out.println("目标地址:" + url + "   未授权");
				request.getSession().setAttribute("info", "方法未授权，请先登录系统");
				response.sendRedirect(displayName + "/login.jsp");
			}*/
			chain.doFilter(req, resp);
		} catch (Exception e) {
			userId = "获取userid出现异常";
		} finally {
			// 清除LOG数据
			MybatisContext.clearContext();
		}
	}

	public void init(FilterConfig cfg) throws ServletException {

	}

	public void destroy() {

	}

}
