package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="visitor")
public class VisitorEntity {
	@Id
	@Column
	private Integer id;
	@Column
	private String date;
	@Column
	private Integer vistor;
	

}
