package com.billms.model;

import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Bills")
public class BillDataModel {
	private String _id;
	private int billNumber;
	private String billedTo;
	private Date billedDate;
	private int billedPrice;
	private int taxOnBill;
	private int totalPrice;
	
	private Date dueDate;

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public int getBillNumber() {
		return billNumber;
	}

	public void setBillNumber(int billNumber) {
		this.billNumber = billNumber;
	}

	public String getBilledTo() {
		return billedTo;
	}

	public void setBilledTo(String billedTo) {
		this.billedTo = billedTo;
	}

	public Date getBilledDate() {
		return billedDate;
	}

	public void setBilledDate(Date billedDate) {
		this.billedDate = billedDate;
	}

	public int getBilledPrice() {
		return billedPrice;
	}

	public void setBilledPrice(int billedPrice) {
		this.billedPrice = billedPrice;
	}

	public int getTaxOnBill() {
		return taxOnBill;
	}

	public void setTaxOnBill(int taxOnBill) {
		this.taxOnBill = taxOnBill;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public BillDataModel(String _id, int billNumber, String billedTo, Date billedDate, int billedPrice, int taxOnBill,
			int totalPrice, Date dueDate) {
		super();
		this._id = _id;
		this.billNumber = billNumber;
		this.billedTo = billedTo;
		this.billedDate = billedDate;
		this.billedPrice = billedPrice;
		this.taxOnBill = taxOnBill;
		this.totalPrice = totalPrice;
		this.dueDate = dueDate;
	}
}
