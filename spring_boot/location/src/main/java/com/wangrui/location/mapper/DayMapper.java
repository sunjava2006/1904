package com.wangrui.location.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.wangrui.location.entity.Day;

@Mapper
public interface DayMapper {

	@Select("select * from day")
	@Results(id="DayMapper", 
	         value = {@Result(column = "id", property = "ID", id = true),
	        		  @Result(column = "day", property = "day")})
	public List<Day> list();
	
	@Select("select * from day where id = #{id}")
	@ResultMap("DayMapper")
	public Day findByID(int id);
}
