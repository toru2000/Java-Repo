package com.jdc.toru.test.criteriaQuery;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import com.jdc.toru.entity.Passengers;
import com.jdc.toru.test.A_JpaFactory;

public class A_QueryTest extends A_JpaFactory{
	
	@Test
	@Order(2)
	void searchTotalPassengersTest() {
		var cb = em.getCriteriaBuilder();
		
		var cq = cb.createQuery(Long.class);
		var root = cq.from(Passengers.class);
		
		cq.select(cb.count(root)); //select count from root= passenger
		
		var query = em.createQuery(cq);
		System.out.println("Count : "+query.getSingleResult());
	}
		
	@Test
	@Order(1)
	void searchByNameLike() {
		//select p from Passengers p where name like :name
		var cb = em.getCriteriaBuilder();
		var cq = cb.createQuery(Passengers.class); //passenger lo chin loh
		
		// from p
		var root =   cq.from(Passengers.class);      //select lote ya mae har
		
		//select p from Passengers p
		cq.select(root);
		
		//where              name              // like :name
		cq.where(cb.like(root.get("name"), "a".toLowerCase().concat("%"))); //"name" = field name
		//cq.where(cb.like(root.get(Passenger_.class), "a".toLowerCase().concat("%"))); //singular attribute pone san
		
		var query = em.createQuery(cq);
		show(query.getResultList());	
	}
}
