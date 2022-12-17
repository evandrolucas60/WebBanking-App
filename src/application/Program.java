package application;

import java.util.Scanner;

import model.entities.Account;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("==================================");
		System.out.println("Welcome to the Web-Banking");
		System.out.println("==================================");
		System.out.println();
		
		System.out.print("Please, Enter with your name: ");
		String customerName = sc.nextLine();
		System.out.print("Please, Enter with your ID: ");
		String customerID = sc.nextLine();
		System.out.println();
		
		Account account = new Account(customerName, customerID);
		account.showMenu();
		
		
		sc.close();
	}

}
