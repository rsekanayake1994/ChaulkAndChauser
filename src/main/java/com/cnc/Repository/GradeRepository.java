package com.cnc.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.cnc.Model.GradeModel;

public interface GradeRepository extends JpaRepository<GradeModel,Integer>{
	List<GradeModel> findAll();
}
