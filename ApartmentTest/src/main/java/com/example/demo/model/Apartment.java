package com.example.demo.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Apartment {
	private Integer apartmentId;
	private String ownerName;
	private Address address;
	
	public Apartment(Integer apartmentId, String ownerName, Address address) {
		super();
		this.apartmentId = apartmentId;
		this.ownerName = ownerName;
		this.address = address;
	}
	


}
