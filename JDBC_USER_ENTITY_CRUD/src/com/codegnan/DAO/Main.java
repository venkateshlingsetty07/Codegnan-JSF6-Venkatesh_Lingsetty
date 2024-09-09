package com.codegnan.DAO;

import java.util.List;
import java.util.Scanner;

 
import com.codegnan.entity.User;

public class Main {
	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/adjava";
		String username = "root";
		String password = "root";

		Scanner scanner = new Scanner(System.in);
		UserDAO userDAO = new JDBCUserDAO(url, username, password);

		while (true) {
			System.out.println("Choose operation:");
			System.out.println("1. Add User");
			System.out.println("2. View User by ID");
			System.out.println("3. View All Users");
			System.out.println("4. Update User");
			System.out.println("5. Delete User");
			System.out.println("6. Exit");
			int choice = scanner.nextInt();

			switch (choice) {
			case 1:
				addUser(userDAO);
				break;
			case 2:
				viewUserById(userDAO);
				break;
			case 3:
				viewAllUsers(userDAO);
				break;
			case 4:
				updateUser(userDAO);
				break;
			case 5:
				deleteUser(userDAO);
				break;
			case 6:
				scanner.close();
				return;
			default:
				System.out.println("Invalid choice!");
			}
		}
	}

	private static void addUser(UserDAO userDAO) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter name:");
		String name = scanner.nextLine();
		System.out.println("Enter email:");
		String email = scanner.nextLine();
		User user = new User();
		user.setName(name);
		user.setEmail(email);
		userDAO.addUser(user);
		System.out.println("User added successfully!");
	}
	private static void viewUserById(UserDAO userDAO) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter user ID:");
		int id = scanner.nextInt();
		User user = userDAO.getUserById(id);
		if (user != null) {
			System.out.println("User found:");
			System.out.println("ID: " + user.getId());
			System.out.println("Name: " + user.getName());
			System.out.println("Email: " + user.getEmail());
		} else {
			System.out.println("User not found!");
		}
	}

	private static void viewAllUsers(UserDAO userDAO) {
		List<User> users = userDAO.getAllUsers();
		System.out.println("All users:");
		for (User user : users) {
			System.out.println("ID: " + user.getId() + ", Name: " + user.getName() + ", Email: " + user.getEmail());
		}
	}

	private static void updateUser(UserDAO userDAO) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter user ID:");
		int id = scanner.nextInt();
		User existingUser = userDAO.getUserById(id);
		if (existingUser != null) {
			System.out.println("Enter new name:");
			String name = scanner.next();
			System.out.println("Enter new email:");
			String email = scanner.next();
			existingUser.setName(name);
			existingUser.setEmail(email);
			userDAO.updateUser(existingUser);
			System.out.println("User updated successfully!");
		} else {
			System.out.println("User not found!");
		}
	}

	private static void deleteUser(UserDAO userDAO) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter user ID:");
		int id = scanner.nextInt();
		User existingUser = userDAO.getUserById(id);
		if (existingUser != null) {
			userDAO.deleteUser(id);
			System.out.println("User deleted successfully!");
		} else {
			System.out.println("User not found!");
		}
	}
}
