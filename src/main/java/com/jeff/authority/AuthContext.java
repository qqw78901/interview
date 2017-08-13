package com.jeff.authority;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

import com.jeff.util.PropertiesUtil;

public class AuthContext {

	public static HashMap<String, Set<String>> acl = new HashMap<String, Set<String>>();

	public static Set<String> freeUrls = new HashSet<String>();
	static {
		freeUrls.add("/login");
		freeUrls.add("/logout");
	}

	public static boolean checkAuth(String gradeId, String url) {
		if (acl.containsKey(gradeId))
			return acl.get(gradeId).contains(url);
		else
			return freeUrls.contains(url);
	}

	public static void initAuthContext(Connection connection)
			throws SQLException {
		Properties properties = PropertiesUtil.getProp("jdbc.properties");
		String url = properties.getProperty("jdbc_url");
		String username = properties.getProperty("jdbc_username");
		String password = properties.getProperty("jdbc_password");
		try {
			if (connection == null || connection.isClosed())
				connection = DriverManager.getConnection(url, username,
						password);
			Statement statement = connection.createStatement();
			String sql = "select g.id as gId,p.url as url from `grade` g left join `acl` a on a.grade_id = g.id join `permission` p on p.id = a.permission_id";
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String gId = rs.getString("gId");
				String pUrl = rs.getString("url");
				Set<String> urls;
				if (acl.containsKey(gId))
					urls = acl.get(gId);
				else {
					urls = new HashSet<String>();
					acl.put(gId, urls);
				}
				urls.add(pUrl);
			}
			rs.close();
			statement.close();
			connection.close();
		} catch (SQLException se) {
			System.out.println("数据库连接失败！");
			se.printStackTrace();
		}
	}

}
