package EmployeeDetails;

import java.util.*;
import java.util.Map.Entry;

public class EmployeeDetails {

	List<EmployeeDTO> employeeDetails=new ArrayList<EmployeeDTO>();	
	public static final int numberOfQuarters=4;
	public static final String tripleSpace="   ";
	
	
	public void getEmployeeDetails(int empNumber,Scanner s) {				
		EmployeeDTO employee = new EmployeeDTO();		
		employeeDetails.add(employee);
		
		getEmployeeDetails(employee,s,empNumber);					
		calculateExpectedSalary(employee);
		calculateEmployeePerformance(employee);
		
	}
	
	public void calculateExpectedSalary(EmployeeDTO employee) {			
		float overallRating = (employee.totalRating/4);	
		employee.overallRating=overallRating;
		
	    float increment = employee.currentSalary*overallRating/100;
        employee.expectedSalary=employee.currentSalary+increment;    
	}
	
	public void calculateEmployeePerformance(EmployeeDTO employee) {
		
		float rating = employee.overallRating;
	 if(rating>=7) {
		 employee.performance="BEST";
	 }else if(rating>=5 && rating<7) {
		 employee.performance="AVERAGE";
	 }else if(rating<5) {
		 employee.performance="ON-TRACK";
	 }		 	 
	}
	
	public void getEmployeeDetails(EmployeeDTO employee,Scanner s,int empNumber) {				
		System.out.println("Enter the name of the employee "+empNumber+": ");					
		employee.name=checkStringInput(s);			
		System.out.println("Enter "+employee.name+" current salary: ");
		employee.currentSalary=checkFloatInput(s);
		
		for(int i=1;i<=numberOfQuarters;i++) {
		System.out.println("Enter the rating received for Q"+i+": ");		
		employee.rating[i-1]=checkFloatInput(s);
		employee.totalRating+=employee.rating[i-1];		
		}
	}
	public void printEmployeeDetails() {
		
		Collections.sort(employeeDetails);					
		System.out.println("Names          "+"   Q1"+"   Q2"+"   Q3"+"   Q4"+tripleSpace+"Overall Rating   "+"Expected Salary  "+"Performance    ");		
		System.out.println("-----------------------------------------------------------------------------------");
		
		for(EmployeeDTO str: employeeDetails){ 	    
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
	        System.out.println("Input is not a number. Please try again");
	        s.nextLine();
	      }
	      int number = s.nextInt();
		return number;		
	}
	
	public float checkFloatInput(Scanner s) {
	    while (!s.hasNextFloat()) {
	        System.out.println("Number was incorrect, please try again.");
	        s.next();
	      }	     
		return s.nextFloat();		
	}
	
	public String checkStringInput(Scanner s) {	
		String name = s.next();
			while(!isStringOnlyAlphabet(name)) {
				System.out.println("Input is not a string, please try again");
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
