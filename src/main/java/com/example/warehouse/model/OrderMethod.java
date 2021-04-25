package com.example.warehouse.model;

import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="order_method")
@Data
public class OrderMethod {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="order_id")
	private Integer id;
	@Column(name="order_mode")
	private String orderMode;
	@Column(name="order_code")
	private String orderCode;
	@Column(name="order_type")
	private String orderType;
	@ElementCollection
	@CollectionTable(
			name="order_acpt_tab",
			joinColumns = @JoinColumn(name="ord_id_col")
			)
	@Column(name="ord_acpt_col")
	private Set<String> orderAcpt;


	@Column(name="ord_desc_col")
	private String orderDesc;




}
