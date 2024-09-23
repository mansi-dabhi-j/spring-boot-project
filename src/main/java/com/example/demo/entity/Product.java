package com.example.demo.entity;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
@Table(name="product")
public class Product {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@Column(name="p_name")
	private String name;
	@Column(name="image_url")
	private String imgurl;
	@Column(name="p_description")
	private String desciption;
	@Column(name="p_price")
	private BigDecimal price;
	@Column(name="brand_name")
	private String brandname;
	
	  @ManyToOne 
	  @JoinColumn(name="category_id", nullable = false) 
	  private Category category; 
	

}
