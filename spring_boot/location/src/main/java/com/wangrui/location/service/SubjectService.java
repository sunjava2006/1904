package com.wangrui.location.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wangrui.location.entity.Subject;
import com.wangrui.location.mapper.SubjectMapper;

@Service
public class SubjectService {
	
	@Autowired
	private SubjectMapper subjectMapper;
	
	public List<Subject> listAll(){
		return this.subjectMapper.list();
	}
}
