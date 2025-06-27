package com.jdc.toru.entity;


import java.security.Timestamp;

import org.hibernate.annotations.Check;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;

import com.jdc.toru.listener.EnableTimesEntity;
import com.jdc.toru.listener.Times;
import com.jdc.toru.listener.TimesListener;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.ExcludeDefaultListeners;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@DynamicInsert    //query hte hte pay tr pe column a nay ne pr kyan tr ma pr
@RequiredArgsConstructor
//@EntityListeners(TimesListener.class)
@ExcludeDefaultListeners
public class Product implements EnableTimesEntity{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NonNull
	@Column(nullable = false, unique = true)
	private  String name;
	
	@NonNull
	@Column(nullable = false ) //columnDefinition = "double(5,2) check(price > 0.00)")  //column def hte ka () hte mht ka db ka tine yay pay ya mal
	@Check(constraints = "price > 0")
	private  Double price;
	
	@ManyToOne(fetch = FetchType.LAZY
			,cascade = {CascadeType.PERSIST,CascadeType.MERGE})
	private Category category;
	
	public void addCategory(Category c) {
		this.setCategory(c);
	}
	
	@Column(columnDefinition = "boolean default true")
	private Boolean active;
	
	@Embedded
	private Times times;
}
