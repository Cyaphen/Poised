/**
 * 
 * @author jpgeyer
 * Customer class for Poised.java
 * @version 1
 *
 */
public class Customer {
		
	// Attributes
	/**
	 * String value for customer's first name
	 */
	private String customerName;
	/**
	 * String value for customer's last name
	 */
	private String customerSurname;
	/**
	 * String value for customer's email address
	 */
	private String customerEmail;
	/**
	 * Long value for customer's telephone number
	 */
	private long customerTelNumber;
	/**
	 * Integer value for customer's address street number
	 */
	private int customerStreetNumber;
	/**
	 * String value for customer's address street name
	 */
	private String customerStreetName;

	// Constructor
	public Customer(String customerName, String customerSurname, String customerEmail,
			long customerTelNumber, int customerStreetNumber, String customerStreetName) {
	
		this.customerName = customerName;
		this.customerSurname = customerSurname;
		this.customerEmail = customerEmail;
		this.customerTelNumber = customerTelNumber;
		this.customerStreetNumber = customerStreetNumber;
		this.customerStreetName = customerStreetName;
				
	}
	// Methods
	/**
	 * 
	 * @param name customer's first name
	 * @param surname customer's last name
	 * @param email customer's email address
	 * @param telephone number customer's telephone number
	 * @param address customer's physical address
	 * @return returns customer's information
	 */
	public String toString() {
		
		System.out.println();
		String output = "Designation: Customer";
		output += "\nName: " + customerName;
		output += "\nSurname: " + customerSurname;
		output += "\nEmail address: " + customerEmail;
		output += "\nTelephone number: (+27)" + customerTelNumber;
		output += "\nPhysical address: " + customerStreetNumber + " " + customerStreetName + " Street";
				
		return output;
	}
	/**
	 * 
	 * @param number sets customer's address street number
	 */
	public void setCustStreetNum(int number) {
		
		this.customerStreetNumber = number;
		
	}
	/**
	 * 
	 * @param name sets customer's address street name
	 */
	public void setCustStreetName(String name) {
		
		this.customerStreetName = name;
		
	}
	/**
	 * 
	 * @return returns customer's physical address
	 */
	public String getCustomerAddress() {
		
		return "Customer address: " + customerStreetNumber + " " + customerStreetName + " Street";
	}
	/**
	 * 
	 * @param email sets customer's email
	 */
	public void setCustomerEmail(String email) {
		
		this.customerEmail = email;
		
	}
	/**
	 * 
	 * @return returns customer's email address
	 */
	public String getCustomerEmail() {
		
		return "Customer email: " + customerEmail;
	}
	/**
	 * 
	 * @param number sets customer's telephone number
	 */
	public void setCustomerNumber(long number) {
		
		this.customerTelNumber = number;
		
	}
	/**
	 * 
	 * @return returns customer's telephone number
	 */
	public String getCustomerNumber() {
		
		return "Customer telephone Number: (+27)" + customerTelNumber;
	}
	/**
	 * 
	 * @return returns customer's full name
	 */
	public String getFullName() {
		
		System.out.println();
		return "Customer full name: " + customerName + " " + customerSurname;
	}
	/**
	 * 
	 * @param surname sets customer's last name
	 */
	public void setSurname(String surname) {
		
		this.customerSurname = surname;
		
	}
	/**
	 * 
	 * @param name sets customer's first name
	 */
	public void setName(String name) {
		
		this.customerName = name;
		
	}
	/**
	 * 
	 * @return returns customer's last name
	 */
	public String getSurname() {
		
		return customerSurname;
	}
			
}