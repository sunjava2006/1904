package com.wangrui.location.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wangrui.location.entity.Student;
import com.wangrui.location.mapper.StudentMapper;

@Service
public class StudentService {

	
	@Autowired
	StudentMapper studentMapper;
	
	public Student login(String studentID, String passwd) {
		return this.studentMapper.selectByIdAndPasswd(studentID, passwd);
	}
}
