package com.billms.model;

import java.util.List;

public class CreateBillModel {
	private List<BillDataModel> bills;
	private String dueDate;
	public CreateBillModel(List<BillDataModel> bills, String dueDate) {
		super();
		this.bills = bills;
		this.dueDate = dueDate;
	}
	public CreateBillModel() {
		super();
	}
	public List<BillDataModel> getBills() {
		return bills;
	}
	public void setBills(List<BillDataModel> bills) {
		this.bills = bills;
	}
	public String getDueDate() {
		return dueDate;
	}
	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}

	
}
