package EmployeeDetails;

import java.util.InputMismatchException;
import java.util.Scanner;


/**
 * @author Chhanda.karuppanan
 * Below class gets employee's input and calculate their
 * expected salary and performance based on their rating
 */
public class GatherEmployeeDetails extends Exception{
		
	public static void main(String args[]) {
		
		int numberofEmp = 0;
		Scanner s = new Scanner(System.in);
		try {
			System.out.println("Enter the total number of employee's :");
			EmployeeDetails ei = new EmployeeDetails();
			numberofEmp = ei.checkIntInput(s);			
			for (int i = 1; i <= numberofEmp; i++) {
				ei.getEmployeeDetails(i, s);
			}
			ei.printEmployeeDetails();
			s.close();			
		}
		catch(InputMismatchException e) {
			System.out.println("Entered input is invalid please try again");	
			return;
		}
		catch(Exception e) {
			System.out.println("Please address this issue"+e.getMessage());	
			return;
		}
		
	}
}
