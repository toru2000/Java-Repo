package com.jdc.test;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JpaFactory {
	static EntityManagerFactory emf;
	
	@BeforeAll
	static void before() {
		emf = Persistence.createEntityManagerFactory("relationship-mapping");
	}
	
	@Test
	void Test() {
		
	}

}
