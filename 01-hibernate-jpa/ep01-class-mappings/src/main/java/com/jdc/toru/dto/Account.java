package com.jdc.toru.dto;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.SecondaryTable;
import jakarta.persistence.SecondaryTables;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "account_tbl",
		indexes = {
			@Index(columnList = "username")	
		},
		uniqueConstraints = {
			@UniqueConstraint(columnNames = "username")	   //table level ka thet mhat
		}
) 

//@SecondaryTables({
//	@SecondaryTable(name = "address_tbl"),
//	@SecondaryTable(name = "con_tbl")
//})
@SecondaryTable(name = "address_tbl")
public class Account {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String username;
	private String password;
	private boolean active;
	
	
	@Column(table = "address_tbl")   //secondryTable
	private String city;
	@Column(table = "address_tbl")
	private String township;
	@Column(table = "address_tbl")
	private String street;
	
	//@Embedded
	private Contact contact;
}
