package com.adstore.web.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adstore.web.entity.CustomerEntity;
import com.adstore.web.repository.CustomerRepo;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepo customerRepo;

	public CustomerEntity getCustByCustId(String custName) {
		CustomerEntity custDetails = new CustomerEntity();
		
		if (custName != null) {
			custDetails = customerRepo.findByCustName(custName);
		}
		
		return custDetails;
	}
}
