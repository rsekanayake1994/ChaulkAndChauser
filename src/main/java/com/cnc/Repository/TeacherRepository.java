package com.cnc.Repository;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.QueryByExampleExecutor;

import com.cnc.Model.TeacherModel;



public interface TeacherRepository extends JpaRepository<TeacherModel,String>,QueryByExampleExecutor<TeacherModel>{

	TeacherModel findStudentByMobile(String number);

	
	@Query("select t from TeacherModel t  where t.firstname = ?1 OR t.lastname= ?2")
	List<TeacherModel> findByFirstnameOrLastname(String fname,String lname);
	
	@Query("select t from TeacherModel t  where t.subject like %?1%")
	List<TeacherModel>  findBySubject(String subject);

	
	  //@Query("select t from teacher t where t.first_name OR t.last_name ")
	//List<TeacherModel> findByFirstNameOrLastName();
	
	@Query("SELECT  t from TeacherModel t  where t.firstname LIKE ?1 AND t.lastname like ?2")
	List<TeacherModel> findAllByFirstnameAndLastname(String fname, String lname);

	@Query("SELECT  t from TeacherModel t  where t.teacher_auto_id = ?1")
	Optional<TeacherModel> findById(Integer id);
	
	
}
