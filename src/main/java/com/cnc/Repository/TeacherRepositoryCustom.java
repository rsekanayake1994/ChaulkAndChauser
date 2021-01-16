package com.cnc.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cnc.Model.TeacherModel;

public interface TeacherRepositoryCustom extends JpaRepository<TeacherModel,Integer>{


}
