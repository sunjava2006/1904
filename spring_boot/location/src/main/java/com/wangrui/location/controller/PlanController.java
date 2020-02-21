package com.wangrui.location.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wangrui.location.entity.MyClass;
import com.wangrui.location.entity.Subject;
import com.wangrui.location.service.ClassService;
import com.wangrui.location.service.SubjectService;

@RestController
@RequestMapping("/plan")
public class PlanController {

	@Autowired
	private ClassService classService;
	
	@Autowired
	private SubjectService subjectService;
	
	@RequestMapping("/init")
	public Map init(){
		Map m = new HashMap();
		
	    List<MyClass> classes = this.classService.list(1, 100);	
	    List<Subject> subjects = this.subjectService.listAll();
	    m.put("classes", classes);
	    m.put("subjects", subjects);

	    return m;
	}
	
	
}
