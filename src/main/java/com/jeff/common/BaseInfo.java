/*
 * Created on 2005-7-1
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.jeff.common;

import java.util.HashMap;
import java.util.HashSet;

import java.util.Map;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


/**
 * @author Administrator
 * 
 *         TODO To change the template for this generated type comment go to
 *         Window - Preferences - Java - Code Style - Code Templates
 */
public class BaseInfo {

	public static String Getyzm(HttpServletRequest request)// 验证码
	{
		String syzm = "";
		if (request.getSession().getAttribute("rand") != null) {
			syzm = request.getSession().getAttribute("rand").toString();// 验证码
		}
		return syzm;
	}

	public static String GetIp(HttpServletRequest request)// ip
	{
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || ip.equalsIgnoreCase("unknown")) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || ip.equalsIgnoreCase("unknown")) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || ip.equalsIgnoreCase("unknown")) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}

	// 登录名
	public static String GetUserName(HttpServletRequest request) {
		String username = "";
		if (request.getSession().getAttribute("username") != null) {
			username = request.getSession().getAttribute("username").toString();
		}
		return username;
	}

	// 登录名
	public static void SetUserName(HttpServletRequest request, String username) {
		request.getSession().setAttribute("username", username);
	}

	// 用户名
	public static String GetName(HttpServletRequest request) {
		String username = "";
		if (request.getSession().getAttribute("name") != null) {
			username = request.getSession().getAttribute("name").toString();
		}
		return username;
	}

	// 用户名
	public static void SetName(HttpServletRequest request, String username) {
		request.getSession().setAttribute("name", username);
	}

	// 用户机构名
	public static String GetUserDeptName(HttpServletRequest request) {
		String deptname = "";
		if (request.getSession().getAttribute("deptname") != null) {
			deptname = request.getSession().getAttribute("deptname").toString();
		}
		return deptname;
	}

	// 用户机构名
	public static void SetUserDeptName(HttpServletRequest request, String deptname) {
		request.getSession().setAttribute("deptname", deptname);
	}

	// 用户机构id
	public static String GetUserDeptId(HttpServletRequest request) {
		String deptid = "";
		if (request.getSession().getAttribute("deptid") != null) {
			deptid = request.getSession().getAttribute("deptid").toString();
		}
		return deptid;
	}

	// 用户机构id
	public static void SetUserDeptId(HttpServletRequest request, String deptid) {
		request.getSession().setAttribute("deptid", deptid);
	}

	// 用户角色
	public static String GetUserGrade(HttpServletRequest request) {
		String usergrade = "";
		if (request.getSession().getAttribute("usergrade") != null) {
			usergrade = request.getSession().getAttribute("usergrade").toString();
		}
		return usergrade;
	}

	// 用户角色
	public static void SetUserGrade(HttpServletRequest request, String usergrade) {
		request.getSession().setAttribute("usergrade", usergrade);
	}

	// 用户角色id
	public static String GetUserGradeId(HttpServletRequest request) {
		String usergradeid = "";
		if (request.getSession().getAttribute("usergradeid") != null) {
			usergradeid = request.getSession().getAttribute("usergradeid").toString();
		}
		return usergradeid;
	}

	// 用户角色id
	public static void SetUserGradeId(HttpServletRequest request, String usergradeid) {
		request.getSession().setAttribute("usergradeid", usergradeid);
	}

	// 用户id
	public static String GetUserId(HttpServletRequest request) {
		String userId = "";
		if (request.getSession().getAttribute("userId") != null) {
			userId = request.getSession().getAttribute("userId").toString();
		}
		return userId;
	}

	// 用户id
	public static void setUserId(HttpServletRequest request, String id) {
		request.getSession().setAttribute("userId", id);
	}

	// 在线人数
	public static int GetuserNum(HttpServletRequest request) {
		int num = 0;
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			@SuppressWarnings("unchecked")
			Set<HttpSession> clients = (Set<HttpSession>) request.getSession().getServletContext()
					.getAttribute("clients");
			if (clients == null) {
				clients = new HashSet<HttpSession>();
				request.getSession().getServletContext().setAttribute("clients", clients);
			}
			num = clients.size();
		} catch (Exception e) {
			e.printStackTrace();
			map.put("message", "系统异常");
			map.put("success", false);
		}
		return num;
	}

	/**
	 * 返回访问的基础路径
	 * 
	 * @param request
	 * @return 如 http://192.168.1.114:8080/zsy3
	 */
	public static String getBasePath(HttpServletRequest request) {
		String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
				+ request.getContextPath();
		return basePath;
	}

	// 考试试卷id
	public static void SetPaperId(HttpServletRequest request, String paperId) {
		request.getSession().setAttribute("paperId", paperId);
	}

	// 考试试卷id
	public static String GetPaperId(HttpServletRequest request) {
		String paperId = "";
		if (request.getSession().getAttribute("paperId") != null) {
			paperId = request.getSession().getAttribute("paperId").toString();
		}
		return paperId;
	}

	// 理论、临床、外语、其他的CourseSubjectId
	public static void setCoursesetSubjectId(HttpServletRequest request, String csId) {
		request.getSession().setAttribute("coursesetSubjectId", csId);
	}

	public static String getCourseSubjectId(HttpServletRequest request) {
		String csId = "";
		if (request.getSession().getAttribute("coursesetSubjectId") != null) {
			csId = request.getSession().getAttribute("coursesetSubjectId").toString();
		}
		return csId;
	}

	// 根据coursesetSubjectId获取在线学习人数
	public static int getStudyUserNum(HttpServletRequest request, String csId) {
		ServletContext context = request.getSession().getServletContext();
		@SuppressWarnings("unchecked")
		Map<String, Set<HttpSession>> map = (Map<String, Set<HttpSession>>) context.getAttribute("studyClientsMap");
		if (map == null) {
			return 0;
		}
		Set<HttpSession> studyClients = map.get(csId);
		if (studyClients == null) {
			return 0;
		} else {
			return studyClients.size();
		}
	}

	// 获取adminId
	public static String getAdminId(HttpServletRequest request) {
		String adminId = "";
		if (request.getSession().getAttribute("adminId") != null) {
			adminId = request.getSession().getAttribute("adminId").toString();
		}
		return adminId;
	}

	// 设置adminId
	public static void setAdminId(HttpServletRequest request, String adminId) {
		request.getSession().setAttribute("adminId", adminId);
	}

}
