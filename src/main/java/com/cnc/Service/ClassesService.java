package com.cnc.Service;

import java.util.List;

import com.cnc.Model.ClassesModel;

public interface ClassesService {
	List<ClassesModel> findAllClasses();

	String SaveClass(ClassesModel classData);
}
