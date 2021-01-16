package com.cnc.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cnc.Model.StudentModel;

public interface StudentRepository extends JpaRepository<StudentModel,Integer>{

	

}
