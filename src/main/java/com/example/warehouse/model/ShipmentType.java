package com.example.warehouse.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
@Data
@Entity
@Table(name="shpmnt_type")
public class ShipmentType {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
@Column(name="sh_id")
private Integer id;
@Column(name="sh_mode")
private String shipmentMode;
@Column(name="sh_code")
private String shipmentCode;
@Column(name="enable_shipment")
private String enableShipment;
@Column (name="sh_grade")
private String grade;
@Column(name="sh_desc")
private String desc;




}
