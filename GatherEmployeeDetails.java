package employee;


import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;;


/**
 * @author Chhandakumar.karuppanan
 * This class retrieves employee details based on their input and prints them.
 */
public class GatherEmployeeDetails{
	
	public static void main(String[] args) throws Exception {
		
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
		
		catch (Throwable e) { 
            e.printStackTrace(System.out); 
        } 
		
	}
}
