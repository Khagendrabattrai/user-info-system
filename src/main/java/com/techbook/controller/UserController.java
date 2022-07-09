package com.techbook.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.techbook.domain.User;
import com.techbook.service.UserService;
import com.techbook.service.UserServiceImpl;

public class UserController { // constructor
	private UserService userService;

	public UserController() {
		userService = new UserServiceImpl();
	}

	public int saveUserInfo(Scanner input) {

		User user = buildUserInfo(input, "save");

		return userService.saveUserInfo(user);
	}

	public int updateUserInfo(Scanner input) {

		User user = buildUserInfo(input, "update");

		return userService.updateUserInfo(user);

	}

	public int deleteUserInfo(Scanner input) {
		System.out.println("Enter id for delete :");
		int id = input.nextInt();
		return userService.deleteUserInfo(id);
	}

	public void getAllUserInfo() {
		List<User> userList = userService.getAllUserInfo();
		for (User user : userList) {
			System.out.println("========================");
			System.out.println("Id " + user.getId());
			System.out.println("username is " + user.getUserName());
			System.out.println("pssword is " + user.getPassword());
			System.out.println("Email is " + user.getEmail());
			System.out.println("Mobile number is: " + user.getMobileNmuber());
			System.out.println("Dob is: " + user.getDob());
			System.out.println("+++++++++++++++++++++++++");
		}

	}

	private User buildUserInfo(Scanner input, String opt) {
		User user = new User();
		if (opt.equalsIgnoreCase("update")) {
			System.out.println("Enter id:");
			int id = input.nextInt();
			user.setId(id);
		}

		System.out.println("Enter username:");
		String username = input.next();
		System.out.println("Enter password:");
		String password = input.next();
		System.out.println("Enter email:");
		String email = input.next();
		System.out.println("Enter mobile no:");
		long mobileNo = input.nextLong();// here we take long coz hamilae SQL ma mobile number Big int rakhya xa
		System.out.println("Enter dob:");
		// Date dob =input .next();// yaha date lina ko lagi nextDate vannae xaina tehai
		// vayaera string...
		// nai linu parxa
		// but date has to be converted like on the below step
		String dob = input.next();
		Date dateOfBirth = parseDate(dob);

		user.setUserName(username);
		user.setPassword(password);
		user.setEmail(email);
		user.setMobileNmuber(mobileNo);
		user.setDob(dateOfBirth);

		return user;
	}

	// To covert into date
	private /* public */ Date parseDate(String dob) { // class vitra matra use hune method lai private banaune

		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date dateOfBirth = (Date) sdf.parse(dob);
			return dateOfBirth;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
}
