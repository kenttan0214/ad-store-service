package com.adstore.web.repository;

import javax.transaction.Transactional;

import org.springframework.data.repository.Repository;

import com.adstore.web.entity.AdvertisementPackage;
@Transactional
public interface AdvertisementPackageRepo extends Repository<AdvertisementPackage, Long> {

}
