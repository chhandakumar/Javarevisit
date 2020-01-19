package EmployeeDetails;


import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;;


/**
 * @author Chhanda.karuppanan
 * Below class gets employee's input and calculate their
 * expected salary and performance based on their rating
 */
public class GatherEmployeeDetails{
	
	private static final Logger LOGGER = Logger.getLogger(GatherEmployeeDetails.class.getName());
	public static void main(String args[]) {
		
		int numberofEmp = 0;
		Scanner scanner = new Scanner(System.in);
		try {
			System.out.println("Enter the total number of employee's :");
			EmployeeDetails ei = new EmployeeDetails();
			numberofEmp = ei.checkIntInput(scanner);			
			for (int empNumber = 1; empNumber <= numberofEmp; empNumber++) {			
				ei.retreiveEmployeeDetails(numberofEmp,scanner,empNumber);
			}
			ei.printEmployeeDetails();
			scanner.close();				
		}
		
		catch(Exception e) {
			LOGGER.log(Level.INFO, " Exception occurred in ", e.getStackTrace());			
		}
		
	}
}
