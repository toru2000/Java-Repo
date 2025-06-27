package com.jdc.toru.entity;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.DynamicInsert;

import com.jdc.toru.listener.EnableTimesEntity;
import com.jdc.toru.listener.Times;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@DynamicInsert
@NoArgsConstructor
@RequiredArgsConstructor
public class Category implements EnableTimesEntity{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NonNull
	@Column(nullable = false, unique = true)
	private  String name;
	
	@Column(columnDefinition = "boolean default true")
	private Boolean active;
	
	@OneToMany(mappedBy = "category",
			cascade = {CascadeType.PERSIST, CascadeType.REMOVE}) 
			//orphanRemoval = true)  //private Category category; field name
	private List<Product> products = new ArrayList<Product>();
	
	public void addProduct(Product...ps) {  //helper method for cascade
		for(Product p : ps) {
			p.setCategory(this);  //this -> lat si category //new ma sout
			products.add(p);
		}
		
	}
	
	@Embedded
	private Times times;

}
