package com.cnc.ServiceImpl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cnc.Model.ClassesModel;

import com.cnc.Repository.ClassesRepository;
import com.cnc.Service.ClassesService;



@Service
public class ClassesServiceImpl implements ClassesService {
	@Autowired

	private ClassesRepository classrepository;

	@Override
	public List<ClassesModel> findAllClasses() {
		List<ClassesModel> allclasses= classrepository.findAll();
		
		return allclasses;
	}

	@Override
	public String SaveClass(ClassesModel classData) {
		classrepository.save(classData);
		
		return "Class Data Saved";
	}
}
