package com.jdc.toru.listener;

import java.time.LocalDateTime;

import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

//callBack method twy su yay htr tae class
public class TimesListener { //create lote tae time ne update lote tae time ko mhat chin tr
	
	@PrePersist
	void createEntity(Object obj) { //member so member ya mhr moh
		if(obj instanceof EnableTimesEntity entity) { 
			Times time = entity.getTimes();   //-> shi ta mya entity twt
			if(null == time) {
				time = new Times();   
				entity.setTimes(time);
			}
			time.setCreateTime(LocalDateTime.now());
		}
	}
	
	@PreUpdate
	void updateEntity(Object obj) {
		if(obj instanceof EnableTimesEntity entity) {
			Times time = entity.getTimes();
			if(null == time) {
				time = new Times();
				entity.setTimes(time);
			}
			time.setUpdateTime(LocalDateTime.now());
		}
	}
}
