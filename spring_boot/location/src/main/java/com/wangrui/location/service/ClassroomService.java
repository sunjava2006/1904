package com.wangrui.location.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wangrui.location.entity.Classroom;
import com.wangrui.location.mapper.ClassroomMapper;

@Service
public class ClassroomService {

	@Autowired
	private ClassroomMapper classroomMapper;
	
	public List<Classroom> list(){
		return this.classroomMapper.list();
	}
	
}
