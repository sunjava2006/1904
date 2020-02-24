package com.wangrui.location.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;

import com.wangrui.location.entity.Plan;

@Mapper
public interface PlanMapper {

	
	@Insert("insert into plans(id, classroom_id, class_id, subject_id, times_id, day_id)"
			+ "values(seq_plans.nextval, #{classroom.ID}, #{myclass.ID},#{subject.ID}, #{times.ID}, #{day.ID})")
	public int add(Plan p);
	
	
	@Select("select * from plans where class_id=(select id  from classes where class_name=#{className})" + 
			"order by DAY_ID, times_id")
	@Results(id="PlanMapper",value = {@Result(column = "id", property = "ID", id=true),
			                          @Result(column = "classroom_id", property = "classroom",
			                                  one = @One(fetchType = FetchType.EAGER,
			                                             select = "com.wangrui.location.mapper.ClassroomMapper.findByID")),
			                          @Result(column = "class_id", property = "myclass",
			                                  one = @One(fetchType = FetchType.EAGER,
			                                             select = "com.wangrui.location.mapper.ClassMapper.findByID")),
			                          @Result(column = "subject_id", property = "subject",
			                                  one = @One(fetchType = FetchType.EAGER,
			                                             select = "com.wangrui.location.mapper.SubjectMapper.findByID")),
			                          @Result(column = "times_id", property = "times",
			                                  one = @One(fetchType = FetchType.EAGER,
			                                             select = "com.wangrui.location.mapper.TimesMapper.findByID")),
			                          @Result(column = "day_id", property = "day", 
			                                  one = @One(fetchType = FetchType.EAGER,
			                                             select = "com.wangrui.location.mapper.DayMapper.findByID"))})
	public List<Plan> findByClass(String className);
	
	
	@Select("select * from plans where class_id=#{classID} order by day_id, times_id")
	@ResultMap("PlanMapper")
	public List<Plan> findByClassID(int classID);
}
