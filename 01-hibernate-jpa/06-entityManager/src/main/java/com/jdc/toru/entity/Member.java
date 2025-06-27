package com.jdc.toru.entity;



import org.hibernate.annotations.Check;
import org.hibernate.annotations.DynamicInsert;

import com.jdc.toru.listener.EnableTimesEntity;
import com.jdc.toru.listener.Times;
import com.jdc.toru.listener.TimesListener;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PostPersist;
import jakarta.persistence.PostUpdate;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@Entity
@DynamicInsert   
@NoArgsConstructor   //find yal getreference yal twt
@RequiredArgsConstructor
//@EntityListeners(TimesListener.class)  //member mhr listener ko sout kyi say chin
public class Member implements EnableTimesEntity{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NonNull
	@Column(nullable = false,length = 45,unique = true)
	private String userName;
	
	@NonNull
	/*
	 * password must have
	 * at least one capital letter
	 * small letter
	 * digit
	 * character length must between  8 to 20
	 */
	@Check(constraints = "password regexp '^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9]).{8,20}$'") //String regular expression
	private String password;
	
	@Column(columnDefinition = "boolean default true")
	private boolean active;
	
	@Embedded
	private Times times;  //embeddded hte ka getTime ne EnableTimesEntity ka getTime ka tu ya mal
	
//	@PrePersist  //persist db hte insert tr
//	void prePersist() {
//		System.err.println("This is prePersist ");
//	}
//	
//	@PostPersist
//	void postPersist() {
//		System.err.println("This is postPersist");
//	}
//	
//	@PreUpdate
//	void preUpdate() {
//		System.err.println("This is preUpdate");
//	}
//	
//	@PostUpdate
//	void postUpdate() {
//		System.err.println("This is postUpdate");
//	}
	
}
