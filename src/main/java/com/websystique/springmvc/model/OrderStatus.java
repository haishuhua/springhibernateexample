package com.websystique.springmvc.model;


import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="ORDERSTATUS")
public class OrderStatus {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "orderid", nullable = false)
	private String orderid;
	
	@Column(name = "trackingnumber", nullable = false)
	private String trackingnumber;
	
	@Column(name = "status", nullable = false)
	private String status;
	
	
	@Column(name = "datetime",  nullable = false)
	private LocalDate address;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOrderid() {
		return orderid;
	}

	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}

	public String getTrackingnumber() {
		return trackingnumber;
	}

	public void setTrackingnumber(String trackingnumber) {
		this.trackingnumber = trackingnumber;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LocalDate getAddress() {
		return address;
	}

	public void setAddress(LocalDate address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "OrderStatus [id=" + id + ", orderid=" + orderid
				+ ", trackingnumber=" + trackingnumber + ", status=" + status
				+ ", address=" + address + "]";
	}
	
	
}
