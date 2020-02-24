package com.wangrui.location.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wangrui.location.entity.Times;
import com.wangrui.location.mapper.TimesMapper;

@Service
public class TimesService {

	@Autowired
	private TimesMapper timesMapper;
	
	public List<Times> list(){
		return this.timesMapper.list();
	}
}
