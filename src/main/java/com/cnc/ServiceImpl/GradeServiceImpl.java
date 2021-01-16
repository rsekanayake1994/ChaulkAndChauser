package com.cnc.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cnc.Model.GradeModel;
import com.cnc.Repository.GradeRepository;
import com.cnc.Service.GradeService;
@Service
public class GradeServiceImpl implements GradeService{

	@Autowired
	private GradeRepository graderepo;
	@Override
	public List<GradeModel> findAllGrades() {
		return graderepo.findAll();
	}

}
