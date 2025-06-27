package com.jdc.toru.entity;

import com.jdc.toru.listeners.EnableTimesListener;
import com.jdc.toru.listeners.Times;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "trips_tbl")
public class Trips implements EnableTimesListener{
	
	@EmbeddedId
	private TripsPk id;
	
	//@MapsId("driversId")
	@JoinColumn(insertable = false,updatable = false)
	@ManyToOne
	private Drivers drivers;
	
	//@MapsId("pessengersId")
	@JoinColumn(insertable = false,updatable = false)
	@ManyToOne
	private Passengers passengers;
	
	//@MapsId("paymentsId")   //mapsId ma tat yin payments_id di tine win twr tot name tu loh ma ya
	@JoinColumn(insertable = false,updatable = false)
	@ManyToOne
	private Payments payments;
	
	@Column(nullable = false,length = 45)
	private String startPoint;
	
	@Column(nullable = false,length = 45)
	private String endPoint;
	
	@Embedded
	private Times times;
	
}
