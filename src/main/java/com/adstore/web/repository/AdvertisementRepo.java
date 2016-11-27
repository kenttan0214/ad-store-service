package com.adstore.web.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.Repository;

import com.adstore.web.entity.AdvertisementEntity;

@Transactional
public interface AdvertisementRepo extends Repository<AdvertisementEntity, Long> {
	public List<AdvertisementEntity> findAll();
}
