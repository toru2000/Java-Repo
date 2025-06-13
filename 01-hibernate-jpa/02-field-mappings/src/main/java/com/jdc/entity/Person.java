package com.jdc.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.TableGenerator;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "person_tbl")
public class Person {
	
	@Id
	@GeneratedValue(generator = "person_gen_tbl")
	//@SequenceGenerator(name="person_seq",initialValue = 1,allocationSize = 1)
	@TableGenerator(name="person_gen_tbl",initialValue = 1,allocationSize = 1)
	private int id;
	private String name;
	private int age;

}
