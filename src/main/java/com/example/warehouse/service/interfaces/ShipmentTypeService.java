package com.example.warehouse.service.interfaces;

import java.util.List;
import java.util.Optional;

import com.example.warehouse.model.ShipmentType;

public interface ShipmentTypeService {
  public int ShipmentTypeSave(ShipmentType s);
  public Optional<ShipmentType> ShipmentTypeGetByID(int id); 
  public List<ShipmentType> ShipmentTypeGetAll();
  public String ShipmentTypeDelete(int id);
}