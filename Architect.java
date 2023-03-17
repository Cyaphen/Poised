/**
 * 
 * @author jpgeyer
 * Architect class for Poised.java
 * @version 1
 */
public class Architect {
	
	// Attributes
	/**
	 * String value for architect's first name
	 */
	private String architectName;
	/**
	 * String value for architect's last name
	 */
	private String architectSurname;
	/**
	 * String value for architect's email address
	 */
	private String architectEmail;
	/**
	 * Long value for architect's telephone number
	 */
	private long architectTelNumber;
	/**
	 * Integer value for architect's address street number
	 */
	private int architectStreetNumber;
	/**
	 * String value for architect's address street name
	 */
	private String architectStreetName;

	// Constructor
	public Architect(String architectName, String architectSurname, String architectEmail,
			long architectTelNumber, int architectStreetNumber, String architectStreetName) {

		this.architectName = architectName;
		this.architectSurname = architectSurname;
		this.architectEmail = architectEmail;
		this.architectTelNumber = architectTelNumber;
		this.architectStreetNumber = architectStreetNumber;
		this.architectStreetName = architectStreetName;
	}
	// Methods
	/**
	 * @param name architect's name
	 * @param surname architect's surname
	 * @param email architect's email
	 * @param telephone number architect's telephone number
	 * @param address architect's physical address
	 * @return returns architect's information
	 */
	public String toString() {
			
		System.out.println();
		String output = "Designation: Architect";
		output += "\nName: " + architectName;
		output += "\nSurname: " + architectSurname;
		output += "\nEmail address: " + architectEmail;
		output += "\nTelephone number: (+27)" + architectTelNumber;
		output += "\nPhysical address: " + architectStreetNumber + " " + architectStreetName + " Street";
		
		return output;
	}
	/**
	 * @param number sets architect's street address number 
	 */
	public void setArchStreetNum(int number) {
		
		this.architectStreetNumber = number;
	}
	/**
	 * 
	 * @param name sets architect's street name
	 */
	public void setArchStreetName(String name) {
		
		this.architectStreetName = name;
		
	}
	/**
	 * 
	 * @return returns architect's physical address
	 */
	public String getArchAddress() {
			
		System.out.println();
		return "Architect address: " + architectStreetNumber + " " + architectStreetName + " Street";
	}
	/**
	 * 
	 * @param email sets architect's email address
	 */
	public void setArchEmail(String email) {
		
		this.architectEmail = email;
	}
	/**
	 * 
	 * @return returns architect's email address
	 */
	public String getArchitectEmail() {
			
		return architectEmail;
	}
	/**
	 * 
	 * @param number sets architect's telephone number
	 */
	public void setArchTelNumber(long number) {
		
		this.architectTelNumber = number;
	}
	/**
	 * 
	 * @return returns architect's telephone number
	 */
	public long getArchitectTelNumber() {
			
		return architectTelNumber;
	}
	/**
	 * 
	 * @param name sets architect's first name
	 */
	public void setArchName(String name) {
		
		this.architectName = name;
	}
	/**
	 * 
	 * @param surname sets architect's last name
	 */
	public void setArchSurname(String surname) {
		
		this.architectSurname = surname;
	}
	/**
	 * 
	 * @return returns architect's full name
	 */
	public String getFullName() {
			
		System.out.println();
		return "Architect full name: " + architectName + " " + architectSurname;
	}
		
}
