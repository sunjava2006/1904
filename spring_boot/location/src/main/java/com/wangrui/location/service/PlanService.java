package com.wangrui.location.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wangrui.location.entity.Plan;
import com.wangrui.location.mapper.PlanMapper;

@Service
public class PlanService {

	
	@Autowired
	private PlanMapper planMapper;
	
	public int add(Plan p) {
		return this.planMapper.add(p);
	}
	
	public List<Plan> findByName(String className){
		return this.planMapper.findByClass(className);
	}
}
