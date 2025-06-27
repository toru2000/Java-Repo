package com.jdc.toru.test.nativeQuery;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import com.jdc.toru.entity.Passengers;
import com.jdc.toru.test.A_JpaFactory;

public class A_StaticVsDynamicQuery extends A_JpaFactory{
	
	@Test
	@Disabled
	@Order(2)
	void staticQueryTest() { 
		var query = em.createNamedQuery("Passengers.selectAllPassengersByNameEqual",Passengers.class);
		query.setParameter("name", "andrew");
		var list = query.getResultList();
		show(list);
	}
	
	@Test
	@Disabled
	@Order(1)
	void dynamicQueryTest() { 
		var query = em.createNativeQuery("select * from passengers_tbl where createAt is Null",Passengers.class);
		var list = query.getResultList();
		show(list);
	}
}
