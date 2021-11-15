package com.billms.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.billms.model.BillDataModel;

public interface BillRepository extends MongoRepository<BillDataModel, String>{
	
	BillDataModel findByBillNumber(int seatNumber);
	
	BillDataModel findFirstByOrderByBillNumberDesc();

		
}
