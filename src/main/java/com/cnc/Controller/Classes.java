package com.cnc.Controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.cnc.Model.ClassesModel;
import com.cnc.Service.ClassesService;








@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/classes")

public class Classes {

	@Autowired
	private ClassesService classes_services;
	
	
	@GetMapping("/showclasses")
	public List<ClassesModel> allClasses() {
		 return classes_services.findAllClasses();
		
	}
	
	@PostMapping("/addclass")
	public String addClass(@RequestBody ClassesModel classData) {
		return classes_services.SaveClass(classData);
		
	}
}
