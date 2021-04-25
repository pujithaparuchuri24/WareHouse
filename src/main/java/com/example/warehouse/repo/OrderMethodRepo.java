package com.example.warehouse.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.warehouse.model.OrderMethod;
@Repository
public interface OrderMethodRepo extends JpaRepository<OrderMethod, Integer> {

}
