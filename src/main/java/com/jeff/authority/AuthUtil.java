package com.jeff.authority;

import java.io.File;
import java.io.FilenameFilter;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jeff.util.PropertiesUtil;

/**
 * 
 * @author jeff he
 *
 */
public class AuthUtil {

	public static String roleTableName;
	public static String permissionTableName;
	public static String aclTableName;
	public static String userRoleTableName;
	public static String roleColumns;
	public static String permissionColumns;
	public static String aclColumns;
	public static String userRoleColumns;

	public static final String[] pNames = new String[] { "com.jeff.controller" };

	public static void initParam() {
		Properties props = PropertiesUtil.getProp("authority.properties");
		String roleStr = props.getProperty("role");
		String permissionStr = props.getProperty("permission");
		String aclStr = props.getProperty("acl");
		String userRoleStr = props.getProperty("user_role");
		int roleIndex = roleStr.indexOf("(");
		int permissionIndex = permissionStr.indexOf("(");
		int aclIndex = aclStr.indexOf("(");
		int userRoleIndex = userRoleStr.indexOf("(");
		roleTableName = roleStr.substring(0, roleIndex).trim();
		permissionTableName = permissionStr.substring(0, permissionIndex).trim();
		aclTableName = aclStr.substring(0, aclIndex).trim();
		userRoleTableName = userRoleStr.substring(0, userRoleIndex).trim();
		roleColumns = roleStr.substring(roleIndex).trim();
		permissionColumns = permissionStr.substring(permissionIndex).trim();
		aclColumns = aclStr.substring(aclIndex).trim();
		userRoleColumns = userRoleStr.substring(userRoleIndex).trim();
	}

	public static void main(String[] args) {
		Properties properties = PropertiesUtil.getProp("jdbc.properties");
		String url = properties.getProperty("jdbc_url");
		String username = properties.getProperty("jdbc_username");
		String password = properties.getProperty("jdbc_password");
		try {
			Connection con = DriverManager.getConnection(url, username, password);
			AuthUtil.initAuth(pNames, con);
			con.close();
		} catch (SQLException se) {
			System.out.println("数据库连接失败！");
			se.printStackTrace();
		}
	}

	/**
	 * @return
	 * @throws SQLException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void initAuth(String[] pNames, Connection connection) throws SQLException {
		try {
			for (String pName : pNames) {
				String[] ps = getClassByPackage(pName);
				for (String p : ps) {
					String pc = pName + "." + p.substring(0, p.lastIndexOf(".class"));
					// 得到了类的class对象
					Class clz = Class.forName(pc);
					System.out.println(clz.getName());
					if (!clz.isAnnotationPresent(AuthClass.class) || !clz.isAnnotationPresent(Controller.class))
						continue;
					AuthClass authClass = (AuthClass) clz.getAnnotation(AuthClass.class);
					String[] defaultRoles = authClass.defaultRoles();
					RequestMapping m1 = (RequestMapping) clz.getAnnotation(RequestMapping.class);
					String url1 = "";
					if (m1 != null) {
						if (m1.value() != null) {
							url1 = m1.value()[0];
							if (!url1.startsWith("/"))
								url1 = "/" + url1;
						}
					}
					Method[] ms = clz.getDeclaredMethods();
					/*
					 * 遍历method来判断每个method上面是否存在相应的Auth标签
					 */
					Statement statement = connection.createStatement();
					for (Method m : ms) {
						if (!m.isAnnotationPresent(Auth.class) || !m.isAnnotationPresent(RequestMapping.class))
							continue;
						Auth auth = m.getAnnotation(Auth.class);
						String[] roles = auth.roles();
						String description = auth.description();
						if (roles == null)
							roles = defaultRoles;
						RequestMapping m2 = m.getAnnotation(RequestMapping.class);
						String url2 = "";
						if (m2.value() != null) {
							url2 = m2.value()[0];
							if (!url2.startsWith("/"))
								url2 = "/" + url2;
						}
						String url = url1 + url2;
						String checkRP, checkR, checkP, insertR, insertP, insertRP;
						for (String role : roles) {
							checkRP = "select * from `acl` rp,`grade` r,`permission` p where r.id = rp.grade_id and p.id = rp.permission_id and r.name = '"
									+ role + "' and p.url = '" + url + "' ";
							if (!statement.executeQuery(checkRP).next()) {
								checkR = "select * from `grade` where name = '" + role + "'";
								if (!statement.executeQuery(checkR).next()) {
									insertR = "insert into grade (id,name) values (uuid(), '" + role + "')";
									statement.execute(insertR);
								}
								checkP = "select * from `permission` where url = '" + url + "'";
								if (!statement.executeQuery(checkP).next()) {
									insertP = "insert into `permission` (id,url,description) values (uuid(), '" + url
											+ "' , '" + description + "' )";
									statement.execute(insertP);
								}
								insertRP = "insert into `acl` (id,grade_id,permission_id) values (uuid(),(select id from `grade` where name='"
										+ role + "'), (select id from `permission` where url= '" + url + "')" + ")";
								statement.execute(insertRP);
							}
						}
					}
				}
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 根据包获取所有的类
	 * 
	 * @param pName
	 * @return
	 */
	private static String[] getClassByPackage(String pName) {
		String pr = pName.replace(".", "/");
		String pp = AuthUtil.class.getClassLoader().getResource(pr).getPath();
		File file = new File(pp);
		String[] fs = file.list(new FilenameFilter() {
			public boolean accept(File dir, String name) {
				if (name.endsWith(".class"))
					return true;
				return false;
			}
		});
		return fs;
	}

}
