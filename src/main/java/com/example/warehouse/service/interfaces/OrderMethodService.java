package com.example.warehouse.service.interfaces;

import java.util.List;
import java.util.Optional;

import com.example.warehouse.model.OrderMethod;

public interface OrderMethodService {
	public int OrderSave(OrderMethod o);
	public Optional<OrderMethod> getById(int id);
	public List<OrderMethod> getAll();
	public int orderDelete(int id);
	public int update(OrderMethod o);

}
