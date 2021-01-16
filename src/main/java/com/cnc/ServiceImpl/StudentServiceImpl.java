package com.cnc.ServiceImpl;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cnc.Model.StudentModel;
import com.cnc.Repository.StudentRepository;
import com.cnc.Repository.StudentRepositoryCustom;
import com.cnc.Service.StudentService;
@Service
//@Validated
public class StudentServiceImpl implements StudentService{

	@Autowired

	private StudentRepository studentrepository;
	
	@Autowired
	private StudentRepositoryCustom stucustomrepo;
	
	
	
	public List<StudentModel> findAllStudents() {
		
		
		List<StudentModel> allstudents = studentrepository.findAll();
	
		return allstudents;
		
		
	}
	

	public String SaveStudent(StudentModel studentData) {
		
	
		
		studentrepository.save(studentData);
	
		return "Data Saved";
	}
	

	public String updateStudent(StudentModel newStudentData) {
		
		
			studentrepository.save(newStudentData);
			String msg= "Data Updated";
		
		return msg;
		
	}
	
	
	public Optional<StudentModel> findStudentByUid(Integer student_autoid) {
		// TODO Auto-generated method stub
		if(student_autoid!=0) {
		return studentrepository.findById(student_autoid);
		}
		else 
			return null;
		}

	
	public StudentModel findStudentByMobile1(String number) {
		if(number!=null) {
			return stucustomrepo.findStudentByMobile1OrMobile2(number,number);
			}
			else 
		return null;
		
	}


	public List<StudentModel> findAllByFirstnameOrLastname(String firstname,String lastname) {
		
		if(firstname!=null && lastname!=null) {
			return stucustomrepo.findAllByFirstnameOrLastname(firstname,lastname);
			}
			else 
		return null;
	}


	@Override
	public StudentModel getStudentByIndexno(String index_no) {
		if(index_no!=null) {
			return stucustomrepo.findByIndex(index_no);
			}
			else 
		return null;
	}


	@Override
	public List<StudentModel> findByGrade(String student_grade) {
		if(student_grade!=null) {
			return stucustomrepo.findByGrade(student_grade);
			}
			else 
		return null;
	}


	@Override
	public long countStudent() {
		
	         return studentrepository.count();
	}


	//@SuppressWarnings("unchecked")
	@SuppressWarnings("unchecked")
	@Override
	public List<StudentModel> findAllByFirstnameAndLastname(String firstname, String lastname) {
		if(firstname!=null && lastname!=null) {
			return  stucustomrepo.findAllByFirstnameAndLastname(firstname,lastname);
			}
			else 
		return null;
	}


	@Override
	public String deleteStudent(int student_autoid) {
		
		if(student_autoid!=0) {
			studentrepository.deleteById(student_autoid);
			
			return  ("Student Removed");
			}
		else
			return ("Error");
	}


	@Override
	public List<StudentModel> findNotPaidStudentByClass(String month, Integer class_id) {
		return stucustomrepo.findAllNotPaidByClass(month,class_id);
	}


	@Override
	public List<StudentModel> findNotPaidStudentByGrade(String month, Integer grade) {
		return stucustomrepo.findAllNotPaidByGrade(month,grade);
	}


	@Override
	public List<StudentModel> findNotPaidStudentByGradeAndClass(String month, Integer class_id, Integer grade) {
		return stucustomrepo.findAllNotPaidByGradeAndClass(month,class_id,grade);
	}










	
}
