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
		// 1����ȡ���ݿ�����
		// 1.1��ע������
		Class.forName("org.mariadb.jdbc.Driver");

		Connection conn = null;
		Statement stm = null;
		try {
			// 1.2����ȡ����
			conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/location", "gg", "123456");

			// 2������������,��ִ�С�
			stm = conn.createStatement();
			String sql = "insert into students(student_id,student_name,gender,passwd,class_id) values (" + sid + ", '"
					+ name + "', '" + gender + "', '" + pwd + "', " + classID + ")";
			count = stm.executeUpdate(sql);

			// 3�������ѯ���
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 4����Դ�ͷ�
			stm.close();
			conn.close();
		}
		return count;

	}

	public static void select(String name, String pwd) throws ClassNotFoundException, SQLException {
		// 1����ȡ���ݿ�����
		// 1.1��ע������
		Class.forName("org.mariadb.jdbc.Driver");

		Connection conn = null;
		//Statement stm = null;// �ᱻע����䡣
		PreparedStatement stm = null; // Ԥ����������
		ResultSet rst = null;
		try {
			// 1.2����ȡ����
			conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/location", "gg", "123456");

			// 2������������,��ִ�С�
			//stm = conn.createStatement();
			//String sql = "select * from students where student_name='"+name+"' and passwd='"+pwd+"'";
			String sql = "select * from students where student_name=? and passwd=?";
			System.out.println(sql);
			stm = conn.prepareStatement(sql);
			
			// ������ֵ
			stm.setString(1, name);
			stm.setString(2, pwd);
			
			rst = stm.executeQuery();

			// 3�������ѯ��� .ResultSet������ʵ����������û�����ݡ�ֻ�����ݲ�ѯ�����ָ�롣
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
			// 4����Դ�ͷ�
			rst.close();
			stm.close();
			conn.close();
		}

	}

	
	public static void get(int id) throws SQLException, ClassNotFoundException {
		// 1����ȡ���ݿ�����
				// 1.1��ע������
				Class.forName("org.mariadb.jdbc.Driver");

				Connection conn = null;
				//Statement stm = null;// �ᱻע����䡣
				CallableStatement stm = null; // ���ô洢���̵�������
				
				try {
					// 1.2����ȡ����
					conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/location", "gg", "123456");

					// 2������������,��ִ�С�
					//stm = conn.createStatement();
					//String sql = "select * from students where student_name='"+name+"' and passwd='"+pwd+"'";
					String sql = "{call p_getname(?,?)}";
					
					stm = conn.prepareCall(sql);
					
					// ������ֵ
					stm.setInt(1, id);
					// ע���������
					stm.registerOutParameter(2, Types.VARCHAR);
					
					stm.execute();

					// 3�������������
					String v = stm.getString(2);
					System.out.println(v);
					
					
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					// 4����Դ�ͷ�
		
					stm.close();
					conn.close();
				}
	}
	
	
	
	// ʲô��JDBC.java���ݿ����ӡ��ṩ��һ��API���������ǽӿڡ�DriverManager��ʵ���ࡣ
	// �ӿ��ɾ�������ݿ⳧��ʵ�֡�
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
//		int c = add(20050101, "GG", "��", "123456", 200501);
//		System.out.println(c);
		//select("dfdf' or 1=1 #", "dsfsdfs");
		//select("gg","123456");
		
		get(1);
	}
	
	

}
