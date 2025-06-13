package com.jdc.toru.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AboutJunitTest {
	
	@Test
	void testOne() {
		System.out.println("Test method one");
		assertEquals("A","A");
		assertNotNull(null);
	}
	@Test
	void testTwo() {
		System.out.println("Test method two");
	}
	
	@BeforeAll
	static void beforeAll() {
		System.out.println("Before All method");
	}
	
	@AfterAll
	static void afterAll() {
		System.out.println("After All method");
	}
	
	@BeforeEach
	void beforeEach() {
		System.out.println("Before Each method");
	}
	
	@AfterEach
	void afterEach() {
		System.out.println("After Each method");
	}
	
	
}
