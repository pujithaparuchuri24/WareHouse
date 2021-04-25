package com.example.warehouse.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.warehouse.model.OrderMethod;
import com.example.warehouse.repo.OrderMethodRepo;
import com.example.warehouse.service.interfaces.OrderMethodService;
@Service
public class OrderMethodServiceImpl implements OrderMethodService {
   @Autowired
   private OrderMethodRepo repo;
	@Override
	public int OrderSave(OrderMethod o) {
		return repo.save(o).getId();
	}

	@Override
	public Optional<OrderMethod> getById(int id) {
		return repo.findById(id);
	}

	@Override
	public List<OrderMethod> getAll() {
		return repo.findAll();
	}

	@Override
	public int orderDelete(int id) {
		repo.deleteById(id);
		return id;
	}

	@Override
	public int update(OrderMethod o) {
		return repo.save(o).getId();
	}

}
