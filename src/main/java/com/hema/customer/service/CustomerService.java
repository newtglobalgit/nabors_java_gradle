package com.hema.customer.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hema.customer.model.Customer;
import com.hema.customer.repo.CustomerRepo;

@Service
public class CustomerService 
{
	@Autowired
	private CustomerRepo customerRepo;
	
	public Customer addCustomer(Customer customer)
	{
		return customerRepo.save(customer);
	}

	public List<Customer> getCustomers() {
		
		return customerRepo.findAll();
	}
	
	public String deleteCustomer(int id)
	{
		Customer cust = customerRepo.findById(id).orElse(null);
		if(cust != null)
		{
			customerRepo.deleteById(id);
			return "deleted";
		}
		else
		{
			return null;
		}
		
		
	}

	public Customer getById(int id) 
	{
		Customer cust = customerRepo.findById(id).orElse(null);
		if(cust != null)
		{	
			return cust;
		}
		else
		{
			return null;
		}
		
		
	}

}
