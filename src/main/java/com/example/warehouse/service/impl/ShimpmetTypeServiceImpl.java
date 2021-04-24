package com.example.warehouse.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.warehouse.model.ShipmentType;
import com.example.warehouse.repo.ShipmentTypeRepo;
import com.example.warehouse.service.interfaces.ShipmentTypeService;
@Service
public class ShimpmetTypeServiceImpl implements ShipmentTypeService {
   @Autowired
   private ShipmentTypeRepo repo;
	@Override
	public int ShipmentTypeSave(ShipmentType s) {
		return repo.save(s).getId();
	}

	@Override
	public  Optional<ShipmentType> ShipmentTypeGetByID(int id) {
		return repo.findById(id);
	}

	@Override
	public List<ShipmentType> ShipmentTypeGetAll() {
		return repo.findAll();
	}

	@Override
	public String ShipmentTypeDelete(int id) {
		 repo.deleteById(id);
		 return "delete "+ id;
	}

}
