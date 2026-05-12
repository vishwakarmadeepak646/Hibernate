package com.rays.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;


import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

import org.hibernate.Transaction;

import com.rays.user.UserDTO;


public class TestUserTable {
	
	public static void main(String[] args) throws ParseException {
		
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		
		Session session = sf.openSession();
		
		UserDTO dto = new UserDTO();
		
		SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
		
		
		dto.setFirstName("Kapil");;
		dto.setLastName("Vishwakarma");
		dto.setLoginId("kapil@gmail.com");
		dto.setPassword("kapil@123");
		dto.setDob(s.parse("2000-01-01"));
		dto.setAddress("Indore");
		
		Transaction tx = session.beginTransaction();

		session.save(dto);

		tx.commit();

		
		
		
	}

}
