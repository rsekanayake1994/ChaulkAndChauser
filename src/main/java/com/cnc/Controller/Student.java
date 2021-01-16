package com.cnc.Controller;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.cnc.Model.StudentModel;
import com.cnc.Service.StudentService;



@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/students")
public class Student {

	@Autowired
	private StudentService studentservices;
	
	
	@GetMapping("/showstudents")
	public List<StudentModel> allstudents() {
		 return studentservices.findAllStudents();
		
	}
	
	@PostMapping("/addstudent")
	public String addStudent(@RequestBody StudentModel studentData) {
		return studentservices.SaveStudent(studentData);
		
	}
	
	@PutMapping("/updatestudent/{id}")
	public String updateStudent(@RequestBody StudentModel newStudentData,@PathVariable Integer id) {
		Optional<StudentModel> studentOptional = studentservices.findStudentByUid(id);
		if (!studentOptional.isPresent())
			return ("Student id not Valid");
		newStudentData. setStudent_id(id);
		
		return studentservices.updateStudent(newStudentData);

		
}
	
@GetMapping("/findustudent/{student_autoid}")
	
	public Optional<StudentModel> findStudentByUid(@PathVariable Integer student_autoid) {
		
		return studentservices.findStudentByUid(student_autoid);
		
	}
@GetMapping("/findstudentbytp/{number}")

public StudentModel findStudentByNumber(@PathVariable String number) {
	return studentservices.findStudentByMobile1(number);
}

@GetMapping("/findstudentbyname/{firstname}/{lastname}")

public List <StudentModel> findByFirstnameOrLastname(@PathVariable String firstname,@PathVariable String lastname) {
	return (List <StudentModel>) studentservices.findAllByFirstnameOrLastname(firstname,lastname);
}

@GetMapping("/findustudentbyindex/{index_no}")

public StudentModel getStudentByIndexno(@PathVariable String index_no) {
	
	return studentservices.getStudentByIndexno(index_no);
	
}
@GetMapping("/findstudentsbygrade/{student_grade}")

public  List <StudentModel> findByGrade(@PathVariable String student_grade) {
	return (List<StudentModel>) studentservices.findByGrade(student_grade);
}

@GetMapping("/getstudentcount")
public  long list() {
	return studentservices.countStudent();
}

/*@GetMapping("/getlastindex")

public  Optional<StudentModel> findStudentById() {
	return  studentservices.findStudentById();
}*/
	
@GetMapping("/findbyname/{firstname}/{lastname}")
public List<StudentModel> findByFullName(@PathVariable String firstname,@PathVariable  String lastname ){
return (List<StudentModel>) studentservices.findAllByFirstnameAndLastname(firstname,lastname);
}

@DeleteMapping("/removestudent/{student_id}")
private String deleteStudent(@PathVariable int student_id) {
	return studentservices.deleteStudent(student_id);
	
}

@GetMapping("/notpaidbyclass/{month}/{class_id}")
private List<StudentModel> findNotPaidStudentByClass(@PathVariable String month,@PathVariable  Integer class_id) {
	return studentservices.findNotPaidStudentByClass(month,class_id);
	
}
@GetMapping("/notpaidbygrade/{month}/{grade}")
private List<StudentModel> findNotPaidStudentByGrade(@PathVariable String month,@PathVariable  Integer grade) {
	return studentservices.findNotPaidStudentByGrade(month,grade);
	
}

@GetMapping("/notpaidbygradeandclass/{month}/{class_id}/{grade}")
private List<StudentModel> findNotPaidStudentByGradeAndClass(@PathVariable String month,@PathVariable  Integer class_id,@PathVariable  Integer grade) {
	return studentservices.findNotPaidStudentByGradeAndClass(month,class_id,grade);
	
}


}
