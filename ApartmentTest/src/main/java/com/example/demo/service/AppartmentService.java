package com.example.demo.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.AddressEntity;
import com.example.demo.entity.VisitorEntity;
import com.example.demo.model.Address;
import com.example.demo.model.Apartment;
import com.example.demo.model.Visitor;
import com.example.demo.repository.AddressRepository;
import com.example.demo.repository.VisitorRepository;

@Service
public class AppartmentService {
	@Autowired
	  private AddressRepository addressRepository;
	@Autowired
	  private VisitorRepository  visitorRepository ;

	public Apartment getByApartmentid(Integer id) {
		Optional<AddressEntity>op=addressRepository.findById(id);
		if(op.isPresent())
		{
			AddressEntity addressEntity=op.get();
			Apartment apartment=new Apartment();
			apartment.setOwnerName(addressEntity.getOwnerName());
			Address address=new Address();
			address.setCity(addressEntity.getCity());
			address.setHouseNo(addressEntity.getHouseNo());
			address.setState(addressEntity.getState());
			address.setStreetAddress(addressEntity.getStreetAddress());
			address.setZipCode(addressEntity.getZipCode());
			apartment.setAddress(address);
			return apartment;	
			
		}
		else 
		{
	return null;
		}

	}


	public void add(Apartment a) {
		
		AddressEntity addressEntity=new AddressEntity();
		addressEntity.setOwnerName(a.getOwnerName());
		addressEntity.setId(a.getApartmentId());
		
		addressEntity.setCity(a.getAddress().getCity());
		addressEntity.setHouseNo(a.getAddress().getHouseNo());
		addressEntity.setState(a.getAddress().getState());
		addressEntity.setStreetAddress(a.getAddress().getStreetAddress());
		addressEntity.setZipCode(a.getAddress().getZipCode());
		
		
		addressRepository.save(addressEntity);
		
		
	}
	public Visitor getVisitor(Integer id,String date,String actortype)
	{
		if(actortype.equals("admin"))
		{
			Visitor v=new Visitor();
			VisitorEntity visitorEntity=  visitorRepository.findByIdAndDate(id, date);
			v.setVno(visitorEntity.getVistor());
		return v;
		}
		else
		{
			return null;
		}
		
		
	}
	public List<AddressEntity>getallapp()
	{
		List<AddressEntity>it=(List<AddressEntity>) addressRepository.findAll();
		return it;
	}
	public List<Apartment> getall()
	{
		
		List<Apartment>list=new ArrayList<Apartment>();
		List<AddressEntity>list1=getallapp();
		list1.stream().map(i->list.add(new Apartment(i.getId(), i.getOwnerName(), new Address(i.getHouseNo(), i.getStreetAddress(), i.getCity(), i.getState(), i.getZipCode(), i.getId())))).collect(Collectors.toList());
		
		
		/*
		 * for(int i=0;i<it.size();i++) { Apartment apartment=new Apartment();
		 * apartment.setOwnerName(it.get(i).getOwnerName()); Address address=new
		 * Address(); address.setCity(it.get(i).getCity());
		 * address.setHouseNo(it.get(i).getHouseNo());
		 * address.setState(it.get(i).getState());
		 * address.setStreetAddress(it.get(i).getStreetAddress());
		 * address.setZipCode(it.get(i).getZipCode()); apartment.setAddress(address);
		 * list.add(apartment); }
		 */
	list.stream().sorted((p1, p2)->p1.getAddress().getHouseNo().compareTo(p2.getAddress().getHouseNo())) .collect(Collectors.toList());
	
		return list;
	}

}
