package com.jdc.toru.entity;

import java.util.List;

import com.jdc.toru.listeners.EnableTimesListener;
import com.jdc.toru.listeners.Times;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.TableGenerator;
import lombok.Data;

@Data
@Entity
@Table(name = "drivers_tbl")
public class Drivers implements EnableTimesListener{
	
	@Id
	@GeneratedValue(generator = "table_gen_drivers_tbl")
	@TableGenerator(name = "table_gen_drivers_tbl",initialValue = 1,allocationSize = 1)
	private int id;
	
	@Column(nullable = false,length = 45)
	private String name;
	
	@Enumerated(EnumType.STRING)
	private Gender gender;
	
	@Embedded
	private Contact contact;
	
	@Embedded              
	private Times times;  //interface implement htr pay mae embedded kyout override ma lo
	
	@OneToOne(fetch = FetchType.LAZY,optional = true) //driver sout tae time mhr address ma pr lae ya optional = false
	private Addresses addresses;
	
	@OneToOne(fetch = FetchType.LAZY,cascade = {
			CascadeType.PERSIST,   //Parent entity ကို save (persist) လုပ်တဲ့အခါမှာ၊ ပတ်သက်တဲ့ child entity ကိုပါ အလိုအလျောက် save လုပ်ပေး
			CascadeType.MERGE     //for update
	})
	private Licences licences;
	
	@OneToMany(mappedBy = "drivers") 
	private List<Trips> trips;
	
	public enum Gender{
		MALE,FEMALE,OTHER
	}
}
