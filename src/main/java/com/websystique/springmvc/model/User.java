package com.websystique.springmvc.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="USER")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Size(min=3, max=50)
	@Column(name = "name", nullable = false)
	private String name;
	
	@Size(min=3, max=50)
	@Column(name = "wechatnumber",unique=true, nullable = false)
	private String wechatnumber;
	
	@Column(name = "address",  nullable = false)
	private String address;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public String getWechatnumber() {
		return wechatnumber;
	}

	public void setWechatnumber(String wechatnumber) {
		this.wechatnumber = wechatnumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((wechatnumber == null) ? 0 : wechatnumber.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof User))
			return false;
		User other = (User) obj;
		if (id != other.id)
			return false;
		if (wechatnumber == null) {
			if (other.wechatnumber != null)
				return false;
		} else if (!wechatnumber.equals(other.wechatnumber))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", wechatnumber="
				+ wechatnumber + ", address=" + address + "]";
	}
	
	
	

}
