package com.billms.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.billms.model.BillDataModel;
import com.billms.model.CreateBillModel;

@Service
public interface BillService {

	public String createBill(CreateBillModel createBillModel);
	
	public List<BillDataModel> fetchAllBillss();
	
	public BillDataModel fetchBillByNo(int billNo);

	public List<BillDataModel> fetchDuebillsByDate(String dueDate);
	
	
	
}
