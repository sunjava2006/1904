package com.wangrui.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class MatchDemo {

	public static void main(String[] args) {
		List<People> list =Arrays.asList(new People("Jack", "Male", 20),
										new People("Jack", "Male", 20),
						                new People("Peger", "Male", 22),
						                new People("Jhon", "Male", 25),
						                new People("Marry", "Female", 19),
						                new People("Rose", "Female", 20),
						                new People("Hellon", "Female", 20));
		
		
		// AllMatch,ɸѡ���������20��Ԫ�ء��ж��Ƿ񶼴���20��
		boolean gt20 = list.stream().filter(i->i.getAge()>20).allMatch((t)-> t.getAge()>20);
		System.out.println(gt20);
		
		// anyMatch,�ж����д���19��ģ��Ƿ���Ů����
		boolean femaleHave = list.stream().filter(i->i.getAge()>19)
				.anyMatch(i->"Female".equals(i.getGender()));
		System.out.println(femaleHave);
		
		// û��һ��������30�ġ�
		boolean age30 = list.stream().noneMatch(i->i.getAge()==30);
		System.out.println(age30);
		
		// ��ȡ��һ��������20��Ԫ��
		Optional<People> op = list.stream().filter(i->i.getAge()==20).findFirst();
		System.out.println(op.isPresent() ? op.get() : "û�ҵ�");
		
		
		// ��ȡ��һ��������20��Ԫ��
		Optional<People> opt = list.stream().filter(i->i.getAge()==20).findFirst();
		System.out.println(opt.isPresent() ? op.get() : "û�ҵ�");
		
		// ��ȡ������20���˵�����
		long count = list.stream().filter(i->i.getAge()==20).count();
		System.out.println(count);
		
		// �ҳ�����������
		Optional<People> maxAgePeople = list.stream().max((a,b)->a.getAge()-b.getAge());
		System.out.println(maxAgePeople);
		
		// �ҳ�������С����
		Optional<People> minAgePeople = list.stream().min((a,b)->a.getAge()-b.getAge());
		System.out.println(minAgePeople);
		
	}
}
