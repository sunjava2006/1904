package com.wangrui.location.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wangrui.location.entity.MyClass;
import com.wangrui.location.mapper.ClassMapper;
import com.wangrui.location.mapper.StudentMapper;

@Service
public class ClassService {

	@Autowired
	private ClassMapper classMapper;
	
	@Autowired
	private StudentMapper studentMapper;
	
	
	/**
	 * 按班级ID查询
	 * @param id
	 * @return
	 */
	public MyClass findByID(int id) {
		return this.classMapper.findByID(id);
	}
	
	/**
	 * 按班级名查询
	 * @param name
	 * @return
	 */
	public MyClass findByName(String name) {
		return this.classMapper.findByName(name);
	}
	
	@Transactional
	public void deleteByName(String className) {
		// 先删除学生
		this.studentMapper.deleteByClassName(className);
		// 再删除班级
		this.classMapper.deleteByName(className);
	}
	
	public int add(MyClass c) {
		return this.classMapper.add(c);
	}
	
	
	public List<MyClass> list(int page, int size){
		return this.classMapper.list((page-1)*size, page*size);
	}
	
	public int totalPage(int size) {
		double s = size;
		return (int)Math.ceil(this.classMapper.count()/s);
	}
}
