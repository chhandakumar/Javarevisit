package employee;


/**
 * @author Chhandakumar.karuppanan
 * This class contains employee properties which are used to store and retreive them.
 */
public class EmployeeDTO implements Comparable<EmployeeDTO> {

	public String name;
	public float currentSalary;
	public float[] rating = new float[4];
	public float expectedSalary;
	public String performance;
	public float totalRating;
	public float overallRating;

	public EmployeeDTO() {		
		this.name = null;
		this.currentSalary = 0.0f;
		this.expectedSalary = 0.0f;
		this.overallRating = 0;
		this.performance = null;		 		
	}
	public String getName() {
		return name;
	}




	public float getCurrentSalary() {
		return currentSalary;
	}




	public float[] getRating() {
		return rating;
	}




	public float getExpectedSalary() {
		return expectedSalary;
	}




	public String getPerformance() {
		return performance;
	}




	public float getTotalRating() {
		return totalRating;
	}




	public float getOverallRating() {
		return overallRating;
	}


	public int compareTo(EmployeeDTO emp) {
		if(emp.overallRating>=this.overallRating) {
			return 1;
		}else if(emp.overallRating<=this.overallRating) {
				return -1;
			}
		return 0;
	}


}
