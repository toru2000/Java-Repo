package com.jdc.toru.entity;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
@Entity
public class Manager extends Account{

	public Manager(){
		setAccountType(AccountType.MANAGER);
	}
}
