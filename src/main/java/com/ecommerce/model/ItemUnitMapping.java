package com.ecommerce.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.ecommerce.util.Constants;

@Entity
@Table(name="itemunitmapping")
public class ItemUnitMapping {

	@Id
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	@Column(name="id", columnDefinition = Constants.VARCHAR_32)
	private String itemUnitMappingId;
	
	@Column(name="itemid", columnDefinition = Constants.VARCHAR_32)
	private String itemId;
	
	@Column(name="unitid", columnDefinition = Constants.VARCHAR_32)
	private String unitId;
	
	@Column(name="quantity", columnDefinition = "DOUBLE")
	private String quantity;
	
	@Column(name="price", columnDefinition = "DOUBLE")
	private Double price;
	
	
	
}
