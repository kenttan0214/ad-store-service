package com.adstore.web.entity;

import java.io.Serializable;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="privileged_price")
@AttributeOverrides({
		@AttributeOverride(name = "id", column = @Column(name = "id", unique = true, nullable = false)),
		@AttributeOverride(name = "customerId", column = @Column(name = "customerId", nullable = false)),
		@AttributeOverride(name = "advId", column = @Column(name = "advId", nullable = false)),
		@AttributeOverride(name = "minimumAdv", column = @Column(name = "minimumAdv", nullable = false)),
		@AttributeOverride(name = "exactQty", column = @Column(name = "exactQty", nullable = false)),
		@AttributeOverride(name = "privilegedDesc", column = @Column(name = "privilegedDesc", nullable = false)),
		@AttributeOverride(name = "price", column = @Column(name = "price", nullable = false))
})
public class PrivilegedPriceEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int customerId;
	private String advId;
	private int minimumAdv;
	private Boolean exactQty;
	private String privilegedDesc;
	private float price;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getAdvId() {
		return advId;
	}
	public void setAdvId(String advId) {
		this.advId = advId;
	}
	public int getMinimumAdv() {
		return minimumAdv;
	}
	public void setMinimumAdv(int minimumAdv) {
		this.minimumAdv = minimumAdv;
	}
	public Boolean getExactQty() {
		return exactQty;
	}
	public void setExactQty(Boolean exactQty) {
		this.exactQty = exactQty;
	}
	public String getPrivilegedDesc() {
		return privilegedDesc;
	}
	public void setPrivilegedDesc(String privilegedDesc) {
		this.privilegedDesc = privilegedDesc;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	
	
}
