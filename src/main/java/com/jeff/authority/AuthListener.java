package com.jeff.authority;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.jeff.util.PropertiesUtil;

public class AuthListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {

	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		Properties properties = PropertiesUtil.getProp("jdbc.properties");
		String url = properties.getProperty("jdbc_url");
		String username = properties.getProperty("jdbc_username");
		String password = properties.getProperty("jdbc_password");
		try {
			Connection con = DriverManager.getConnection(url, username,
					password);
			AuthUtil.initAuth(AuthUtil.pNames, con);
			AuthContext.initAuthContext(con);
			con.close();
		} catch (SQLException se) {
			System.out.println("数据库连接失败！");
			se.printStackTrace();
		}
	}

}
