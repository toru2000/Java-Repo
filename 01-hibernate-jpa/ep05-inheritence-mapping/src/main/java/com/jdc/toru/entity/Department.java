package com.jdc.toru.entity;

import java.awt.Color;

import com.jdc.toru.entity.converters.ColorConverter;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@RequiredArgsConstructor
public class Department {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NonNull
	private Integer id;
	
	@Column(nullable = false,unique = true,length = 30)
	private String name;
	
	@Convert(converter = ColorConverter.class)
	private Color color;
	
//	public Department(int id) {
//		this.id = id;
//	}
}
