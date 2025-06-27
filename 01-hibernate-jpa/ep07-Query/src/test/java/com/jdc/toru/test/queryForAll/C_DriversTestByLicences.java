package com.jdc.toru.test.queryForAll;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Driver;
import java.time.LocalDate;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import com.jdc.toru.entity.Drivers;
import com.jdc.toru.test.A_JpaFactory;

public class C_DriversTestByLicences extends A_JpaFactory{
	
	@Order(1)
	@ParameterizedTest
	@CsvSource({
		"2011-10-12,2013-05-21,4"
	})
	void useNativeSearchByValidDate(LocalDate from,LocalDate to,int result) {
		var query = em.createNativeQuery("""
				select * from drivers_tbl d 
				join licences_tbl l on d.licences_id = l.id
				where l.validDate between :fromDt and :toDt
				""");
		query.setParameter("fromDt", from);
		query.setParameter("toDt", to);

		var list = query.getResultList();
		assertEquals(result, list.size());
	}
	
	@Order(2)
	@ParameterizedTest
	@CsvSource({
		"2011-01-01,2013-01-01,3"
	})
	void useJpqlSearchByValidDate(LocalDate from,LocalDate to,int result) {
		var query = em.createQuery("""
				select d from Drivers d 
				where d.licences.validDate between :fromDt and :toDt
				""");
		query.setParameter("fromDt", from);
		query.setParameter("toDt", to);

		var list = query.getResultList();
		assertEquals(result, list.size());
	}
	
	@Order(3)
	@ParameterizedTest
	@CsvSource({
		"2011-01-01,2013-01-01,3"
	})
	void useCriteriaSearchByValidDate(LocalDate from,LocalDate to,int result) {
		var cb = em.getCriteriaBuilder();
		var cq = cb.createQuery(Drivers.class);
		var root = cq.from(Drivers.class);
		cq.select(root);
		
		cq.where(cb.between(root.get("licences").get("validDate"),from,to)); 
		
		var query = em.createQuery(cq);
		var list = query.getResultList();
		assertEquals(result, list.size());
	}
}
