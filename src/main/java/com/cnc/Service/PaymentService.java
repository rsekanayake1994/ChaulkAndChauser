package com.cnc.Service;

import java.util.List;
import java.util.Optional;

import com.cnc.Model.PaymentModel;

public interface PaymentService {

	

	String savePayment(PaymentModel paymentData);

	Optional<PaymentModel> findById(Integer id);




	
	
}
