// This class creates object contractor
package poised;

public class CreatePerson {
	
	String name;
	String telephoneNumber;
	String emailAddress;
	String physicalAddress;

	public CreatePerson(String name, String telephoneNumber,
			String emailAddress, String physicalAddress) {
		
		this.name = name;
		this.telephoneNumber = telephoneNumber;
		this.emailAddress = emailAddress;
		this.physicalAddress = physicalAddress;
		
	}
	// Return the output string
	public String toString() {
	      String output = "\nContractor's name:\t\t" + name;
	      output += "\nTelephone number:\t\t" + telephoneNumber;
	      output += "\nEmail address:\t\t" + emailAddress;
	      output += "\nPhysical address:\t" + physicalAddress;
	   
	      return output;
	}
	

}
