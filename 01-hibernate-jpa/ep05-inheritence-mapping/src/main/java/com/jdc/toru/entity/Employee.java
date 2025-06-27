package com.jdc.toru.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@DiscriminatorValue("2")
public class Employee extends Account{
	
	@ManyToOne
	private Department department;
	
	public Employee() {
		setAccountType(AccountType.EMPLOYEE);
	}
	
	public Employee(Department department) {
		this.department = department;
		setAccountType(AccountType.EMPLOYEE);
	}
}
