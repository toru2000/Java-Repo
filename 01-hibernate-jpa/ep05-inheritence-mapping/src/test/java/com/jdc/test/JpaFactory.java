package com.jdc.test;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.TestMethodOrder;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

@TestMethodOrder(OrderAnnotation.class)
public class JpaFactory {
	static EntityManagerFactory emf;  //ka test tine twt shi nay thint thu shi mha entity sout loh ya
	EntityManager em;
	
	@BeforeAll
	static void init() {
		emf = Persistence.createEntityManagerFactory("inheritence-mapping");
	}
	
	@AfterAll
	static void closeEmf() {
		if(null != emf && emf.isOpen()) {
			emf.close();
		}
	}
	
	@BeforeEach
	void crateEm() {
		em = emf.createEntityManager();
	}
	
	@AfterEach
	void closeEm() {
		if(null != em && em.isOpen()) {
			em.close();
		}
	}
	
}
