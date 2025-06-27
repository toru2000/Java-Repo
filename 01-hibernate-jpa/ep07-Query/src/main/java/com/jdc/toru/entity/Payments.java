package com.jdc.toru.entity;

import org.hibernate.annotations.DynamicInsert;

import com.jdc.toru.listeners.EnableTimesListener;
import com.jdc.toru.listeners.Times;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.TableGenerator;
import lombok.Data;


@Data
@Entity
@Table(name = "payments_tbl")
public class Payments implements EnableTimesListener{
	
	@Id
	@GeneratedValue(generator = "table_gen_payment_tbl")
	@TableGenerator(name = "table_gen_payment_tbl",initialValue = 1,allocationSize = 1)
	private int id;
	
	@Enumerated(EnumType.STRING)
	private PaymentType paymentType;
	
	@Column(columnDefinition = "double default 1000.00")
	private double amount;
	
	@Embedded
	private Times times;
	
	public enum PaymentType{
		KPAY,WAVE,AYA,CASH
	}
}
