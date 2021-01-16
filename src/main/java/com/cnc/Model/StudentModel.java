package com.cnc.Model;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.*;

@Entity(name="student")
@Table(name="student")

public class StudentModel extends AuditModel {

	
private static final long serialVersionUID = 1L;

	
	
	
	
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY )
	@Column(name="student_auto_id")
	private int student_auto_id;
	
	
	@ManyToMany
	@JoinTable(
			name="student_classes",
			joinColumns=@JoinColumn(name="student_auto_id"),
			
	inverseJoinColumns=@JoinColumn(name="class_id"))
	//@JsonManagedReference(value="student-classes")
	
	private Set<ClassesModel> classes=new HashSet<>();
	
	
	
	@OneToMany(mappedBy="student", cascade = CascadeType.ALL)
	//@JsonManagedReference
	
    private Set<PaymentModel> payments;

	
	//@NotBlank(message = "student name is mandatory")
	@NotNull
	@Column(name="first_name")
	private String firstname;
	
	
	
	
	
	
	@Column(name="last_name")
	private String lastname;
	
	//@NotBlank(message = "student address is mandatory")
	@Column(name="student_address")
	private String student_address;
	
	
	@Column(name="student_grade")
	private String grade;
	
	@Column(name="guardian_name")
	private String guardian_name;
	
	@Column(name="school_name")
	private String school_name;
	
	//@NotNull
	//@NotBlank(message = "student contact number is mandatory")
	@Column(name="mobile_1")
	private String mobile1;
	
	@Column(name="mobile_2")
	private String mobile2;
	
	@Column(name="index_no")
	private String index;
	
	@Column(name="joined_date")
	private String joined_date;
	
	@Column(name="monthly_fee")
	private String monthly_fee;
	
	public int getStudent_auto_id() {
		return student_auto_id;
	}
	public void setStudent_id(int student_auto_id) {
		this.student_auto_id = student_auto_id;
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
	
	
	public String getStudent_address() {
		return student_address;
	}
	public void setStudent_address(String student_address) {
		this.student_address = student_address;
	}
	
	
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getGuardian_name() {
		return guardian_name;
	}
	public void setGuardian_name(String guardian_name) {
		this.guardian_name = guardian_name;
	}
	
	
	public String getIndex() {
		return index;
	}
	public void setIndex(String index) {
		this.index = index;
	}
	public String getSchool_name() {
		return school_name;
	}
	public void setSchool_name(String school_name) {
		this.school_name = school_name;
	}
	public String getMobile1() {
		return mobile1;
	}
	public void setMobile1(String mobile1) {
		this.mobile1 = mobile1;
	}
	public String getMobile2() {
		return mobile2;
	}
	public void setMobile2(String mobile2) {
		this.mobile2 = mobile2;
	}
	
	public StudentModel(String firstname) {
		super();
		this.firstname = firstname;
	}
	public StudentModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getJoined_date() {
		return joined_date;
	}
	public void setJoined_date(String joined_date) {
		this.joined_date = joined_date;
	}
	
	

	
	public Set<PaymentModel> getPayments() {
		return payments;
	}
	public void setPayments(Set<PaymentModel> payments) {
		this.payments = payments;
	}
	
	public String getMonthly_fee() {
		return monthly_fee;
	}
	public void setMonthly_fee(String monthly_fee) {
		this.monthly_fee = monthly_fee;
	}
	public Set<ClassesModel> getClasses() {
		return classes;
	}
	public void setClasses(Set<ClassesModel> classes) {
		this.classes = classes;
	}
	/*@Override
	    public String toString() {
	        return "StudentModel{" +
	                "id=" + student_auto_id +
	                ", name='" + firstname + lastname+ '\'' +
	                 ", address='" + student_address + '\'' +
	                 ", grade='" + grade + '\'' +
	                 ", address='" + guardian_name + '\'' +
	                 ", guardian='" + guardian_name + '\'' +
	                 ", school='" + school_name + '\'' +
	                 ", mobile1='" + mobile1 + '\'' +
	                 ", mobile2='" + mobile2 + '\'' +
	                  ", joined_date='" + joined_date + '\'' +
	                ", studentClasses='" + classes.stream().map(ClassesModel::getClass_name).collect(Collectors.toList()) + '\'' +
	                '}';
	    }*/

}
