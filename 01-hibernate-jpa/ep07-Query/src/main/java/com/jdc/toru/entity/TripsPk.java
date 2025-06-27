package com.jdc.toru.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import org.hibernate.annotations.DynamicInsert;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.MapsId;
import lombok.Data;

@Data
@Embeddable
@DynamicInsert
public class TripsPk implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Column(name = "drivers_id")
	private int driversId;
	
	@Column(name = "passengers_id")
	private int passengersId;
	
	@Column(name = "payments_id")  
	private int paymentsId;          // @MapsId("paymentsId")
	
	@Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private LocalDateTime tripAt;
}
