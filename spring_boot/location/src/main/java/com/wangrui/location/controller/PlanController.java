package com.wangrui.location.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wangrui.location.entity.Classroom;
import com.wangrui.location.entity.Day;
import com.wangrui.location.entity.MyClass;
import com.wangrui.location.entity.Plan;
import com.wangrui.location.entity.Subject;
import com.wangrui.location.entity.Times;
import com.wangrui.location.service.ClassService;
import com.wangrui.location.service.ClassroomService;
import com.wangrui.location.service.DayService;
import com.wangrui.location.service.PlanService;
import com.wangrui.location.service.SubjectService;
import com.wangrui.location.service.TimesService;

@RestController
@RequestMapping("/plan")
public class PlanController {

	@Autowired
	private ClassService classService;
	
	@Autowired
	private SubjectService subjectService;
	
	@Autowired
	private ClassroomService classroomService;
	
	@Autowired
	private DayService dayService;
	
	@Autowired
	private TimesService timesService;
	
	@Autowired
	private PlanService planService;
	
	@RequestMapping("/init")
	public Map init(){
		Map m = new HashMap();
		
	    List<MyClass> classes = this.classService.list(1, 100);	
	    List<Subject> subjects = this.subjectService.listAll();
	    List<Classroom> classrooms = this.classroomService.list();
	    List<Day> days = this.dayService.list();
	    List<Times> times = this.timesService.list();
	    m.put("classes", classes);
	    m.put("subjects", subjects);
	    m.put("classrooms", classrooms);
	    m.put("days", days);
	    m.put("times", times);

	    return m;
	}
	
	@RequestMapping("/add")
	public String add(Plan p) {
		int count = this.planService.add(p);
		String result = "faild";
		if(count==1) {
			result = "ok";
		}
		return result;
	}
	
	
}
