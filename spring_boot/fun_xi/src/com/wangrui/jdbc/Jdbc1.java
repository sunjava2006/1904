package com.wangrui.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLType;
import java.sql.Statement;
import java.sql.Types;

public class Jdbc1 {

	public static int add(int sid, String name, String gender, String pwd, int classID)
			throws ClassNotFoundException, SQLException {
		int count = -1;
		// 1、获取数据库连接
		// 1.1、注册驱动
		Class.forName("org.mariadb.jdbc.Driver");

		Connection conn = null;
		Statement stm = null;
		try {
			// 1.2、获取连接
			conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/location", "gg", "123456");

			// 2、创建语句对象,并执行。
			stm = conn.createStatement();
			String sql = "insert into students(student_id,student_name,gender,passwd,class_id) values (" + sid + ", '"
					+ name + "', '" + gender + "', '" + pwd + "', " + classID + ")";
			count = stm.executeUpdate(sql);

			// 3、处理查询结果
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 4、资源释放
			stm.close();
			conn.close();
		}
		return count;

	}

	public static void select(String name, String pwd) throws ClassNotFoundException, SQLException {
		// 1、获取数据库连接
		// 1.1、注册驱动
		Class.forName("org.mariadb.jdbc.Driver");

		Connection conn = null;
		//Statement stm = null;// 会被注入语句。
		PreparedStatement stm = null; // 预编译语句对象
		ResultSet rst = null;
		try {
			// 1.2、获取连接
			conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/location", "gg", "123456");

			// 2、创建语句对象,并执行。
			//stm = conn.createStatement();
			//String sql = "select * from students where student_name='"+name+"' and passwd='"+pwd+"'";
			String sql = "select * from students where student_name=? and passwd=?";
			System.out.println(sql);
			stm = conn.prepareStatement(sql);
			
			// 参数赋值
			stm.setString(1, name);
			stm.setString(2, pwd);
			
			rst = stm.executeQuery();

			// 3、处理查询结果 .ResultSet，但是实际上这里面没有数据。只是数据查询结果的指针。
			while(rst.next()) {
				int id = rst.getInt(1);
				int sid = rst.getInt("student_id");
				String sname = rst.getString("student_name");
				String pw = rst.getString(4);
				System.out.println(id + ","+ sid+","+sname +","+pw);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 4、资源释放
			rst.close();
			stm.close();
			conn.close();
		}

	}

	
	public static void get(int id) throws SQLException, ClassNotFoundException {
		// 1、获取数据库连接
				// 1.1、注册驱动
				Class.forName("org.mariadb.jdbc.Driver");

				Connection conn = null;
				//Statement stm = null;// 会被注入语句。
				CallableStatement stm = null; // 调用存储过程的语句对象
				
				try {
					// 1.2、获取连接
					conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/location", "gg", "123456");

					// 2、创建语句对象,并执行。
					//stm = conn.createStatement();
					//String sql = "select * from students where student_name='"+name+"' and passwd='"+pwd+"'";
					String sql = "{call p_getname(?,?)}";
					
					stm = conn.prepareCall(sql);
					
					// 参数赋值
					stm.setInt(1, id);
					// 注册输出参数
					stm.registerOutParameter(2, Types.VARCHAR);
					
					stm.execute();

					// 3、处理输出参数
					String v = stm.getString(2);
					System.out.println(v);
					
					
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					// 4、资源释放
		
					stm.close();
					conn.close();
				}
	}
	
	
	
	// 什么是JDBC.java数据库连接。提供了一套API，基本上是接口。DriverManager是实现类。
	// 接口由具体的数据库厂家实现。
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
//		int c = add(20050101, "GG", "男", "123456", 200501);
//		System.out.println(c);
		//select("dfdf' or 1=1 #", "dsfsdfs");
		//select("gg","123456");
		
		get(1);
	}
	
	

}
