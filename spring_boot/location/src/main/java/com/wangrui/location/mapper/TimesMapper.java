package com.wangrui.location.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.wangrui.location.entity.Times;

@Mapper
public interface TimesMapper {

	@Select("select * from times")
	@Results(id="TimesMapper", 
	         value = {@Result(column = "id", property = "ID", id=true),
	        		  @Result(column = "time_name", property = "timeName"),
	        		  @Result(column = "start_time", property = "startTime"),
	        		  @Result(column = "endTime", property = "endTime")})
	public List<Times> list();
	
	@Select("select * from times where id= #{id}")
	@ResultMap("TimesMapper")
	public Times findByID(int id);
}
