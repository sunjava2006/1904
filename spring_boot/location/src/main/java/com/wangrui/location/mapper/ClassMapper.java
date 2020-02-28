package com.wangrui.location.mapper;

import java.util.List;

import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import org.apache.ibatis.cache.decorators.FifoCache;
import org.apache.ibatis.mapping.FetchType;


import com.wangrui.location.entity.MyClass;

@Mapper()
@CacheNamespace(eviction = FifoCache.class,readWrite = true,size = 50)
public interface ClassMapper {

	/**
	 * 按班级表的主键ID,查询班级，并关联学生信息。
	 * @param ID
	 * @return
	 */
	@Select("select * from classes where id=#{ID}")
	@Results(id = "MyClassMapper",
	         value = {
	        		 @Result(column = "id", property = "ID" , id = true),
	        		 @Result(column = "class_name", property = "className"),
	        		 @Result(column = "id", property = "students",
	        		 many = @Many(fetchType = FetchType.EAGER,
	        		              select = "com.wangrui.location.mapper.StudentMapper.findByClassID") )
	         })
	@Options(useCache = true)
	public MyClass findByID(Integer ID) ;
	
	
	/**
	 * 按班级名查询班级，并关联学生信息
	 * @param className
	 * @return
	 */
	@Select("select * from classes where class_name=#{className}")
	@ResultMap("MyClassMapper")
	public MyClass findByName(String className);
	
	@Delete("delete from classes where class_name=#{className}")
	public int deleteByName(String className);
	
	@Insert("insert into classes(id, class_name) values (seq_classes.nextval, #{className})")
	public int add(MyClass c);
	
	@Select("select * from(" + 
			"select a.*, rownum ro from(" + 
			"select * from classes order by id desc)a where rownum<=#{end}) where ro>#{start}")
	@Results(value = {
		   		 @Result(column = "id", property = "ID" , id = true),
		   		 @Result(column = "class_name", property = "className")
		    })
	public List<MyClass> list(int start, int end);
	
	@Select("select count(*) from classes")
	public int count();
}
