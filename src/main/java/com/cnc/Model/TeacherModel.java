package com.cnc.Model;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
@Entity
@Table(name="teacher")

public class TeacherModel extends AuditModel{
	private static final long serialVersionUID = 1L;
	
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY )
	@Column(name="teacher_auto_id")
	private int teacher_auto_id;
	
	@ManyToMany
	@JoinTable(
			name="teacher_grades",
			joinColumns=@JoinColumn(name="teacher_auto_id"),
			
	inverseJoinColumns=@JoinColumn(name="grade_id"))
	
	//@JsonManagedReference(value="teachers-grades")
	private Set<GradeModel> grades=new HashSet<>();
	
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "class_id",nullable=false)
	@JsonBackReference(value="teachers-classes")
	private ClassesModel classes;
	
	
	@NotNull
	@Column(name="first_name")
	private String firstname;
	
	@Column(name="last_name")
	private String lastname;
	
	@Column(name="mobile")
	private String mobile;
	
	@Column(name="subject")
	private String subject;

	public int getTeacher_auto_id() {
		return teacher_auto_id;
	}

	public void setTeacher_auto_id(int teacher_auto_id) {
		this.teacher_auto_id = teacher_auto_id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public Set<GradeModel> getGrades() {
		return grades;
	}

	public void setGrades(Set<GradeModel> grades) {
		this.grades = grades;
	}


	public ClassesModel getClasses() {
		return classes;
	}

	public void setClasses(ClassesModel classes) {
		this.classes = classes;
	}



	
	
}

