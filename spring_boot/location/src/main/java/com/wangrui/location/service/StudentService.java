package com.wangrui.location.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wangrui.location.entity.Student;
import com.wangrui.location.mapper.StudentMapper;

@Service
public class StudentService {

	
	@Autowired
	StudentMapper studentMapper;
	
	/**
	 * 登录方法
	 * @param studentID 学号
	 * @param passwd 密码
	 * @return Student对象，失败返回null。
	 */
	public Student login(String studentID, String passwd) {
		return this.studentMapper.selectByIdAndPasswd(studentID, passwd);
	}
	
	/**
	 * @param stu
	 * @return
	 */
	public int add(Student stu) {
		return this.studentMapper.insert(stu);
	}
	
	/**
	 * 以对象中所在字段为依据更新到数据库， 对象属性为null更新后，记录中对应字段也为null.
	 * @param stu
	 * @return
	 */
	public int updateAllProperties(Student stu) {
		return this.studentMapper.updateAllProperties(stu);
	}
	
	/**
	 * 
	 * @param studentID
	 * @return
	 */
	public int delete(String studentID) {
		return this.studentMapper.delete(studentID);
	}
	
	/**
	 * 更新对象中不为null的字段。以学生学号为条件。
	 * @param stu
	 * @return
	 */
	public int updateByExample(Student stu) {
		return this.studentMapper.update(stu);
	}
	
}
