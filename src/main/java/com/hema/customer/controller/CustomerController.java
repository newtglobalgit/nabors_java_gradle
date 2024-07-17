package com.hema.customer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hema.customer.model.Customer;
import com.hema.customer.service.CustomerService;

@RestController
@RequestMapping("/api")
public class CustomerController 
{
	@Autowired
	private CustomerService customerService;
	
	@PostMapping("/add")
	public Customer add(@RequestBody Customer customer)
	{
		return customerService.addCustomer(customer);
		
	}
	
	@GetMapping("/get")
	public List<Customer> get()
	{
		List<Customer> customers  = customerService.getCustomers();
		return customers;
	}
	
	@GetMapping("/get/{id}")
	public Customer getById(@PathVariable int id)
	{
		Customer cust = customerService.getById(id);
		if(cust != null)
		{
			return cust;
		}
		return null;
	}
	
	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable int id)
	{
		String result = customerService.deleteCustomer(id);
		if(result != null)
			return "Customer Id "+id+" deleted" ;
		else
			return "Id "+id+" not found";
		
	}
}
