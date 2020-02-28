package com.wangrui.location.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

import com.wangrui.location.entity.News;

@Mapper
//@CacheConfig(cacheNames = "c1")
public interface NewsMapper {

	
	@SelectKey(before = true, keyProperty = "ID", resultType = Integer.class, statement = { "select seq_news.nextval from dual" }, keyColumn = "id")
//	@Cacheable(key = "#news.name")
	@Insert("insert into news (id, name) values (#{ID}, #{name})")
	public int insert(News news);

	@Select("select * from news where id=#{id}")
	@Results(id = "NewsMapper",
	         value = {@Result(column = "id", property = "ID", id = true),
	        		  @Result(column = "name", property = "name")})
	public News findByID(int id);
	
	@Select("select * from news where name=#{name}")
	@ResultMap("NewsMapper")
	public List<News> findByName(String name);
	
	@Update("update news set name=#{name} where id=#{ID}")
	public int update(News news);
	
	@Delete("delete from news where id=#{id}")
	public int delete(int id);
	
	
}
