package com.cnc.Model;
import java.util.List;

import javax.persistence.*;



import com.fasterxml.jackson.annotation.JsonManagedReference;
@Entity
@Table(name="months")

public class MonthModel extends AuditModel{
	private static final long serialVersionUID = 1L;
	
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY )
	@Column(name="month_id")
	private int month_id;
	
	
	@Column(name="month")
	private String month;
	
	//@OneToMany(cascade = CascadeType.ALL,
	          // fetch = FetchType.LAZY,
	          // targetEntity = PaymentModel.class)
		//@JoinColumn(name="payment_id",referencedColumnName="month_id")
	//@JsonManagedReference(value="month-payment")
	  //  private List <PaymentModel> payments;

	

	public int getMonth_id() {
		return month_id;
	}

	public void setMonth_id(int month_id) {
		this.month_id = month_id;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

/*	public List<PaymentModel> getPayments() {
		return payments;
	}

	public void setPayments(List<PaymentModel> payments) {
		this.payments = payments;
	}*/
	
	
}
