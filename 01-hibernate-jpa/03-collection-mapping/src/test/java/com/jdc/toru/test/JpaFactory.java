package com.jdc.toru.test;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JpaFactory {
	static EntityManagerFactory emf;
	
	@BeforeAll
	static void create() {
		emf = Persistence.createEntityManagerFactory("collection-mapping");
	}
	
	@Test
	void test() {
		
	}
}
