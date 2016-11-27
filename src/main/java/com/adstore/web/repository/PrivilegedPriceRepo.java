package com.adstore.web.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import com.adstore.web.entity.PrivilegedPriceEntity;

@Transactional
public interface PrivilegedPriceRepo extends CrudRepository<PrivilegedPriceEntity, Long> {
	public List<PrivilegedPriceEntity> findByCustomerId(int customerId);
}
