package com.jdc.toru.test;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import com.jdc.toru.entity.Member;
import com.jdc.toru.entity.Product;
import com.jdc.toru.listener.Times;

public class D_CallbackTest extends JpaFactory{
	
	@Test
	//@Disabled
	void persistProductTest() {
		var product = new Product("Lemon",500.00);
		em.getTransaction().begin();
		em.persist(product);
		product.setPrice(200.00);
		em.getTransaction().commit();
	}
	
	@Test
	//@Disabled
	void persistTest() {
		var member = new Member("William","aaA2ffff");
		
//		var times = new Times();    if i dont use listener class , i must write every class like this
//		member.setTimes(times);
//		times.setCreateTime(LocalDateTime.now());
		
		em.getTransaction().begin();
		em.persist(member);
		member.setUserName("John");  //merge ma call lae setter change yone ne update query htwt 
		em.getTransaction().commit();
	}
}
