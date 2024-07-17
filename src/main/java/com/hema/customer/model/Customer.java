package com.hema.customer.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Customer 
{
	@Id
	private int customer_id;
	private String customer_name;
	private long phno;
	private String location;
	
	public Customer() {}
	
	public int getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}
	public String getCustomer_name() {
		return customer_name;
	}
	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}
	public long getPhno() {
		return phno;
	}
	public void setPhno(long phno) {
		this.phno = phno;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}

	public Customer(int customer_id, String customer_name, long phno, String location) {
		super();
		this.customer_id = customer_id;
		this.customer_name = customer_name;
		this.phno = phno;
		this.location = location;
	}
	
	
	

}
