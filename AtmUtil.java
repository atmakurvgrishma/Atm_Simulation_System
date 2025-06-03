package com.ATM;
import java.util.Scanner;

public class AtmUtil {
    private static final int minBal=500;
    private static int currentBalance = minBal;
    
    public static void deposit(Scanner sc) {
    	
    	System.out.println("Enter the amount to be deposited : ");
    	int depositedAmount = sc.nextInt();
    	if(depositedAmount > 0) {
       currentBalance = balanceEnquiry() + depositedAmount;
    	}
       if(currentBalance==minBal) {
    	   System.out.println("Something went wrong");
    	   return;
       }
       System.out.println("Amount of Rs. " + depositedAmount +" is credited to your account" );
    }
    public static void withDraw(Scanner sc) {
    	System.out.println("Enter the Amount to be Withdrawn : ");
    	int withDrawnAmount = sc.nextInt();
    	if((balanceEnquiry()-minBal)>= withDrawnAmount){
    		currentBalance = balanceEnquiry() - withDrawnAmount;
    		System.out.println("Amount Rs, " + withDrawnAmount + " is debited from the account");
    		return;
    	}
    	System.out.println("Insufficient Balance as we need to maintain minimum amount of Rs." + minBal);
    	
    }
    public static int balanceEnquiry() {
    	return currentBalance;
    }
   
}
