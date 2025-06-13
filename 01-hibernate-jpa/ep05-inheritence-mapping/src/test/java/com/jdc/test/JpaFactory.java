package com.jdc.test;

import org.junit.jupiter.api.Test;

import jakarta.persistence.Persistence;

public class JpaFactory {
	
	@Test
	void create() {
		var emf = Persistence.createEntityManagerFactory("inheritence-mapping");
		emf.close();
	}
}
