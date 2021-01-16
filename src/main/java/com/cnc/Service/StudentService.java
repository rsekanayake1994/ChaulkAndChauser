package com.cnc.Service;

import java.util.List;
import java.util.Optional;

import com.cnc.Model.StudentModel;

public interface StudentService {
	List<StudentModel> findAllStudents();

	String SaveStudent(StudentModel studentData);
	String updateStudent(StudentModel newStudentData);

	Optional<StudentModel> findStudentByUid(Integer student_autoid);

	
	StudentModel findStudentByMobile1(String telephone);

	List<StudentModel> findAllByFirstnameOrLastname(String name, String lastname);
	

	StudentModel getStudentByIndexno(String index_no);

	List<StudentModel> findByGrade(String student_grade);

	long countStudent();

	List<StudentModel> findAllByFirstnameAndLastname(String firstname, String lastname);

	String deleteStudent(int student_id);

	List<StudentModel> findNotPaidStudentByClass(String month, Integer class_id);

	List<StudentModel> findNotPaidStudentByGrade(String month, Integer grade);

	List<StudentModel> findNotPaidStudentByGradeAndClass(String month, Integer class_id, Integer grade);

	
}
