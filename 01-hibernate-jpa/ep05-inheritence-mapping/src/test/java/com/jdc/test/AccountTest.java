package com.jdc.test;

import java.awt.Color;
import java.time.LocalDate;
import java.time.LocalTime;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import com.jdc.toru.entity.Customer;
import com.jdc.toru.entity.Customer.MemberType;
import com.jdc.toru.entity.Department;
import com.jdc.toru.entity.Employee;

public class AccountTest extends JpaFactory{
	
	@Test
	@Order(1)
	void departmentTest() {
		Department dep = new Department();
		dep.setName("Service Team");
		dep.setColor(Color.DARK_GRAY);
		
		em.getTransaction().begin();
		em.persist(dep);
		em.getTransaction().commit();
	}
	
	@Test
	@Order(2)
	void employeeTest(){
		Employee emp = new Employee();
		emp.setCreateDateAt(LocalDate.now());
		emp.setCreateTimeAt(LocalTime.now());
		emp.setDepartment(new Department(1));
		emp.setEmail("andrew@gmail.com");
		emp.setUsername("andrew");
		emp.setPassword("222");
		emp.setValue("34");
		
		em.getTransaction().begin();
		em.persist(emp);
		em.getTransaction().commit();
	}
	
	@Test
	@Order(3)
	void customerTest() {
		
		Customer c = new Customer(MemberType.GOLD);
		c.setCreateDateAt(LocalDate.now());
		c.setCreateTimeAt(LocalTime.now());
		c.setEmail("aungaung@gmail.com");
		c.setUsername("aungaung");
		c.setPassword("123");
		c.setValue("21");
		
		em.getTransaction().begin();
		em.persist(c);   //database hte tr -> customer ko account hte thein
		em.getTransaction().commit();
	}
}	
