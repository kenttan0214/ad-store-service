package com.adstore.web.repository;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import com.adstore.web.entity.CustomerEntity;

@Transactional
public interface CustomerRepo extends CrudRepository<CustomerEntity, Long> {
	public CustomerEntity findByCustName(String custName);
}
