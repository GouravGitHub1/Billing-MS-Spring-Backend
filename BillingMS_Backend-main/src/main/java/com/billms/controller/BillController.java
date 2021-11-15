package com.billms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.billms.model.BillDataModel;
import com.billms.model.CreateBillModel;
import com.billms.service.BillService;

@RestController
@RequestMapping("bills")
@CrossOrigin
public class BillController {
	
	@Autowired
	BillService billService;
	
	@PostMapping(value = "/add")
	private String createBill(@RequestBody CreateBillModel createBillModel){
		return billService.createBill(createBillModel);
	}
	
	@GetMapping(value = "")
	private List<BillDataModel> fetchAllBillss() {
		return billService.fetchAllBillss();
	}
	
	@GetMapping(value = "/{billNo}")
	private BillDataModel fetchBillByNo(@PathVariable int billNo) {
		return billService.fetchBillByNo(billNo);
	}
	
	@GetMapping(value = "/due/{dueDate}")
	private List<BillDataModel> fetchDuebillsByDate(@PathVariable String dueDate) {
		return billService.fetchDuebillsByDate(dueDate);
	}
	
}
