package com.wangrui.myjpa.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.wangrui.myjpa.dao.BuildDAO;
import com.wangrui.myjpa.entity.Build;

/**
 * @author wangrui
 *
 */
@Service
public class BuildService {

	@Autowired
	private BuildDAO buildDao;
	
	
	/**
	 * 添加一个Build到数据库中
	 * @param build
	 * @return
	 */
	public Build save(Build build) {
		return this.buildDao.save(build);
	}
	
	/**
	 * 添加多个Build到数据库中
	 * @param builds
	 * @return
	 */
	public List<Build> saveAll(Iterable builds) {
		return this.buildDao.saveAll(builds);
	}
	
	
	/**
	 * 根据ID，查询Build
	 * @param id
	 * @return
	 */
	public Build findByID(Integer id) {
		Optional<Build> opt = this.buildDao.findById(id);
		if(opt.isPresent()) {
			return opt.get();
		}else {
			return null;
		}
	}
	
	/**
	 * 根据教学楼名字，查询教学楼信息。
	 * @param name
	 * @return
	 */
	public Build findByName(String name) {
		return this.buildDao.findByName(name);
	}
	
	/**
	 * 分页查询出Build
	 * @param page
	 * @param size
	 * @return Page对象。包含查询出的记录信息、总记录数、总分页数等。
	 */
	public Page<Build> listByPage(int page, int size){
		List<Build> list = null;
		Pageable pageable = PageRequest.of(page, size);
		Page<Build> pages = this.buildDao.findAll(pageable);
		list = pages.getContent(); // 分布查询的内容，及其它的分布所需要的数据。
		System.out.println(list);
		System.out.println("total Elements : "+ pages.getTotalElements()); // page对象中包含总记录数
		System.out.println("togal pages : "+pages.getTotalPages()); // page对象中包含总分页数
		return pages;
	}
	
	/**
	 * 分页查询Build
	 * @param page
	 * @param size
	 * @param asc ，顺序为true,倒序为false
	 * @param orders, 排序字段名（属性名）
	 * @return Page对象。包含查询出的记录信息、总记录数、总分页数等。
	 */
	public Page<Build> listByPage(int page, int size,  boolean asc, String...orders){
		Page<Build> pages = null;
		Pageable pageable = PageRequest.of(page, size, asc?Direction.ASC:Direction.DESC, orders);
		pages = this.buildDao.findAll(pageable);
		return pages;
	}
	
	
}
