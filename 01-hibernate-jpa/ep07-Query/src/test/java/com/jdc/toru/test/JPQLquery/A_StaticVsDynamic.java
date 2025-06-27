package com.jdc.toru.test.JPQLquery;

import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import com.jdc.toru.entity.Passengers;
import com.jdc.toru.test.A_JpaFactory;

public class A_StaticVsDynamic extends A_JpaFactory{
	
	@Test
	@Disabled
	void dynamicQueryTest() {
		//shi ta mya a kone htote chin yin
		//var query = em.createQuery("select * from passengers_tbl");  //sql query
		var query = em.createQuery("select p from Passengers p",Passengers.class);   //JPQL query
		List<Passengers> list = query.getResultList();
		show(list);
	}
	
	
	@Test
	void staticQueryTest() {
		//find getrefernce so entity ta ku pe ya
		var query = em.createNamedQuery("Passengers.selectAllPassengers",Passengers.class);
		List<Passengers> list = query.getResultList();
		show(list);
	}
}

