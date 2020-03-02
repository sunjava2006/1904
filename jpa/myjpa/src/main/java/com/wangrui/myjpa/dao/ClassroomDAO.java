package com.wangrui.myjpa.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.wangrui.myjpa.entity.Classroom;

@Repository
public interface ClassroomDAO extends JpaRepository<Classroom, Integer>{
	
	@Query(value = "from Classroom c where c.build.name=:buildName")
	public List<Classroom> findByBuildName(@Param("buildName") String buildName);
	
	@Query("from Classroom c where c.classroomName=:name")
	public Classroom findByClassName(String name);

}
