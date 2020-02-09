package com.thzhima.advance.jdbc;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnHelp {

	static {
		// 1、安装驱动
		Driver driver = null; // Driver是接口
		driver = new org.mariadb.jdbc.Driver(); // 驱动的实现，是由具体的数据库厂家实现。
		try {
			DriverManager.registerDriver(driver);// DriverManager是JDBC中不多的实现类。
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static Connection getConnection() throws SQLException {
		Connection c = null;
		c = DriverManager.getConnection("jdbc:mariadb://localhost:3306/location", "gg", "123456");
		return c;
	}
}
