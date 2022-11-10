package com.masai.usecase;

import java.util.Scanner;

import com.masai.dao.AdminDaoImp;
import com.masai.exception.AdminException;
import com.masai.start.UserActivity;

public class AdminUseCase {

	public static void adminLogin() {		

		Scanner sc = new Scanner(System.in);

		System.out.println("\nEnter admin details -");
		System.out.println("Enter Username: ");
		String username = sc.next();

		System.out.println("Enter Password: ");
		String password = sc.next();	
		
		
		try {
			new AdminDaoImp().loginAdmin(username, password);			
			
			System.out.println("\nWelcome! Login Successful...");
			UserActivity.adminOptions();
			

		} catch (AdminException e) {
			System.out.println(e.getMessage());			
			
			System.out.println("\nTry again...");
			UserActivity.selectUser();
		}

	}
	
	public static void adminLogout() {
		
		System.out.println("Are you sure? y/n");
		
		Scanner sc=new Scanner(System.in);
		String choice=sc.next();
		
		if(choice.equalsIgnoreCase("y")) {
			try {
				new AdminDaoImp().logoutAdmin();
			} catch (AdminException e) {				
				System.out.println(e.getMessage());
			}
			
		}else {
			
			System.out.println("\nTry again...");
			System.out.println();
			
			UserActivity.adminOptions();
		}
		
	}

}
