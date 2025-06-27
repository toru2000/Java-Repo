
package com.jdc.toru.test.queryForAll;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import com.jdc.toru.entity.Drivers;
import com.jdc.toru.test.A_JpaFactory;

public class B_DriverTestByAddress extends A_JpaFactory{
	

	@Order(1)
	@ParameterizedTest
	@CsvSource({
		"Mandalay,3",
		"Yankin,1"
	})
	void useNativeSearchByAddress(String name,int result) { //name -> state or township
		var query = em.createNativeQuery("""
				select * from drivers_tbl d 
				join addresses_tbl a on  d.addresses_id = a.id  
				where a.state = :name or
				a.township = :name
				""");
		query.setParameter("name", name);
		var list = query.getResultList();
		assertEquals(result, list.size());
	}
	
	@Order(2)
	@ParameterizedTest
	@CsvSource({
		"Mandalay,3",
		"Yankin,1"
	})
	void useJpqlSearchByAddress(String name,int result) { //one ne sone tr so join sayar ma loh direct call ya
		var query = em.createQuery("""
				select d from Drivers d 
				where d.addresses.state = :name or
				d.addresses.township = :name
				""",Drivers.class);
		
		query.setParameter("name", name);
		
		var list = query.getResultList();
		assertEquals(result, list.size());
	}
	
	@Order(3)
	@ParameterizedTest
	@CsvSource({
		"Mandalay,3",
		"Yankin,1"
	})
	void useCriteriaSearchByAddress(String name,int result) {
		var cb = em.getCriteriaBuilder();
		var cq = cb.createQuery(Drivers.class);
		
		var root = cq.from(Drivers.class);
		cq.select(root);
		
		//d.addresses.state = :name
		var pState = cb.equal(root.get("addresses").get("state"),name);
		//d.addresses.township = :name
		var pTownship = cb.equal(root.get("addresses").get("township"), name);
		
		cq.where(cb.or(pState,pTownship));
		var query = em.createQuery(cq);
		
		var list = query.getResultList();
		assertEquals(result, list.size());
	}
}
