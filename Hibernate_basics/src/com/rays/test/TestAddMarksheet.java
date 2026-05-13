package com.rays.test;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

import com.rays.user.MarksheetDTO;

public class TestAddMarksheet {

	public static void main(String[] args) {

		SessionFactory sf = new Configuration().configure().buildSessionFactory();

		Session session = sf.openSession();

		MarksheetDTO dto = new MarksheetDTO();

		dto.setName("Kamal");
		dto.setRollNo("R101");
		dto.setPhysics(80);
		dto.setChemistry(89);
		dto.setMaths(91);

		Transaction tx = session.beginTransaction();

		session.save(dto);
		tx.commit();
	}

}
