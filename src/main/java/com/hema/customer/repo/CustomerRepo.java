package com.hema.customer.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hema.customer.model.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Integer>
{

}
