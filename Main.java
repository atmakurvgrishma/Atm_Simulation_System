package com.ATM;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		System.out.println("Welcome to ANG Bank");
		Scanner sc = new Scanner(System.in);
		int counter = 0;
		char resp;
		
		while(true) {
			
			System.out.println("Enter the pin : ");
			int enteredPin = sc.nextInt();
			if(enteredPin==BankServer.getKey() && validateKey(enteredPin)) {
				do {
					System.out.println("Select the optipn :");
					
					System.out.println("1. deposit 2. withDraw 3. balanceEnquiry");
					int option =sc.nextInt();
					
					switch(option) {
					
					case 1: AtmUtil.deposit(sc);
					        break;
					case 2: AtmUtil.withDraw(sc);
					        break;
					case 3:
						System.out.println(AtmUtil.balanceEnquiry());
						break;
					default : System.out.println("Invalid Option");
					
					}
					
					
					System.out.println("Do you want to continue : y/n :");
					resp=sc.next().charAt(0);
					
				}
				while(resp=='y');
				break;
			}
			else {
				++ counter;
				System.out.println("Wrong pin entered " + counter + "Times");
				if(counter==3) {
					System.out.println(" Card Blocked for 24 hrs. Contact your nearest branch. Thank you for banking with us");
					break;
				}
			}
		}
		System.out.println("Thank you for Banking with us!!");
	}

	private static boolean validateKey(int enteredPin) {
		String key = String.valueOf(enteredPin);
		if(key.length()==4) return true;
		return false;
	}

}
