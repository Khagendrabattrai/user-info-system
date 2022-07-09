package com.techbook.test;

import java.lang.ModuleLayer.Controller;
import java.util.Scanner;

import com.techbook.controller.UserController;
import com.techbook.domain.User;

public class UserTest {
	public static void main(String[] args) {
		UserController controller = new UserController();
		Scanner input = new Scanner(System.in);
		String decision = "";

		do {

			System.out.println("Enter db operation:");
			String option = input.next();
			switch (option) {
			case "create":
				int saved = controller.saveUserInfo(input);
				if (saved >= 1) {
					System.out.println("user info is inserted sucessfully ");
				} else {
					System.out.println("oppos!!!Error DB ");
				}
				break;
			case "read":
				controller.getAllUserInfo();
				break;
			case "update":
				int update = controller.updateUserInfo(input);
				if (update >= 1) {
					System.out.println("user info is updated sucessfully ");
				} else {
					System.out.println("oppos!!!Error DB ");
				}
				break;
			case "delete":
				int deleted = controller.updateUserInfo(input);
				if (deleted >= 1) {
					System.out.println("user info is deleted sucessfully ");
				} else {
					System.out.println("oppos!!!Error DB ");
				}

			default:
				System.out.println("wromg selection");
				break;
			}
			System.out.println("do you want to continue? press Y|N ");
			decision = input.next();
		} while (decision.equalsIgnoreCase(decision));
		System.out.println("Bye Bye!!see you again.....");

	}
}