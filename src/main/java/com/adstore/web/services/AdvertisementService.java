package com.adstore.web.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adstore.web.entity.AdvertisementEntity;
import com.adstore.web.repository.AdvertisementRepo;

@Service
public class AdvertisementService {

	@Autowired
	private AdvertisementRepo advertisementRepo;
	
	public List<AdvertisementEntity> getAllAdvertisement() {
		List<AdvertisementEntity> advertisementList = advertisementRepo.findAll();

		if (advertisementList == null) {
			advertisementList = new ArrayList<AdvertisementEntity>();
		}
		return advertisementList;
	}
}
