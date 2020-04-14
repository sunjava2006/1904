package com.thzhima.fuxi.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.thzhima.fuxi.bean.Student;

public interface StudentMapper {

	@Insert("insert into students(student_id, student_name, gender, passwd, class_id) values (#{studentID}, #{studentName}, #{gender}, #{passwd}, #{classID})")
	public void add(Student s);
	
	
	@Select("select * from students where student_name=#{studentName} and passwd=#{passwd}")
	@Results(id = "StudentMapper",
	         value = {@Result(column = "id", property = "ID", id = true),
	        		  @Result(column = "student_id", property = "studentID"),
	        		  @Result(column = "student_name", property = "studentName"),
	        		  @Result(column = "gender", property = "gender"),
	        		  @Result(column = "passwd", property = "passwd"),
	        		  @Result(column = "class_id", property = "classID")})
	public Student find(@Param("studentName") String studentName,@Param("passwd") String passwd);
	
	
	@Select("SELECT * FROM students ORDER BY id DESC LIMIT #{idx},#{len};")
	@ResultMap(value = "StudentMapper")
	public List<Student> list(@Param("idx") int idx, @Param("len") int len);
	
	@Select(value="select count(*) from students")
	public long totalCount();
}
