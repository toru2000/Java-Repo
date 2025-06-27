package com.jdc.toru.entity;

import com.jdc.toru.listeners.EnableTimesListener;
import com.jdc.toru.listeners.Times;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.NamedNativeQuery;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.persistence.TableGenerator;
import lombok.Data;

@Data
@Entity
@Table(name = "passengers_tbl")
@NamedQueries({
    @NamedQuery(
        name = "Passengers.selectAllPassengers",
        query = "SELECT p FROM Passengers p"
    ),
    @NamedQuery(
        name = "Passengers.selectAllPassengersByNameLike",
        query = "SELECT p FROM Passengers p WHERE LOWER(p.name) LIKE LOWER(:name)"
    )
})
@NamedNativeQuery(name="Passengers.selectAllPassengersByNameEqual",
 					query = "select * from passengers_tbl where lower(name)=lower(:name)",
 					resultClass = Passengers.class)
public class Passengers implements EnableTimesListener{
	
	@Id
	@GeneratedValue(generator = "table_gen_passenger_tbl")
	@TableGenerator(name = "table_gen_passenger_tbl",initialValue = 5,allocationSize = 1)
	private int id;
	
	@Column(nullable = false,length = 45)
	private String name;
	
	@Embedded
	private Contact contact;
	
	@Embedded
	private Times times;
}
