package com.jdc.toru.listeners;

import java.time.LocalDateTime;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

public class TimesListener {
	
	@PrePersist
	void createAt(Object obj) {
		if(obj instanceof EnableTimesListener entity) {
			Times times = entity.getTimes();
			if(null == times) {
				times = new Times();
				entity.setTimes(times);
			}
			times.setCreateAt(LocalDateTime.now());
		}
	}
	
	@PreUpdate
	void updateAt(Object obj) {
		if(obj instanceof EnableTimesListener entity) {
			Times times = entity.getTimes();
			if(null == times) {
				times = new Times();
				entity.setTimes(times);
			}
			times.setUpdateAt(LocalDateTime.now());
		}
	}
	
	
}
