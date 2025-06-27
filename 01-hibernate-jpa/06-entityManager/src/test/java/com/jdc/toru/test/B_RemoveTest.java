package com.jdc.toru.test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.jdc.toru.entity.Category;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import com.jdc.toru.entity.Product;

public class B_RemoveTest extends JpaFactory{
	
	
	@Test
	@Disabled
	void productListRemoveTest() {
		
		em.getTransaction().begin();
		//To be manage state
		var cat =  em.find(Category.class, 1); 
		assertTrue(em.contains(cat));
		
		var list = cat.getProducts();
		list.remove(2);  
		
		em.getTransaction().commit();
	}
	
	
	@Order(2)
	//@Disabled
	@Test
	void categoryRemoveTest() {  //delete category id =1 and also delete product id where category id=1 because orphanRemoval
		//To be manage state
		var cat =  em.find(Category.class, 1); 
		assertTrue(em.contains(cat));
		
		em.getTransaction().begin();
		em.remove(cat);  
		em.getTransaction().commit();
	}
	
	@Order(1)
	@Disabled
	@Test
	void productRemoveTest() {  //only delete product id = 1 ,because we delete child(product) also cannot delete parent(category)
		//To be manage state
		var prod =  em.find(Product.class, 1); //category ka product yae fk moh delete ma ya
		assertTrue(em.contains(prod));
		
		em.getTransaction().begin();
		em.remove(prod);  //transition ote pay ya /db ka pr delte chin loh
		em.getTransaction().commit();
	}
}
