package com.cnc.Service;
import java.util.List;
import java.util.Optional;

import com.cnc.Model.TeacherModel;
public interface TeacherService {
	List<TeacherModel> findAllTeachers();

	String SaveTeacher(TeacherModel teacherData);

	TeacherModel findTeacherByMobile(String number);

	List<TeacherModel> findByFirstnameOrLastname(String fname,String lname);

	List<TeacherModel> findBySubject(String subject);

	long countTeacher();

	List<TeacherModel> findAllByFirstnameAndLastname(String fname, String lname);

	String deleteById(int teacher_auto_id);

	

	Optional<TeacherModel> findById(Integer id);

	//String deleteById(int teacher_auto_id);

	

	

	/*List<TeacherModel> findByFirstNameOrLastName(String fullname);*/

	
	
	
	

}
