package com.cnc.Model;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
@Entity
@Table(name="payment")

public class PaymentModel extends AuditModel{

	
	private static final long serialVersionUID = 1L;
	
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY )
	@Column(name="payment_id")
	private int payment_id;
	
	@Column(name="payment_date")
	private String payment_date;

	@Column(name="payment_month")
	private String payment_month;
	
	@Column(name="amount")
	private int amount;
	
	
	@Column(name="balance")
	private int balance;
	
	@Column(name="status")
	private String status;
	
	
	
	
	@ManyToOne
    @JoinColumn(name="student_auto_id")
	@JsonBackReference(value="student-payment")
    private StudentModel student;
	
	//@ManyToOne
   // @JoinColumn(name="month_id")
	//@JsonBackReference(value="month-payment")
   // private MonthModel month;

	public int getPayment_id() {
		return payment_id;
	}

	public void setPayment_id(int payment_id) {
		this.payment_id = payment_id;
	}

	public String getPayment_date() {
		return payment_date;
	}

	public void setPayment_date(String payment_date) {
		this.payment_date = payment_date;
	}

	public String getPayment_month() {
		return payment_month;
	}

	public void setPayment_month(String payment_month) {
		this.payment_month = payment_month;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public StudentModel getStudent() {
		return student;
	}

	public void setStudent(StudentModel student) {
		this.student = student;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	/*public MonthModel getMonth() {
		return month;
	}

	public void setMonth(MonthModel month) {
		this.month = month;
	}*/

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}


	
	
}
