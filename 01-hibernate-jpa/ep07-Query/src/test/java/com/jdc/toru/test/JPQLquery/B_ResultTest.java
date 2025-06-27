package com.jdc.toru.test.JPQLquery;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import com.jdc.toru.entity.Passengers;
import com.jdc.toru.test.A_JpaFactory;

public class B_ResultTest extends A_JpaFactory{
	
	
	
	@Test
	@Order(3)
	void resultStreamWithNameParamTest() { //select * from passenger_tbl where lower(name) like lower('a%')
		//var query = em.createQuery("select p from Passengers p where lower(name) like lower(:name)",Passengers.class);
		var query = em.createNamedQuery("Passengers.selectAllPassengersByNameLike",Passengers.class);
		
		query.setParameter("name", "w".concat("%"));  //a = ?
		show(query.getResultList());
	}
	
	
	@Test
	@Order(2)
	void resultListWithIndexTest() { //select * from passenger_tbl where lower(name) like lower('a%')
		var query = em.createQuery("select p from Passengers p where lower(name) like lower(?1)",Passengers.class);
		
		query.setParameter(1, "a".concat("%"));  //a = ?
		show(query.getResultStream().toList());
	}
	
	@Test
	@Order(1)
	void singleResult() {
		var query = em.createQuery("select count(p) from Passengers p",Long.class);
		var result = query.getSingleResult();
		System.out.println("count : "+result);
	}
}
