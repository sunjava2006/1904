package com.wangrui.location.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.wangrui.location.entity.Build;

@Mapper
public interface BuildMapper {

	@Select("select * from builds where id=#{id}")
	@Results(id="BuildMapper",
	         value = {@Result(column = "id", property = "ID",  id = true ),
	        		  @Result(column = "name", property = "name"),
	        		  @Result(column = "latitude", property = "latitude"),
	        		  @Result(column = "longitude", property = "longitude")
	         })
	public Build findByID(int id);
}
