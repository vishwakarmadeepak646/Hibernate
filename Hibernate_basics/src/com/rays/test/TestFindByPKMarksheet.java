package com.rays.test;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

import com.rays.user.MarksheetDTO;

public class TestFindByPKMarksheet {

	public static void main(String[] args) {

		SessionFactory sf = new Configuration().configure().buildSessionFactory();

		Session session = sf.openSession();

		MarksheetDTO dto = (MarksheetDTO) session.get(MarksheetDTO.class, 4);

	
		if (dto != null) {

			System.out.println("Record Found");
			System.out.println("---------------------");

			System.out.println("ID : " + dto.getId());
			System.out.println("Name : " + dto.getName());
			System.out.println("Roll No : " + dto.getRollNo());
			System.out.println("Physics : " + dto.getPhysics());
			System.out.println("Chemistry : " + dto.getChemistry());
			System.out.println("Maths : " + dto.getMaths());

		} else {

			System.out.println("Record not found");

		}

		session.close();
		sf.close();
	}

}
