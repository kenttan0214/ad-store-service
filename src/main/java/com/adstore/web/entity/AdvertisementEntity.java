package com.adstore.web.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="advertisement")
@AttributeOverrides({
		@AttributeOverride(name = "id", column = @Column(name = "adId", unique = true, nullable = false)),
		@AttributeOverride(name = "adName", column = @Column(name = "adName", nullable = false)),
		@AttributeOverride(name = "stdPrice", column = @Column(name = "stdPrice", nullable = false))
})
public class AdvertisementEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	private String id;
	private String adName;
	private float stdPrice;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "advertisement", cascade = CascadeType.ALL)
	private List<AdvertisementPackage> adPackages = new ArrayList<AdvertisementPackage>(0);

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAdName() {
		return adName;
	}

	public void setAdName(String adName) {
		this.adName = adName;
	}

	public float getStdPrice() {
		return stdPrice;
	}

	public void setStdPrice(float stdPrice) {
		this.stdPrice = stdPrice;
	}

	public Collection<AdvertisementPackage> getAdPackages() {
		return adPackages;
	}

	public void setAdPackages(List<AdvertisementPackage> adPackages) {
		this.adPackages = adPackages;
	}
}
