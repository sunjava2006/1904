package com.thzhima.advance.lambda;

import com.thzhima.advance.bean.Student;

public interface StudentCreator {

	Student createStudent(int id, String name, String loginName, String passwd);
}
