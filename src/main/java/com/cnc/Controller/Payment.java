package com.cnc.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cnc.Model.PaymentModel;
import com.cnc.Service.PaymentService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/payments")
public class Payment {

	@Autowired
	private PaymentService paymentservices;
	
	@PostMapping("/dopayment")
	public String doPayment(@RequestBody PaymentModel paymentData ) {
		return paymentservices.savePayment(paymentData);
		
	}
	
	@PutMapping("/updatepayment/{id}")
	public String updatePayment(@RequestBody PaymentModel paymentData,@PathVariable Integer id) {
		Optional<PaymentModel> paymentOptional=paymentservices.findById(id);
		if (!paymentOptional.isPresent())
			return  ("Payment id not Valid");
		paymentData.setPayment_id(id);
		return paymentservices.savePayment(paymentData);
	}
	
	
}
