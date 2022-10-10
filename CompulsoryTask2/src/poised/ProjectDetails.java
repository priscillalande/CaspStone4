// This class stores the project details
package poised;

public class ProjectDetails {
	// Attributes
	public int projectNumber;
	public String projectName;
	public String buildingType;
	public String physicalAddress;
	public String erfNumber;
	protected double projectCost;
	protected double amountPaid;
	public String projectCompletion;
	public String clientName;
	public String dueDate;
	
	// Contractor
	public ProjectDetails(String clientName, int projectNumber, 
			String projectName, String buildingType, String physicalAddress,
			String erfNumber, double projectCost, double amountPaid,
			String dueDate) {
		this.projectNumber = projectNumber;
		this.projectName = projectName;
		this.buildingType = buildingType;
		this.physicalAddress = physicalAddress;
		this.erfNumber = erfNumber;
		this.projectCost = projectCost;
		this.amountPaid = amountPaid;
		this.dueDate = dueDate;
		this.projectCompletion = "No";
		this.clientName = clientName;
	}
	// Set the due date of the project
	public  void changeDueDate(String dueDate) {
		this.dueDate = dueDate;
	}
	// Updated the amount paid
	public void ChangeAmountPaid(double amountPaid) {
		this.amountPaid = amountPaid;
	}
	// Update the completion status of the project to yes
	public void setProjectAsCompleted() {
		this.projectCompletion = "Yes";
	}
	
	public String toString() {
	      String output = "\nClient name:\t\t" + clientName;
	      output += "\nProject number:\t\t" + projectNumber;
	      output += "\nProject name:\t\t" + projectName;
	      output += "\nBuilding type:\t\t" + buildingType;
	      output += "\nPhysical address:\t" + physicalAddress;
	      output += "\nERF Number:\t\t" + erfNumber;
	      output += "\nProject Coast:\t\tR" + projectCost;
	      output += "\nAmount paid:\t\tR" + amountPaid;
	      output += "\nProject completed?\t" + projectCompletion;
	      output += "\nDue Date:\t\t" + dueDate;
	   
	      return output;
	}
}
