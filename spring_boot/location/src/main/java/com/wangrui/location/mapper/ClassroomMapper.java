package com.wangrui.location.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;

import com.wangrui.location.entity.Classroom;

@Mapper
public interface ClassroomMapper {

	@Select("select * from classrooms")
	@Results(id="ClassroomMapper",
	         value = {@Result(column = "id", property = "ID", id = true),
	        		  @Result(column = "classroom_name", property = "classroomName"),
	        		  @Result(column = "build_id", property = "build",
	        		          one = @One(fetchType = FetchType.EAGER,
	        		                     select = "com.wangrui.location.mapper.BuildMapper.findByID"))
	         })
	public List<Classroom> list();
	
	@Select("select * from classrooms where id=#{id}")
	@ResultMap(value = "ClassroomMapper")
	public Classroom findByID(int id);
}
