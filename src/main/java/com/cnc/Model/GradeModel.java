package com.cnc.Model;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
@Entity
@Table(name="grades")
public class GradeModel extends AuditModel {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="grade_id")
	private int grade_id;
	
	@ManyToMany( mappedBy="grades")
	@JsonBackReference(value="teachers-grades")
	private Set<TeacherModel> teachers=new HashSet<>();
	
	
	@Column(name="grade")
	private int grade;

	public int getGrade_id() {
		return grade_id;
	}

	public void setGrade_id(int grade_id) {
		this.grade_id = grade_id;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public Set<TeacherModel> getTeachers() {
		return teachers;
	}

	public void setTeachers(Set<TeacherModel> teachers) {
		this.teachers = teachers;
	}



	

	
	
	
	
	
}
