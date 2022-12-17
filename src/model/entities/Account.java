package model.entities;

import java.util.Scanner;

public class Account {
	// Class variables
	int balance;
	int previousTransaction;
	String customerName;
	String customerID;

	// Class constructor
	public Account(String customerName, String customerID) {
		super();
		this.customerName = customerName;
		this.customerID = customerID;
	}

	/*
	 * tip: By omitting the name of the modifier in its declaration, we have the
	 * so-called default or package, which indicates that the class will be visible
	 * to any other class that is within the same package
	 */

	// Function for Deposit money
	public void deposit(int amount) {
		if (amount != 0) {
			balance += amount;
			previousTransaction = amount;
		}
	}

	// Function for Witdrawing money
	public void withdrawn(int amount) {
		if (amount != 0) {
			balance -= amount;
			previousTransaction = -amount;
		}
	}

	// Function showing the previous transaction
	public void getPreviousTransation() {
		if (previousTransaction > 0) {
			System.out.println("Deposited: " + previousTransaction);
		} else if (previousTransaction < 0) {
			System.out.println("Withdrawn: " + Math.abs(previousTransaction));
		} else {
			System.out.println("No transaction occurred");
		}
	}

	// Function calculating of current funds after a number of years
	public void calculatedInterest(int years) {
		double interestRate = .0185;
		double newBalance = (balance * interestRate * years) + balance;
		System.out.println("The current interest rate is " + (100 * interestRate) + "%");
		System.out.println("After " + years + " years, you balance will be " + newBalance);
	}

	// Function showing the main menu
	public void showMenu() {
		char option = '\0';
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome, " + customerName + "!");
		System.out.println("Your ID is: " + customerID);
		System.out.println();
		System.out.println("What would you like to do?");
		System.out.println();
		System.out.println("A. Check your balance");
		System.out.println("B. Make a deposit");
		System.out.println("C. Make a withdrawn");
		System.out.println("D. View previous transaction");
		System.out.println("E. Calculate interest");
		System.out.println("F. Exit");

		do {
			System.out.println();
			System.out.println("Enter an option: ");
			char option1 = sc.next().charAt(0);
			option = Character.toUpperCase(option1);
			System.out.println();

			switch (option) {
			// Case 'A' allows the user to check their account balance
			case 'A':
				System.out.println("==================================");
				System.out.println("Balance: " + balance);
				System.out.println("==================================");
				break;
			// Case 'B' allows the user to deposit into their account using the 'deposit'
			// function
			case 'B':
				System.out.println("Enter amount to deposit: ");
				int amount = sc.nextInt();
				deposit(amount);
				System.out.println();
				break;
			// Case 'C' allows the user to withdrawn from their account using the
			// 'withdrawn'
			// function
			case 'C':
				System.out.println("Enter amount to withdrawn: ");
				int amount2 = sc.nextInt();
				withdrawn(amount2);
				;
				System.out.println();
				break;
			// Case 'D' allows the user to view their most recent transaction using the 'getPreviouTransaction' function
			case 'D':
				System.out.println("==================================");
				getPreviousTransation();
				System.out.println("==================================");
				break;
			//Case 'E' calculates the accrued interest on the account after a number of years specified by the user using the 'calculatedInterest' function	
			case 'E':
				System.out.println("Enter how many years of accrued interest: ");
				int years = sc.nextInt();
				calculatedInterest(years);
				break;
			//Case 'F' exits the user from their account	
			case 'F':
				System.out.println("==================================");
				break;	
			//The default case let's the user know that they entered an invalid character and how to enter a valid one	
			default:
				throw new IllegalArgumentException("Unexpected value: " + option);
			}

		} while (option != 'F');
		System.out.println("Thank you for banking with us!");
		
		sc.close();
	}

}
