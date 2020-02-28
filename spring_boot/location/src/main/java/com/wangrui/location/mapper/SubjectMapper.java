package com.wangrui.location.mapper;

import java.util.List;

import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Options.FlushCachePolicy;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.cache.decorators.LruCache;

import com.wangrui.location.entity.Subject;

@Mapper
@CacheNamespace(eviction = LruCache.class, readWrite = true, flushInterval = 18000, size = 100)// 缓存策略
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
	@Options(useCache = true)// 不使用缓存
	public Subject findByID(int id);
	
	
	@Update("update subjects set subject_name=#{subjectName} where id=#{ID}")
	@Options(flushCache = FlushCachePolicy.TRUE)// 让缓存失效
	public int update(Subject subject);
	
	@Delete("delete from subjects where id=#{id}")
	@Options(flushCache = FlushCachePolicy.FALSE)// 数据库实际已经删除数据 ，但是缓存中还有。
	public int delete(int id);
	

}
