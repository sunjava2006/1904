package com.wangrui.myjpa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.wangrui.myjpa.entity.Build;

@Repository
public interface BuildDAO extends JpaRepository<Build, Integer>{
	
	@Query(value = "from Build b where b.name=:name ")
	Build findByName(@Param("name") String name);

}
