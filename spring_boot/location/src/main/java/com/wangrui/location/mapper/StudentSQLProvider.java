package com.wangrui.location.mapper;

import org.apache.ibatis.jdbc.SQL;

import com.wangrui.location.entity.Student;

public class StudentSQLProvider {

	public String updateByExample(Student stu) {
		String sqlStm = null;
		SQL sql = new SQL();
		sql.UPDATE("students");
		if(stu.getName()!=null) {
			sql.SET("name=#{name}");
		}
		if(stu.getGender()!=null) {
			sql.SET("gender=#{gender}");
		}
		if(stu.getMyClass().getID()!=null) {
			sql.SET("class_id=#{myClass.ID}");
		}
		if(stu.getPassword()!=null) {
			sql.SET("passwd=#{password}");
		}
		if(stu.getStudentID()!=null) {
			sql.WHERE("student_id=#{studentID}");
		}
		
		sqlStm = sql.toString();
		return sqlStm;
	}
}
