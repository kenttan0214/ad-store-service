package com.adstore.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.adstore.web.entity.AdvertisementEntity;
import com.adstore.web.services.AdvertisementService;

@RestController
public class AdvertisementCtrl {
	@Autowired
	private AdvertisementService advertisementService;

	@RequestMapping(value = "/advertisements", method = RequestMethod.GET)
	public ResponseEntity<Object> getAdvertisements() {
		List<AdvertisementEntity> avertisements = advertisementService.getAllAdvertisement();
		return new ResponseEntity<Object>(avertisements, HttpStatus.OK);
	}

}
