package com.rays.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import com.rays.user.UserDTO;
import com.rays.user.UserModel;

public class TestUser {

	public static void main(String[] args) throws ParseException {
		// getAdd();
		// getUpdate();
		// getDelete();
		// FindByPk();
		// FindByLogin();
		authentication();
	}

	public static void getAdd() throws ParseException {

		SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");

		UserModel model = new UserModel();
		UserDTO dto = new UserDTO();

		dto.setFirstName("Barkha");
		dto.setLastName("Thakur");
		dto.setLoginId("barkha@gmail.com");
		dto.setPassword("Barkh@123");
		dto.setDob(s.parse("1996-04-14"));
		dto.setAddress("Indore");

		int i = model.add(dto);
		System.out.println(i + " id is inserted in DB");
	}

	public static void getUpdate() throws ParseException {
		SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
		UserModel model = new UserModel();
		UserDTO dto = new UserDTO();

		dto.setFirstName("Rekha");
		dto.setLastName("Thakur");
		dto.setLoginId("Rekha@gmail.com");
		dto.setPassword("Rekha@123");
		dto.setDob(s.parse("1996-01-14"));
		dto.setAddress("Indore");
		dto.setId(3);

		model.update(dto);

	}

	public static void FindByPk() {

		UserModel model = new UserModel();
		UserDTO dto = new UserDTO();

		dto = model.FindByPK(2);

		if (dto != null) {
			System.out.println(dto.getId());
			System.out.println(dto.getFirstName());
			System.out.println(dto.getLastName());
			System.out.println(dto.getLoginId());
			System.out.println(dto.getPassword());
			System.out.println(dto.getDob());
			System.out.println(dto.getAddress());
			System.out.println("-----------------");
		}
	}

	public static void FindByLogin() {

		UserModel model = new UserModel();

		UserDTO dto = model.FindByLogin("barkha@gmail.com");

		if (dto != null) {
			System.out.println(dto.getId());
			System.out.println(dto.getFirstName());
			System.out.println(dto.getLastName());
			System.out.println(dto.getLoginId());
			System.out.println(dto.getPassword());
			System.out.println(dto.getDob());
			System.out.println(dto.getAddress());
			System.out.println("-----------------");
		}
	}

	public static void authentication() {

		UserModel model = new UserModel();

		UserDTO dto = model.authentication("barkha@gmail.com", "Barkh@123");

		if (dto != null) {
			System.out.println(dto.getId());
			System.out.println(dto.getFirstName());
			System.out.println(dto.getLastName());
			System.out.println(dto.getLoginId());
			System.out.println(dto.getPassword());
			System.out.println(dto.getDob());
			System.out.println(dto.getAddress());
			System.out.println("-----------------");
		} else {
			System.out.println("No record found");
		}
	}

}
