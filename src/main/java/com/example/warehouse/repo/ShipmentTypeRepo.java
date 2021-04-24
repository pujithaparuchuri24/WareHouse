package com.example.warehouse.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.warehouse.model.ShipmentType;
@Repository
public interface ShipmentTypeRepo extends JpaRepository<ShipmentType, Integer> {

}
