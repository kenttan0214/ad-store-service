package com.adstore.web.entity;

import java.io.Serializable;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
@Table(name="advertisement_package")
@AttributeOverrides({
		@AttributeOverride(name = "id", column = @Column(name = "id", unique = true, nullable = false)),
		@AttributeOverride(name = "adDesc", column = @Column(name = "adDesc", nullable = false)),
		@AttributeOverride(name = "adId", column = @Column(name = "adId", nullable = false))
})
public class AdvertisementPackage implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String adDesc;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "adId", nullable = false)
	private AdvertisementEntity advertisement = new AdvertisementEntity();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAdDesc() {
		return adDesc;
	}

	public void setAdDesc(String adDesc) {
		this.adDesc = adDesc;
	}

	@JsonIgnore
	public AdvertisementEntity getAdvertisement() {
		return advertisement;
	}

	@JsonProperty(access = Access.WRITE_ONLY)
	public void setAdvertisement(AdvertisementEntity advertisement) {
		this.advertisement = advertisement;
	}
}
