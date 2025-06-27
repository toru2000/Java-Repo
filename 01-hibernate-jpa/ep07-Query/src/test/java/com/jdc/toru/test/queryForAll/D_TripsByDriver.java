package com.jdc.toru.test.queryForAll;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import com.jdc.toru.entity.Drivers;
import com.jdc.toru.test.A_JpaFactory;

//for oneToMany
public class D_TripsByDriver extends A_JpaFactory{
	
	@Disabled
	@Order(1)
	@ParameterizedTest
	@CsvSource({
		"AungKo,4"
	})
	void useNativeSearchByDriverName(String name,int result) {
		
	}
	
	@Disabled
	@Order(2)
	@Test
	void useJpqlSearchByTripsAt() {
		var query = em.createQuery("""
				select d from Drivers d
				join d.trips t
				where t.id.passengersId = :pId
				""",Drivers.class);
		query.setParameter("pId", 1);
		System.out.println(query.getResultList());
	}
	
	@Disabled
	@Order(3)
	@ParameterizedTest
	@CsvSource({
		""
	})
	void useCriteriaSearchByDriverName(String name,int result) {
		
	}
}
