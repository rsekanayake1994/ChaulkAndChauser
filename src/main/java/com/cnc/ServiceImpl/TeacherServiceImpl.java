package com.cnc.ServiceImpl;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.cnc.Model.TeacherModel;

import com.cnc.Repository.TeacherRepository;
import com.cnc.Repository.TeacherRepositoryCustom;
import com.cnc.Service.TeacherService;

@Service
public class TeacherServiceImpl implements TeacherService{
	@Autowired

	private TeacherRepository teacher_repository;
	@Autowired

	private TeacherRepositoryCustom teacher_repo;
	@Override
	public List<TeacherModel> findAllTeachers() {
		List<TeacherModel> allteachers = teacher_repository.findAll();
		
		return allteachers;
	}
	@Override
	public String SaveTeacher(TeacherModel teacherData) {
		teacher_repository.save(teacherData);
		
		return "Teacher Data Saved Succesfully";
	}
	@Override
	public TeacherModel findTeacherByMobile(String number) {
		if(number!=null) {
			return teacher_repository.findStudentByMobile(number);
			}
			else 
		return null;
	}
	@Override
	public List<TeacherModel> findByFirstnameOrLastname(String fname,String lname) {
		if(fname!=null && lname!=null) {
			return teacher_repository.findByFirstnameOrLastname(fname,lname);
			}
			else 
		return null;
	}

	
	@Override
	public long countTeacher() {
		// TODO Auto-generated method stub
		return teacher_repository.count();
	}
	@Override
	public List<TeacherModel> findBySubject(String subject) {
		if(subject!=null) {
			return teacher_repository.findBySubject(subject);
			}
			else 
		return null;
	}
	@Override
	public List<TeacherModel> findAllByFirstnameAndLastname(String fname,String lname) {
		if(fname!=null && lname!=null) {
			return teacher_repository.findAllByFirstnameAndLastname(fname,lname);
			}
			else 
		return null;
	}
	/*@Override
	public String deleteById(int teacher_auto_id) {
		if(teacher_auto_id!=0) {
			teacher_repo.deleteById(teacher_auto_id);
			return ("Teacher Removed");
		}
		else
			return ("Error");
	}*/
	@Override
	public String deleteById(int teacher_auto_id) {
		if(teacher_auto_id!=0) {
			teacher_repo.deleteById(teacher_auto_id);
			return ("Teacher Removed");
		}
		else
			return ("Error");
	}
	@Override
	public Optional<TeacherModel> findById(Integer id) {
		 return teacher_repository.findById(id);
		 
	}
	
			
	
	

	
}
