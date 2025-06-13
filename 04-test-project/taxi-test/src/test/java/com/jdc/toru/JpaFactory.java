package com.jdc.toru;

import org.junit.jupiter.api.Test;

import jakarta.persistence.Persistence;

public class JpaFactory {
	
	@Test
	void create() {
		var emf = Persistence.createEntityManagerFactory("taxi-test");
	}
}
