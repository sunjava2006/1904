package com.wangrui.location.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.wangrui.location.entity.Student;

@Mapper
public interface StudentMapper {
	
	@Select("select * from students where student_id=#{studentID} and passwd=#{passwd}")
	@Results(value = {@Result(column = "id", property = "id", id = true),
			          @Result(column = "name", property = "name"),
			          @Result(column = "passwd", property = "password"),
			          @Result(column = "gender", property = "gender"),
			          @Result(column = "class_id", property = "classID"),
			          @Result(column = "student_id", property = "studentID")
	        })
	public Student selectByIdAndPasswd(String studentID, String passwd);
}
