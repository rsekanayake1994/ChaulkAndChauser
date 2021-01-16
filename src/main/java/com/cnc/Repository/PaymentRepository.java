package com.cnc.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;

import com.cnc.Model.PaymentModel;



public interface PaymentRepository extends JpaRepository<PaymentModel,Integer>{

	Optional<PaymentModel> findById(Integer id);

	

}
