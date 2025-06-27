package com.jdc.toru.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import com.jdc.toru.entity.Category;
import com.jdc.toru.entity.Product;

import jakarta.persistence.EntityNotFoundException;

public class A_PersistDetachedFindTest extends JpaFactory{
	
	@Test
	@Disabled
	void categoryPersistTestWithCascadeOperation() {
		var cat = new Category("Meat");
		
//		var p1 = new Product("Beef",15000.00); //addProduct() thone
//		cat.getProducts().add(p1);
//		p1.setCategory(cat);
		
//		cat.addProduct(new Product("Beef",15000.00),
//				new Product("Chicken",20000.00));
		
		em.getTransaction().begin();
		em.persist(cat);     //
		em.getTransaction().commit();
	}
	
	@Order(3)
	@Disabled
	@Test
	void productdetachedTest() {
		//to be Manage state
		var product = em.find(Product.class, 1); 
		assertTrue(em.contains(product));
		
		//to be detached
		em.detach(product);
		assertFalse(em.contains(product));
		product.setName("Durain"); 
		
		em.getTransaction().begin();
		//To be manage
		var newProduct = em.merge(product);  //another entity manage state yout
		assertFalse(em.contains(product));
		assertTrue(em.contains(newProduct));
		em.getTransaction().commit();
		
	}
	
	@Order(2)
	@Disabled
	@ParameterizedTest  //parameter hte san chin loh
	@CsvSource(value = {
			"2:Apple"
			},delimiter = ':')   //id = 1 , nameResult = apple //parameter hte hte mae 2 ku
	void productFindVsGetReferenceTest(int id , String nameResult) {
		var pFind = em.find(Product.class, id); //manage state 
//		assertFalse(em.contains(pFind));
		//assertEquals(nameResult, product.getName()); -> for id =1 Apple
		
		em.close();
//		assertNotNull(pFind.getName());
		//assertThrows(NullPointerException.class, ()-> pFind.getName());
		
		
//		Product pRef = em.getReference(Product.class, id);  //shar ma twae yin tg proxy obj pyan 
//		em.close();
//		assertNotNull(pRef.getName());
		//assertThrows(EntityNotFoundException.class,()-> pRef.getCategory() );
	}
	
	
	@Order(1)
	@Disabled
	@Test
	void productTest() {
		//to be Transient state or new state
		var cat = new Category("Test");
		var product = new Product("test",120.00);
//		product.setCategory(cat);        -> before cascade
//		cat.getProducts().add(product);
		
		product.addCategory(cat); //after cascade
		
		assertFalse(em.contains(cat));  //persistence context hte yout yin -> em.contains(cat) -> true pyan
		
		em.getTransaction().begin();
		//to be Manage state
		//em.persist(cat);   //na ko obj ko persist lote yin manage state yout /thu ka persistence context hte thein
		em.persist(product); //commit ma lote ya thay tot db hte ma win thay
		//product.setName("Apple"); //transition hte moh ya
		em.getTransaction().commit();
		
		//assertTrue(em.contains(cat)); //commit lote pee tr tg persistence context hte kyan nay thay tot setter nae update ya
		//product.setName("Apple"); //transition a pyin bat moh db hte ma win -> update mal so transition hte hte // transition a pyin mhr moh update query htwt pay mal db hte ma win
		
	}
}
