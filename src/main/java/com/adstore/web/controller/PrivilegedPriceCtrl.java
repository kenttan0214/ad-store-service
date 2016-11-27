package com.adstore.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.adstore.web.entity.PrivilegedPriceEntity;
import com.adstore.web.services.PrivilegedPriceService;

@RestController
public class PrivilegedPriceCtrl {
	@Autowired
	private PrivilegedPriceService privilegedPriceService;

	@RequestMapping(value = "/privileged", method = RequestMethod.GET)
	public ResponseEntity<Object> getPrivilegedPriceByCustomerId(@RequestParam("customerName") String customerName) {
		List<PrivilegedPriceEntity> privilegedPrices = privilegedPriceService.getPrivilegedPriceByCustId(customerName);
		return new ResponseEntity<Object>(privilegedPrices, HttpStatus.OK);
	}
}
