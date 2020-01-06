package com.example.demo.entity;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
@Entity
@Data
@Table(name="address")
public class AddressEntity {
		@Id
		private Integer id;
		@Column(name = "houseno")
		private String houseNo;

		@Column(name="name")
		private String ownerName;

		public String getOwnerName() {
			return ownerName;
		}
		
		
		@Column(name = "streetaddress")
		private String streetAddress;
		@Column(name = "city")
		private String city;
		@Column(name = "state")
		private String state;
		@Column(name = "zipcode")
		private String zipCode;

	    
		
		
}
