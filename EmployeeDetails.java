package EmployeeDetails;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Chhanda.karuppanan
 *
 */
/**
 * @author Chhanda.karuppanan
 *
 */
public class EmployeeDetails {

	public static final int numberOfQuarters=4;
	public static final String tripleSpace="   ";
	EmployeeDTO[] employees=null;
	
    //Below method retrieves the employee information to render it as output
	public void retreiveEmployeeDetails(int numberOfEmployees,Scanner scanner,int number) {			
		if(employees==null)
	    employees = new EmployeeDTO[numberOfEmployees];
		int index = number-1;
		employees[index]=new EmployeeDTO();
		fetchEmployeeInformation(employees[index],scanner,number);					
		populateExpectedSalary(employees[index]);
		populateEmployeePerformance(employees[index]);

	}
	
    //Below method calculates the expected salary for the for each employee 
	public void populateExpectedSalary(EmployeeDTO employee) {			
		float overallRating = (employee.totalRating/4);	
		employee.overallRating=overallRating;
		
	    float increment = employee.currentSalary*overallRating/100;
        employee.expectedSalary=employee.currentSalary+increment;    
	}
	
	//Below method calculates the performance for each employee
	public void populateEmployeePerformance(EmployeeDTO employee) {		
		float rating = employee.overallRating;
	 if(rating>=7) {
		 employee.performance="BEST";
	 }else if(rating>=5 && rating<7) {
		 employee.performance="AVERAGE";
	 }else if(rating<5) {
		 employee.performance="ON-TRACK";
	 }		 	 
	}
	
	//below method fetches employee all employee information 
	public void fetchEmployeeInformation(EmployeeDTO employee,Scanner scanner,int empNumber) {	
		System.out.println("Enter the name of the employee "+empNumber+": ");			
		employee.name =checkStringInput(scanner);			
		System.out.println("Enter "+employee.name+" current salary: ");
		employee.currentSalary=checkFloatInput(scanner);
		
		for(int i=1;i<=numberOfQuarters;i++) {
		System.out.println("Enter the rating received for Q"+i+": ");		
		employee.rating[i-1]=checkFloatInput(scanner);
		employee.totalRating+=employee.rating[i-1];		
		}
	}
	//below method prints the all the employee's information
	public void printEmployeeDetails() {						
	
		Arrays.sort(employees);		
		System.out.println("Names          "+"   Q1"+"   Q2"+"   Q3"+"   Q4"+tripleSpace+"Overall Rating   "+"Expected Salary  "+"Performance    ");		
		System.out.println("-----------------------------------------------------------------------------------");		
		for(EmployeeDTO str: employees){ 	    
			System.out.println
			(	
					String.format("%-15s",str.getName().substring(0, Math.min(str.getName().length(), 15)))
					+String.format("%5s", String.format("%.0f",str.rating[0]))
					+String.format("%5s", String.format("%.0f",str.rating[1]))
					+String.format("%5s", String.format("%.0f",str.rating[2]))
					+String.format("%5s", String.format("%.0f",str.rating[3]))
					+tripleSpace
					+String.format("%-17s", str.getOverallRating())  
				    +String.format("%-18s","$"+String.format("%,.2f",str.getExpectedSalary()))  
				    +String.format("%-15s", str.getPerformance())  
					
			);
		}
	}
	
	public int checkIntInput(Scanner s) {
	    while (!s.hasNextInt()) {
	        System.out.println("Given input is not a valid number, please try again.");
	        s.nextLine();
	      }
	      int number = s.nextInt();
		return number;		
	}
	
	public float checkFloatInput(Scanner s) {
	    while (!s.hasNextFloat()) {
	        System.out.println("Given input is not a valid number, please try again.");
	        s.next();
	      }	     
		return s.nextFloat();		
	}
	
	public String checkStringInput(Scanner s) {	
		String name = s.next();
			while(!isStringOnlyAlphabet(name)) {
				System.out.println("Given input is not a valid name, please try again");
				s.nextLine();
				name=s.next();				
			}
			return name;
	}
	
	public boolean isStringOnlyAlphabet(String str) 
	{ 
	    return ((!str.equals("")) 
	            && (str != null) 
	            && (str.matches("^[a-zA-Z]*$"))); 
	} 
	
}
