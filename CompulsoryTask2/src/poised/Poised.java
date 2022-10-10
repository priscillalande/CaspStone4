/* This program stores the project details for Poised structural company
 * and gives a user option to enter more information or modify the existing
 */
package poised;

// Import all java utilities
import java.util.*;
import java.util.stream.IntStream;
import java.text.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Poised {
	
	// Array list to store class objects
	public static ArrayList<ProjectDetails> projectList 
	= new ArrayList<ProjectDetails>();
	public static ArrayList<CreatePerson> contractorList
	= new ArrayList<CreatePerson>();
	
	public static void main(String[] args) throws ParseException {
		Scanner input = new Scanner(System.in);
		
		// Date formating
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		
		// Attributes
		String clientName;
		int projectNumber = 0;
		String projectName;
		String buildingType;
		String physicalAddress;
		String erfNumber;
		String dueDate;
		Double projectCost;
		Double amountPaid;
		Boolean found = true;

		// Will execute this until user chooses to exit
		while (true) {
			
			// Displays the following the menu options for the user
			System.out.print("\nWhat would you like to do:\n"
					+ "'cp' - to capture project details\n"
					+ "'va' - view all projects\n"
					+ "'cd' - to change due date\n"
					+ "'co' - to mark project as completed\n"
					+ "'ca' - to change total amound paid to date\n"
					+ "'uc' - to update contractor's contact details\n"
					+ "'fp' - to finalise the project\n"
					+ "'e'  - to exit\n"
					+ ": ");
			String menu = input.next();
			
			if (menu.equalsIgnoreCase("cp")) {
				
				/* Checks if the project number already exist by looping
				 * through object list 
				 */
				while(found) {
					found = false;
					System.out.print("\nEnter project number: ");
					projectNumber = input.nextInt();
					
					/* Loops through all ProjectDetails object and compare if
					 * the project name entered by the user matches one of the 
					 * existing objects. Once the project is found set found to
					 * true and break the loop
					 */
					for (ProjectDetails item: projectList) {
						if (item.projectNumber == projectNumber) {
							found = true;
							System.out.println("\nThe project number "
									+ "already exist. Please enter a "
									+ "different number..");
							break;
						}
					}
				}
				input.nextLine();
				// Commands the user to enter project information
				System.out.print("Enter client's name: ");
				clientName = input.nextLine();
				System.out.print("Enter project name: ");
				projectName = input.nextLine();
				System.out.print("Enter building type: ");
				buildingType = input.nextLine();
				System.out.print("Enter physical address: ");
				physicalAddress = input.nextLine();
				System.out.print("Enter ERF number: ");
				erfNumber = input.nextLine();
				System.out.print("Enter due date (dd/mm/yyyy): ");
				dueDate = input.nextLine();
				System.out.print("Enter project cost: R");
				projectCost = input.nextDouble();
				System.out.print("Enter amount paid already: R");
				amountPaid = input.nextDouble();

				// Create ProjecDetails class objects
				ProjectDetails project = new ProjectDetails(clientName, 
						projectNumber, projectName, buildingType, 
						physicalAddress, erfNumber, projectCost, amountPaid,
						dueDate);
				projectList.add(project);
				System.out.println("\nPROJECT CAPTURED!!");
				
			// Displays all the project found on projectList
			}else if (menu.equalsIgnoreCase("va")) {
				for (ProjectDetails project: projectList) {
					System.out.println("\n======================================");
					System.out.println(project.toString());
				}
				
			}else if (menu.equalsIgnoreCase("cd")) {
				System.out.print("Enter number of a project you want to change: ");
				projectNumber = input.nextInt();
				
				/* Calls getProject method to check if the project exist. If the object 
				 * exist it returns it or null if its not found
				 */
				if (getProject(projectNumber) != null) {
					System.out.print("Current due date: " + getProject(projectNumber).dueDate
							+ "\nEnter new completion date: ");
					System.out.print("Enter new due date (dd/mm/yyyy): ");
					dueDate = input.next();
					
					// Assigns a new dueDate value
					getProject(projectNumber).dueDate = dueDate;
					System.out.println("\nDue date CHANGED!!");
				}else {
					System.out.println("The project you looking for does not exist!!");
				}
			
			// Marks the project as complete by changing the projectCompletion value to yes
			}else if (menu.equalsIgnoreCase("co")) {
				System.out.print("Enter number of a project you want to mark as complete: ");
				projectName = input.next();
				
				if (getProject(projectNumber) != null) {
					getProject(projectNumber).projectCompletion = "Yes";
					System.out.println("\nProject marked as completed");
				}else {
					System.out.println("\nThe project you looking for does not exist!!");
				}
				
			// Changes the amountPaid to a new value specified by user
			}else if (menu.equalsIgnoreCase("ca")) {
				System.out.print("Enter number of a project you want to change the amount: ");
				projectName = input.next();
				
				// Checks if the project exists by calling getProject method
				if (getProject(projectNumber) != null) {
					System.out.print("Current paid amount: R" 
							+ getProject(projectNumber).amountPaid
							+ "\nEnter new paid amount: R");
					getProject(projectNumber).amountPaid = input.nextDouble();
					System.out.println("\nAmount CHANGED!!");
				}else {
					System.out.println("\nThe project you looking for does not exist!!");
				}
			
			}else if (menu.equalsIgnoreCase("uc")) {
				// Prints the menu option for user to select
				System.out.print("What would like to update:"
						+ "\n'cc' - to capture contractor"
						+ "\n'cn' - to telephone number"
						+ "\n'ce' - to email address"
						+ "\n'ca' - to change address"
						+ "\n'rm' - to return to main menu"
						+ "\n: ");
				String detailMenu = input.next();
				
				// Captures contractor information
				if (detailMenu.equalsIgnoreCase("cc")) {
					System.out.print("Enter contractors name: ");
					String contractorName = input.next();
					System.out.print("Enter contractor's phone number: ");
					String contractorPhone = input.next();
					System.out.print("Enter contractor's email address: ");
					String contractorEmail = input.next();
					System.out.print("Enter contractor's physical address: ");
					String contractorAddress = input.next();
					
					// Creates new contractor objects
					CreatePerson contactor = new CreatePerson(contractorName, 
							contractorPhone, contractorEmail, contractorAddress);
					
					// Adds all the contractor objects on to the object list
					contractorList.add(contactor);
				
				// Changes the contractor's phone number
				}else if (detailMenu.equalsIgnoreCase("cn")) { 
					System.out.print("Enter the name of the contractor: ");
					String contractorName = input.next();
					
					if (getContractor(contractorName) != null) {
						System.out.print("The current contractor's number is: " 
						+ getContractor(contractorName).telephoneNumber
						+ "\nEnter new phone number: ");
						getContractor(contractorName).telephoneNumber = input.next();
						System.out.println("\nPhone Number CHANGED");
					
					}else {
						System.out.println("nThere is no contractor with the "
								+ "name you have entered!!");
					}
					
				// Changes the contractor's email address by assigning a new value
				}else if(detailMenu.equalsIgnoreCase("ce")) {
					System.out.print("Enter the name of the contractor: ");
					String contractorName = input.next();
					
					if (getContractor(contractorName) != null) {
						System.out.print("The current contractor's email is: " 
						+ getContractor(contractorName).emailAddress
						+ "\nEnter new email address: ");
						getContractor(contractorName).emailAddress = input.next();
						System.out.println("\nEmail address CHANGED");
					
					}else {
						System.out.println("nThere is no contractor with the "
								+ "name you have entered!!");
					}
				
				// Changes the contractor's physical address
				}else if(detailMenu.equalsIgnoreCase("ca")) {
					System.out.print("Enter the name of the contractor: ");
					String contractorName = input.next();
					
					if (getContractor(contractorName) != null) {
						System.out.print("The current contractor's physical address is: " 
						+ getContractor(contractorName).physicalAddress
						+ "\nEnter new physical address: ");
						getContractor(contractorName).physicalAddress = input.next();
						System.out.println("\nPhysical address CHANGED");
					
					}else {
						System.out.println("\nThere is no contractor with the "
								+ "name you have entered!!");
					}
				// Return to main menu	
				}else if (menu.equalsIgnoreCase("rm")) {
					
				}else {
					System.out.println("That was an invalid choise. Please try again...");
				}
			
			// Prints  out the invoice for the project
			}else if (menu.equalsIgnoreCase("fp")) {
				System.out.print("Enter the name of the project to finalise: ");
				projectNumber = input.nextInt();
				
				// Checks if the project exist if yes returns the object if no returns null
				if (getProject(projectNumber) != null) {
					
					/* Checks if the project has been completed by checking the value of 
					 * projectCompletion
					 */
					if (getProject(projectNumber).projectCompletion == "No") {
						
						/* Calculates the amount due by subtracting the amountPaid value
						 * form projectCost value
						 */
						double amountDue = getProject(projectNumber).projectCost 
								- getProject(projectNumber).amountPaid;
						System.out.println("\n===========================INVOICE======================="
								+ "\n\nFrom: Poised Structural Engineers\t\tDate: " +  LocalDate.now()
								+ "\n\nBill To:"
								+ "\n" + getProject(projectNumber).clientName
								+ "\n" + getProject(projectNumber).physicalAddress
								+ "\n\nProject cost\t\tAmount Paid\t\tAmaount Due"
								+ "\nR" + getProject(projectNumber).projectCost + "\t\t\tR" 
								+ getProject(projectNumber).amountPaid
								+ "\t\t\tR" + amountDue
								+ "\n=========================================================");
					} else {
						System.out.println("\nThe project has been completed already...");
					}
				} else {
					System.out.println("\nThe project you looking for does not exist!!");
				}
				
			}else if (menu.equalsIgnoreCase("e")) {
				System.out.println("\nGOOD BYE!!");
				System.exit(0);
				
			}else {
				System.out.println("That was an invalid choise. Please try again...");
			}
			
		}
	}
	
	// Checks if the project exist in projectList
	public static ProjectDetails getProject(int projectNumber) {
		ProjectDetails projectFound = null;
		
		/* Goes through all the project details objects and checks for 
		 * a matching project number
		 */
		for (ProjectDetails project: projectList) {
			if (project.projectNumber == projectNumber) {
				
				// Assigns project object to projectFound
				 projectFound = project;
			}
		}
		return projectFound;
	}
	
	// Checks if the contractor exist in contractorList
	public static CreatePerson getContractor(String contractorName) {
		CreatePerson contractorFound = null;
		
		for (CreatePerson contractor: contractorList) {
			if (contractor.name.equalsIgnoreCase(contractorName)) {
				 contractorFound = contractor;
			}
		}
		return contractorFound;
	}
}