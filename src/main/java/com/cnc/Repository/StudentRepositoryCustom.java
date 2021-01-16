package com.cnc.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import java.util.List;
//import org.springframework.data.jpa.repository.query.Query;
import org.springframework.data.jpa.repository.Query;
import com.cnc.Model.StudentModel;
 

public interface StudentRepositoryCustom extends JpaRepository<StudentModel,String> {
	@Query(nativeQuery=true,value="select * from student  where mobile1 = ?1 OR mobile2 = ?2")
	StudentModel findStudentByMobile1OrMobile2(String telephone1,String telephone2);
	
	@Query(nativeQuery=true,value="select * from student   where firstname = ?1 OR  lastname = ?2")
	List<StudentModel> findAllByFirstnameOrLastname(String firstname,String lastname);
	
	//@Query("select * from student where index_no = ?1")
	StudentModel findByIndex(String index_no);

	//@Query("select * from student student_grade LIKE ?1")
	List<StudentModel> findByGrade(String student_grade);
	
	//@Query("select * from student s ORDER BY s.student_auto_id DESC LIMIT 1")
	//Optional <StudentModel> findStudentById();
	
	@Query(nativeQuery=true,value="select * from student s where firstname = ?1 AND lastname = ?2 ")
	List<StudentModel> findAllByFirstnameAndLastname(String firstname,String lastname);
	
	@Query(nativeQuery=true,value="select * from student  WHERE student.student_auto_id NOT IN ( SELECT sf.student_auto_id FROM payment sf WHERE sf.payment_month =:month )AND student.student_auto_id IN (SELECT sc.student_auto_id FROM student_classes sc WHERE sc.class_id =:class_id )")
	List<StudentModel> findAllNotPaidByClass(@Param("month") String month, @Param("class_id")Integer class_id);

	@Query(nativeQuery=true,value="select * from student  WHERE student.student_auto_id NOT IN ( SELECT sf.student_auto_id FROM payment sf WHERE sf.payment_month =:month )AND student.student_grade=:grade")
	List<StudentModel> findAllNotPaidByGrade(@Param("month") String month,  @Param("grade")Integer grade);

	@Query(nativeQuery=true,value="select * from student  WHERE student.student_auto_id NOT IN ( SELECT sf.student_auto_id FROM payment sf WHERE sf.payment_month =:month )AND student.student_auto_id IN (SELECT sc.student_auto_id FROM student_classes sc WHERE sc.class_id =:class_id ) AND student.student_grade=:grade")
	List<StudentModel> findAllNotPaidByGradeAndClass(@Param("month") String month,@Param("class_id")Integer class_id,  @Param("grade")Integer grade);
	
	//@Query( value="select s.* from student s WHERE s.student_auto_id NOT IN ( SELECT sf.student_auto_id FROM payment sf WHERE sf.payment_month =:month )AND s.student_auto_id IN (SELECT sc.student_auto_id FROM student_classes sc WHERE sc.class_id =:class_id )")
	//List<StudentModel> findStudent(@Param("month") String month, @Param("class_id")Integer class_id);
	

	
}
