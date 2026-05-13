package com.rays.test;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

import com.rays.user.MarksheetDTO;

public class TestDeleteMarksheet {

	public static void main(String[] args) {

		SessionFactory sf = new Configuration().configure().buildSessionFactory();

		Session session = sf.openSession();

		MarksheetDTO dto = new MarksheetDTO();

		dto.setId(6);
		

		Transaction tx = session.beginTransaction();

		session.delete(dto); // for updating the row
		tx.commit();
	}
}
