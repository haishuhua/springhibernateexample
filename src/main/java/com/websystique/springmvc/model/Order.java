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
@Table(name="ORDER")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "itemid", nullable = false)
	private int itemid;
	
	@Column(name = "userid", nullable = false)
	private int userid;
	
	@Column(name = "trackingnumber", nullable = false)
	private String trackingnumber;
	
	@Column(name = "datetime",  nullable = false)
	private LocalDate address;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getItemid() {
		return itemid;
	}

	public void setItemid(int itemid) {
		this.itemid = itemid;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getTrackingnumber() {
		return trackingnumber;
	}

	public void setTrackingnumber(String trackingnumber) {
		this.trackingnumber = trackingnumber;
	}

	public LocalDate getAddress() {
		return address;
	}

	public void setAddress(LocalDate address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", itemid=" + itemid + ", userid=" + userid
				+ ", trackingnumber=" + trackingnumber + ", address=" + address
				+ "]";
	}
	
	
}
