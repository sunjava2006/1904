package com.wangrui.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SynchColl {

	public static void main(String[] args) {
		List<String> li = new ArrayList<>();
		
		li = Collections.synchronizedList(li);
	}
}
