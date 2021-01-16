package com.cnc.ServiceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cnc.Model.PaymentModel;

import com.cnc.Repository.PaymentRepository;
import com.cnc.Service.PaymentService;
@Service
public class PaymentServiceImpl implements PaymentService{

	@Autowired

	private PaymentRepository paymentrepository;
	
	@Override
	public String savePayment(PaymentModel paymentData) {
		paymentrepository.save(paymentData);
		return "Data Saved";
	}

	@Override
	public Optional<PaymentModel> findById(Integer id) {
		return paymentrepository.findById(id);
		
	}

	




}
