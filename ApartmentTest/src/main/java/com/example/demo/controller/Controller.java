package com.example.demo.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Apartment;
import com.example.demo.model.Visitor;
import com.example.demo.service.AppartmentService;


@RestController
public class Controller {
	@Autowired(required=false)
	private AppartmentService s;

	@PostMapping("/create-user")
	public Apartment add(@RequestBody Apartment a) {
		s.add(a);
		
	return a;
	}
	
	@GetMapping("/get-user/{id}")
	public ResponseEntity<Object> getById(@PathVariable Integer id) {
		if(s.getByApartmentid(id)==null)
		{
			return ResponseEntity.badRequest()
		            .body("Id not found");
		}
		else
		{
			return  ResponseEntity.status(HttpStatus.OK)
			        .body(s.getByApartmentid(id));
		
		}
	
	}
	@GetMapping("/visitor/{id}/{date}/{actortype}")
	public ResponseEntity<Object> getVisitor(@PathVariable Integer id,@PathVariable String date,@PathVariable String actortype) {
		if( s.getVisitor(id, date,actortype)==null)
		{
			return ResponseEntity.badRequest()
		            .body("you cannot acess the data");
		}
		else
		{
			return  ResponseEntity.status(HttpStatus.OK)
			        .body(s.getVisitor(id, date,actortype));
		}
		
		
	
	}
	@GetMapping("/all-user")
	public ResponseEntity<Object> findall()
	{
		List<Apartment>list=s.getall();
		if(list.size()==0)
		{
			return ResponseEntity.badRequest()
		            .body("Not Found");
		}
		else
		{
			return  ResponseEntity.status(HttpStatus.OK)
			        .body(list);
		}
	}
}
