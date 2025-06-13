package com.jdc.test;

import org.junit.jupiter.api.Test;
import jakarta.persistence.Persistence;

public class JpaFactory{
	
	@Test
	void create() {
		var em = Persistence.createEntityManagerFactory("test_db");
	}

}
