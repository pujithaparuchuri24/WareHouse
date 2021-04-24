package com.example.warehouse.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public String getShipmentMode() {
	return shipmentMode;
}
public void setShipmentMode(String shipmentMode) {
	this.shipmentMode = shipmentMode;
}
public String getShipmentCode() {
	return shipmentCode;
}
public void setShipmentCode(String shipmentCode) {
	this.shipmentCode = shipmentCode;
}
public String getEnableShipment() {
	return enableShipment;
}
public void setEnableShipment(String enableShipment) {
	this.enableShipment = enableShipment;
}
public String getGrade() {
	return grade;
}
public void setGrade(String grade) {
	this.grade = grade;
}
public String getDesc() {
	return desc;
}
public void setDesc(String desc) {
	this.desc = desc;
}
@Override
public String toString() {
	return "ShipmentType [id=" + id + ", shipmentMode=" + shipmentMode + ", shipmentCode=" + shipmentCode
			+ ", enableShipment=" + enableShipment + ", grade=" + grade + ", desc=" + desc + "]";
}



}
