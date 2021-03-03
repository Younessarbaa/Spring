package com.brightcoding.app.ws.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;



@Entity(name = "addresses")
public class AddressEntity implements Serializable  {

	private static final long serialVersionUID = -3492236730470136101L;
	
	@Id //generate id's
	@GeneratedValue
	private long id; 
	
	@Column(nullable = false, length = 30)
	private String addressId;
	
	@Column(nullable = false, length = 20)
	private String city;
	
	@Column(nullable = false, length =20 )
	private String country;
	
	@Column(nullable = false, length = 50)
	private String street;
	
	@Column(nullable = false, length = 7)
	private String postal_code;
	
	@Column(nullable = false, length = 20)
	private String type;
	
	@ManyToOne
	@JoinColumn(name="users_id")
	private UserEntity user;
	
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAddressId() {
		return addressId;
	}

	public void setAddressId(String addressId) {
		this.addressId = addressId;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getPostal_code() {
		return postal_code;
	}

	public void setPostal_code(String postal_code) {
		this.postal_code = postal_code;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}


	
}
