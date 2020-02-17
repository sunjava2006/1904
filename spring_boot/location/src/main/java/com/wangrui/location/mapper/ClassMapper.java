package com.wangrui.location.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.wangrui.location.entity.MyClass;

@Mapper
public interface ClassMapper {

	@Select("select * from classes where id=#{ID}")
	@Results(id = "MyClassMapper",
	         value = {
	        		 @Result(column = "id", property = "ID" , id = true),
	        		 @Result(column = "class_name", property = "className")
	         })
	public MyClass findByID(Integer ID) ;
}
