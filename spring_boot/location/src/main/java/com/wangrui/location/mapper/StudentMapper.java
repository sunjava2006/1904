package com.wangrui.location.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

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
	
	@Insert("insert into students(id,name,passwd,gender,class_id,student_id) "
			+ "values (seq_students.nextval,#{name},#{password},#{gender},#{classID},#{studentID})")
	public int insert(Student student);
	
	/**
	 * 完全以参数为准，更新数据库对象。如果参数中某个字段值为null，这个值也将会被更新到数据库对应的记录中。
	 * @param student
	 * @return
	 */
	@Update("update students set name=#{name},passwd=#{password},gender=#{gender},class_id=#{classID}"
			+ " where student_id=#{studentID}")
	public int update(Student student);
	
	@Delete("delete from students where student_id=#{studentID}")
	public int delete(String studentID);
}
