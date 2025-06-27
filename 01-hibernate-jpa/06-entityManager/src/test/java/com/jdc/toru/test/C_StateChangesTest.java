package com.jdc.toru.test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import com.jdc.toru.entity.Category;
import com.jdc.toru.entity.Product;

import jakarta.persistence.PersistenceException;

public class C_StateChangesTest extends JpaFactory{
	
	@Test
	@Disabled
	void persistTest() {   //import.sql tot a mye pr
		
		//To be manage state
		var product = em.find(Product.class, 1);
		assertTrue(em.contains(product));
		
		//To be remove
		em.remove(product);
		assertFalse(em.contains(product));
		
		//To be persist
		em.persist(product);
		assertTrue(em.contains(product));
		
		//To be detached
		em.detach(product);
		assertFalse(em.contains(product));
		
		assertThrows(PersistenceException.class, () -> em.persist(product));
	}
	
	@Test
	@Disabled
	void mergeTest() {
		
		var category = new Category("Meat");  //category ko persist yin helper method lo
		//To be transient 
		var product = new Product("pork",20000.00); //product ko thein yin cate pr thein chin yin cascade lo
		product.setCategory(category);
		
		em.getTransaction().begin();
		//em.persist(product);     cascade mhr persist moh persist pe ya
		//to be merge
		var p1 = em.merge(product);      //product yae cascade mhr merge pr lo lr
		assertTrue(em.contains(p1));
		
		
		em.getTransaction().commit();
		
		//to be detached
		//em.detach(product);   product pe detach phit
		em.clear();            //product yaw cat yaw detachl
		assertFalse(em.contains(product));
		
		//to be manage
		var p2 = em.merge(product);
		assertTrue(em.contains(p2));
		
		//to be remove
		em.remove(p2);
		assertFalse(em.contains(p2));
		assertThrows(IllegalArgumentException.class,() -> em.merge(p2));
	}
	
	@Test
	void removeTest() {
		//To be manage -> detach yout chin yin manage yout mha ya
		var product = em.find(Product.class, 1);
		assertTrue(em.contains(product));
		
		//to be detach
		em.detach(product);
		assertFalse(em.contains(product));
		
		assertThrows(IllegalArgumentException.class, () -> em.remove(product));
	}
	
}
