package com.wangrui.myjpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wangrui.myjpa.dao.ClassroomDAO;
import com.wangrui.myjpa.entity.Classroom;

@Service
public class ClassroomService {

	@Autowired
	private ClassroomDAO cd;
	
	/**
	 * 根据教学楼的名字，查询这个楼的所有教室
	 * @param buildName
	 * @return 教室List
	 */
	public List<Classroom> findByBuildName(String buildName) {
		return this.cd.findByBuildName(buildName);
	}
	
	
	/**
	 * 根据教室名，查询这个教室的信息
	 * @param name
	 * @return 教室信息，关联教学楼的信息。
	 */
	public Classroom findByClassroomName(String name) {
		return this.cd.findByClassName(name);
	}
}
