package com.cnc.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cnc.Model.GradeModel;

import com.cnc.Service.GradeService;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/grades")
public class Grade {

	@Autowired
	private GradeService gradeservices;
	
	@GetMapping("/showgrades")
	public List<GradeModel> allGrades() {
		 return gradeservices.findAllGrades();
		
	}
}
