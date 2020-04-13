package com.wangrui.stream;

import java.util.Arrays;
import java.util.List;

public class FlatMapOp {

	public static void main(String[] args) {
		List<Integer> lista = Arrays.asList(10,20,30);
		List<Integer> listb = Arrays.asList(40,50,60);
		List<Integer> listc = Arrays.asList(70,80,90);
		
		List<List<Integer>> list = Arrays.asList(lista, listb, listc);
		
		// ��ʹ��flatMap�����ǿ���������Stream�а���3��List��
		list.stream().forEach(System.out::println);
		
		// ʹ��map,��ÿһ��List��Ԫ�طŵ�һ��Stream��.
		list.stream().map((a)->a.stream()).forEach(System.out::println);
		
		// ʹ��flatMap,��ÿһ��List��Ԫ�طŵ�һ��Stream�У����ϲ���һ�����Stream�С�
		list.stream().flatMap((a)->a.stream()).forEach(System.out::println);
		
		
	}
}
