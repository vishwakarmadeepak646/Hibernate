package com.rays.user;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Restrictions;
import java.util.List;

public class UserModel {

	public int add(UserDTO dto) {

		SessionFactory sf = new Configuration().configure().buildSessionFactory();

		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();

		session.save(dto);

		tx.commit();

		return dto.getId();

	}

	public void update(UserDTO dto) {

		SessionFactory sf = new Configuration().configure().buildSessionFactory();

		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();

		session.update(dto);
		tx.commit();
		System.out.println("Record updated successfully");

	}

	public void delete(UserDTO dto) {

		SessionFactory sf = new Configuration().configure().buildSessionFactory();

		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();

		session.delete(dto);

		tx.commit();
		System.out.println("Record deleted successfully");

	}

	public UserDTO FindByPK(int id) {

		SessionFactory sf = new Configuration().configure().buildSessionFactory();

		Session session = sf.openSession();

		UserDTO dto = (UserDTO) session.get(UserDTO.class, id);

		return dto;
	}

	public UserDTO FindByLogin(String login) {

		UserDTO dto = null;

		SessionFactory sf = new Configuration().configure().buildSessionFactory();

		Session session = sf.openSession();

		// select * from UserDTO where 1 = 1;
		Criteria criteria = session.createCriteria(UserDTO.class);

		// select * from UserDTO where 1 = 1 and where loginId = ?;
		criteria.add(Restrictions.eq("loginId", login));

		List<UserDTO> list = criteria.list();

		if (list.size() == 1) {
			dto = new UserDTO();
			dto = list.get(0);
		}

		return dto;
	}

	public UserDTO authentication(String login, String password) {

		UserDTO dto = null;

		SessionFactory sf = new Configuration().configure().buildSessionFactory();

		Session session = sf.openSession();

		// select * from UserDTO where 1 = 1;
		Criteria criteria = session.createCriteria(UserDTO.class);

		// select * from UserDTO where 1 = 1 and where loginId = ?;
		criteria.add(Restrictions.eq("loginId", login));
		criteria.add(Restrictions.eq("password", password));

		List<UserDTO> list = criteria.list();

		if (list.size() == 1) {
			dto = new UserDTO();
			dto = list.get(0);
		}

		return dto;
	}
	
	public List<UserDTO> search(UserDTO dto) {

		SessionFactory sf = new Configuration().configure().buildSessionFactory();

		Session session = sf.openSession();

		// select * from UserDTO where 1 = 1;
		Criteria criteria = session.createCriteria(UserDTO.class);

		// select * from UserDTO where 1 = 1 and where loginId = ?;
		criteria.add(Restrictions.eq("loginId", dto.getLoginId()));
		criteria.add(Restrictions.eq("id", dto.getId()));

		List<UserDTO> list = criteria.list();

		if (list.size() == 1) {
			dto = new UserDTO();
			dto = list.get(0);
		}

		return list;
	}

}
