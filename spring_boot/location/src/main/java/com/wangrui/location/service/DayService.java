package com.wangrui.location.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wangrui.location.entity.Day;
import com.wangrui.location.mapper.DayMapper;

@Service
public class DayService {

	@Autowired
	private DayMapper dayMapper;
	
	public List<Day> list(){
		return this.dayMapper.list();
	}
	
}
