/**
 * 
 * @author jpgeyer
 * Contractor class for Poised.java
 * @version 1
 *
 */
public class Contractor {
	
	// Attributes
	/**
	 * String value for contractor's first name
	 */
	private String contractorName;
	/**
	 * String value for contratcor's last name
	 */
	private String contractorSurname;
	/**
	 * String value for contratcor's email address
	 */
	private String contractorEmail;
	/**
	 * Long value for contractor's telephone number
	 */
	private long contractorTelNumber;
	/**
	 * Integer value for contractor's address street number
	 */
	private int contractorStreetNumber;
	/**
	 * String value for contractor's address street name
	 */
	private String contractorStreetName;

	// Constructor
	public Contractor(String contractorName, String contractorSurname, String contractorEmail,
			long contractorTelNumber, int contractorStreetNumber, String contractorStreetName) {
			
		this.contractorName = contractorName;
		this.contractorSurname = contractorSurname;
		this.contractorEmail = contractorEmail;
		this.contractorTelNumber = contractorTelNumber;
		this.contractorStreetNumber = contractorStreetNumber;
		this.contractorStreetName = contractorStreetName;
			
	}
	// Methods
	/**
	 * 
	 * @param name contratcor's first name
	 * @param surname contractor's last name
	 * @param email contractor's email address
	 * @param telephone number contratcor's telephone number
	 * @param address contractor's physical address
	 * @return returns contractor's information
	 */
	public String toString() {
		
		System.out.println();
		String output = "Designation: Building Contractor";
		output += "\nName: " + contractorName;
		output += "\nSurname: " + contractorSurname;
		output += "\nEmail address: " +contractorEmail;
		output += "\nTelephone number: (+27)" + contractorTelNumber;
		output += "\nPhysical address: " + contractorStreetNumber + " " + contractorStreetName + " Street";
				
		return output;
	}
	/**
	 * 
	 * @param newStreetNumber sets contratcor's address street number
	 */
	public void setStreetNumber(int newStreetNumber) {
		
		this.contractorStreetNumber = newStreetNumber;
		
	}
	/**
	 * 
	 * @param newStreetName sets contratcor's address street name
	 */
	public void setStreetName(String newStreetName) {
		
		this.contractorStreetName = newStreetName;
		
	}
	/**
	 * 		
	 * @return returns contratcor's physical address
	 */
	public String getAddress() {
				
		System.out.println();
		return "Contratcor address: " + contractorStreetNumber + " " + contractorStreetName + " Street";
	}
	/**
	 * 
	 * @param newEmail sets contratcor's email address
	 */
	public void setEmail(String newEmail) {
		
		this.contractorEmail = newEmail;
		
	}
	/**
	 * 		
	 * @return returns contractor's email address
	 */
	public String getEmail() {
				
		System.out.println();
		return contractorEmail;
	}
	/**
	 * 
	 * @param newNumber sets contratcor's telephone number
	 */
	public void setNumber(Long newNumber) {
		
		this.contractorTelNumber = newNumber;
		
	}
	/**
	 * 
	 * @return returns contractor's telephone number
	 */
	public long getNumber() {
				
		System.out.println();
		return contractorTelNumber;
	}
	/**
	 * 
	 * @param newName sets contratcor's first name
	 */
	public void setName(String newName) {
	
		this.contractorName = newName;
			
	}
	/**
	 * 
	 * @param newSurname sets contratcor's last name
	 */
	public void setSurname(String newSurname) {
		
		this.contractorSurname = newSurname;
		
	}
	/**
	 * 
	 * @return returns contractor's full name
	 */
	public String getFullName() {
				
		System.out.println();
		return "Contractor full name: " + contractorName + " " + contractorSurname;
	}
}
