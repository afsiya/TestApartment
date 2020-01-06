package com.example.demo.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor

public class Address {
	private String houseNo;
	private String streetAddress;
	private String city;
	private String state;
	private String zipCode;
	private Integer id;
	public Address(String houseNo, String streetAddress, String city, String state, String zipCode, Integer id) {
		super();
		this.houseNo = houseNo;
		this.streetAddress = streetAddress;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
		this.id = id;
	}
	
	
	
}
