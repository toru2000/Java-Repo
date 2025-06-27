package com.jdc.toru.entity;

import java.io.Serializable;

import org.hibernate.annotations.Check;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Embeddable
public class Contact implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Column(nullable = false,length = 45,unique = true)
	@Check(constraints = "email REGEXP '^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\\\.[A-Za-z]{2,}$'")
	private String email;
	
	@Column(nullable = false,length = 11,unique = true)
	private String phone;
	
}
