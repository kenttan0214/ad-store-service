package com.adstore.web.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adstore.web.entity.CustomerEntity;
import com.adstore.web.entity.PrivilegedPriceEntity;
import com.adstore.web.repository.CustomerRepo;
import com.adstore.web.repository.PrivilegedPriceRepo;

@Service
public class PrivilegedPriceService {
	@Autowired
	private PrivilegedPriceRepo privilegedPriceRepo;

	@Autowired
	private CustomerRepo customerRepo;

	public List<PrivilegedPriceEntity> getPrivilegedPriceByCustId(String custName) {
		List<PrivilegedPriceEntity> privilegedPriceList = null;

		if (custName != null) {
			CustomerEntity custDetails = customerRepo.findByCustName(custName.toLowerCase());

			if (custDetails != null && custDetails.getId() != 0) {
				privilegedPriceList = privilegedPriceRepo.findByCustomerId(custDetails.getId());
			}
		}

		if (privilegedPriceList == null) {
			privilegedPriceList = new ArrayList<PrivilegedPriceEntity>();
		}

		return privilegedPriceList;
	}

}
