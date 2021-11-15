package com.billms.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.billms.model.BillDataModel;
import com.billms.model.CreateBillModel;
import com.billms.repository.BillRepository;
import com.billms.repository.BillRepositoryTemplate;

@Service
public class BillServiceImpl implements BillService {
	
	@Autowired
	BillRepository billRepository;
	
	@Autowired
	BillRepositoryTemplate billRepositoryTemplate;
	
	public String createBill(CreateBillModel createBillModel) {		
		int maxBillNo = billRepository.findFirstByOrderByBillNumberDesc().getBillNumber();
		
		String dueDateString = createBillModel.getDueDate();
		SimpleDateFormat dateFormatter = new SimpleDateFormat("dd-MM-yy");
		Date dueDate = new Date();
		try {
			dueDate = dateFormatter.parse(dueDateString);
		}
		catch (ParseException e) {
			// TODO: handle exception
			System.out.println("Date not in correct format");
		}
		
		List<BillDataModel> bills =  createBillModel.getBills();
		for (BillDataModel bill : bills) {
			bill.setBillNumber(++maxBillNo);
			bill.setDueDate(dueDate);
			bill.setBilledDate(new Date());
			bill.setTotalPrice(bill.getBilledPrice() * (100 + bill.getTaxOnBill()) / 100);
		}
		
		billRepository.saveAll(bills);
		 
		return "Bills added successfully.";
	}
	
	public List<BillDataModel> fetchAllBillss(){
		return billRepository.findAll();
	}
	
	public BillDataModel fetchBillByNo(int billNo){
		return billRepository.findByBillNumber(billNo);
	}
	
	public List<BillDataModel> fetchDuebillsByDate(String dueDate){
		SimpleDateFormat dateFormatter = new SimpleDateFormat("dd-MM-yy");
		Date start = new Date();
		Date end = new Date();
		
		try {
			start = dateFormatter.parse(dueDate);
			Calendar c = Calendar.getInstance();
			c.setTime(start);
			c.add(Calendar.DATE, 1);
			end = c.getTime();
		}
		catch (ParseException e) {
			// TODO: handle exception
			System.out.println("Date no in correct format");
		}
		return billRepositoryTemplate.findByDate(start, end);
	}


}
