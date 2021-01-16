package com.cnc.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cnc.Model.TeacherModel;
import com.cnc.Service.TeacherService;




@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/teachers")
public class Teacher {
@Autowired
private TeacherService teacherservices;
	@GetMapping("/showteachers")
	public List<TeacherModel> allteachers() {
		 return teacherservices.findAllTeachers();
		
	}
	
	@PostMapping("/addteacher")
	public String addTeacher(@RequestBody TeacherModel teacherData) {
		return teacherservices.SaveTeacher(teacherData);
		
	}
	@GetMapping("/findteacherbytp/{number}")

	public TeacherModel findTeacherByNumber(@PathVariable String number) {
		return teacherservices.findTeacherByMobile(number);
	}

	@GetMapping("/findteacherbyname/{fname}/{lname}")

	public List<TeacherModel> findByFirstnameOrLastname(@PathVariable String fname,@PathVariable String lname) {
		return teacherservices.findByFirstnameOrLastname(fname,lname);
	}
	@GetMapping("/findteachersbysubject/{subject}")

	public List<TeacherModel> findBySubject(@PathVariable String subject) {
		return  teacherservices.findBySubject(subject);
	}
	
	
	@GetMapping("/getteachercount")
	public  long list() {
		return teacherservices.countTeacher();
	}
	@GetMapping("/findteacherbyfullname/{fname}/{lname}")

	public List<TeacherModel> findByName(@PathVariable String fname,@PathVariable String lname) {
		return  teacherservices.findAllByFirstnameAndLastname(fname,lname);
	}
	
	
	
	@DeleteMapping("/removeteacher/{teacher_auto_id}")
	private String removeTeacher(@PathVariable int teacher_auto_id ) {
		return teacherservices.deleteById(teacher_auto_id);
	}
	
	@PutMapping("/updateteacher/{id}")
	private  String updateTeacher(@RequestBody TeacherModel  teacherData,@PathVariable Integer id) {
		
		Optional<TeacherModel> teacherOptional=teacherservices.findById(id);
		if (!teacherOptional.isPresent())
			return  ("Teacher id not Valid");
		teacherData.setTeacher_auto_id(id);
		return teacherservices.SaveTeacher(teacherData);
				
	}
}