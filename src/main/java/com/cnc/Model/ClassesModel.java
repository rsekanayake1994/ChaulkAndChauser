package com.cnc.Model;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;

@Entity
@Table(name="classes")

public class ClassesModel extends AuditModel {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="class_id")
	int class_id;
	
	@ManyToMany( mappedBy="classes")
	@JsonBackReference(value="student-classes")
		private Set<StudentModel> students=new HashSet<>();  

	
	
	@OneToMany(
           fetch = FetchType.LAZY,
           targetEntity = TeacherModel.class,cascade = CascadeType.ALL)
	@JoinColumn(name="teacher_auto_id",referencedColumnName="class_id")
	@JsonBackReference(value="teachers-classes")
    private List <TeacherModel> teachers;
	
	

	
	
	
	
	
	@Column(name="class_name")
	String class_name;
	
	public ClassesModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Column(name="fee")
	String fee;
	
	
	public int getClass_id() {
		return class_id;
	}

	public void setClass_id(int class_id) {
		this.class_id = class_id;
	}

	

	public String getClass_name() {
		return class_name;
	}

	public void setClass_name(String class_name) {
		this.class_name = class_name;
	}

	

	
	
	
	public String getFee() {
		return fee;
	}

	public void setFee(String fee) {
		this.fee = fee;
	}

	public Set<StudentModel> getStudents() {
		return students;
	}

	public void setStudents(Set<StudentModel> students) {
		this.students = students;
	}

	
	

	public List<TeacherModel> getTeachers() {
		return teachers;
	}

	public void setTeachers(List<TeacherModel> teachers) {
		this.teachers = teachers;
	}

	@Override
    public String toString() {
        return "classes{" +
                "id=" + class_id +
                ", class_name='" + class_name + '\'' +
                '}';
    }

}
