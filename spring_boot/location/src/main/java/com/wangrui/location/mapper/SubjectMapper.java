package com.wangrui.location.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.wangrui.location.entity.Subject;

@Mapper
public interface SubjectMapper {
	
	@Select("select * from subjects")
	@Results(id = "SubjectMapper",
			value = {@Result(column = "id", property = "ID", id = true),
			          @Result(column = "subject_id", property = "subjectID"),
			          @Result(column = "subject_name", property = "subjectName")
	})
	public List<Subject> list();
	
	@Select("select * from subjects where id = #{id}")
	@ResultMap("SubjectMapper")
	public Subject findByID(int id);

}
