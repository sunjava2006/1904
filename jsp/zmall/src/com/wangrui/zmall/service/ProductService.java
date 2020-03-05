package com.wangrui.zmall.service;

import java.util.List;

import com.wangrui.zmall.dao.ProductDao;
import com.wangrui.zmall.entity.Product;

/**
 * ��Ʒ�����࣬�ṩ����ҵ����ӡ���ѯ���޸ġ�ɾ���Ĺ��ܡ�
 * @author wangrui
 * @since 2020-3-5
 * @version 1.0
 * @see ProductDAO ������ʹ������Ӧ��DAO�ࡣ
 */
public class ProductService {

	private ProductDao pdao = new ProductDao();
	
	/**
	 * ���һ����Ʒ
	 * @param p Product����
	 * @return ��ӳɹ�����true�����򷵻�false��
	 */
	public boolean add(Product p) {
		return this.pdao.add(p)==1 ? true : false;
	}
	
	/**
	 * �ֲ���ѯ��������Ʒ�б�
	 * @param page �ڼ�ҳ
	 * @param size ÿҳ����¼��
	 * @return List<Product>
	 */
	public List<Product> listByPage(int page, int size){
		return this.pdao.findByPage(page, size);
	}
	
	
}
