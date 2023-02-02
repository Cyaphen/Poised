/**
 * @author jpgeyer
 * Projects class for Poised.java
 * @version 1
 * 
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class Projects {
	
	// Attributes
	/**
	 * Integer value for project number
	 */
	private int projectNumber;
	/**
	 * String value for project name
	 */
	private String projectName;
	/**
	 * String value for project building being built
	 */
	private String typeBuilding;
	/**
	 * Integer value for project address street number
	 */
	private int projectStreetNumber;
	/**
	 * String value for project address street name
	 */
	private String projectStreetName;
	/**
	 * String value for project suburb name
	 */
	private String projectSuburbName;
	/**
	 * Integer value for project ERF number
	 */
	private int erfNumber;
	/**
	 * Long value for project cost
	 */
	private long projectFee;
	/**
	 * Long value for received payment from customer
	 */
	private long receivedPayment;
	/**
	 * String value for project deadline date
	 */
	private String deadline;
	/**
	 * Class value for architect's information
	 */
	Architect architect;		// Assigning class to a class in order to share info and communicate. Assisted by John Dorman
	/**
	 * Class value for contractor's information
	 */
	Contractor contractor;		
	/**
	 * Class value for customer's information
	 */
	Customer customer;
	/**
	 * String value for project date of completion
	 */
	private String projectCompleteDate;

	//Constructor 
	public Projects(int projectNumber, String projectName, String typeBuilding, int projectStreetNumber, String projectStreetName,
			String projectSuburbName, int erfNumber, long projectFee, long receivedPayment, String deadline, 
			Architect architect, Contractor contractor, Customer customer, String projectCompleteDate) {
		
		this.projectNumber = projectNumber;
		this.projectName = projectName;
		this.typeBuilding = typeBuilding;
		this.projectStreetNumber = projectStreetNumber;
		this.projectStreetName = projectStreetName;
		this.projectSuburbName = projectSuburbName;
		this.erfNumber = erfNumber;
		this.projectFee = projectFee;
		this.receivedPayment = receivedPayment;
		this.deadline = deadline;
		this.architect = architect;
		this.contractor = contractor;
		this.customer = customer;
		this.projectCompleteDate = projectCompleteDate;
	}
	//Methods
	/**
	 * @return returns project information
	 */
	public String toString() {
		
		// Formatting number to currency
		NumberFormat currency = NumberFormat.getCurrencyInstance(); 
		
		String output = "Project number: " + projectNumber;
		output += "\nProject name: " + projectName;
		output += "\nBuilding type: " + typeBuilding;
		output += "\nProject site: " + projectStreetNumber + " " + projectStreetName + " Street"; 
		output += "\nSuburb: " + projectSuburbName;
		output += "\nERF number: " + erfNumber;
		output += "\nCost of project: " + currency.format(projectFee);     // Using format method to get currency
		output += "\nPayment received: " + currency.format(receivedPayment);
		output += "\nEstimated completion date: " + deadline;
		output += "\nDate completed: " + projectCompleteDate;
		output += "\n" + architect.toString();
		output += "\n" + contractor.toString();
		output += "\n" + customer.toString();
		output += "\n\n";
				
		return output;
	}
	/**
	 * 
	 * @return returns amount still owed on project
	 */
	public String getFinances() {
		
		// Financial info on project
		NumberFormat currency = NumberFormat.getCurrencyInstance();  // Formatting to currency
		System.out.println();
		long stillToPay = projectFee - receivedPayment;
		String feesDue = "Still to pay: " + currency.format(projectFee); // Using format method
		feesDue += "\nAmmount paid: " + currency.format(receivedPayment);
		feesDue += "\nOutstanding ammount: " + currency.format(stillToPay);
		
		return feesDue;
	}
	/**
	 * 
	 * @return returns project information only, no customer, architect, contractor information
	 */
	public String getProjectDetails() {
		// Project details only
		System.out.println();
		String output = "Project name: " + projectName;
		output += "\nProject number: " + projectNumber;
		output += "\nType of building: " + typeBuilding;
		output += "\nProject address: " + projectStreetNumber + " " + projectStreetName + " Street";
		output += "\nSuburb: " + projectSuburbName;
		output += "\nERF number: " + erfNumber;
		output += "\nEstimated completion date: " + deadline;
		output += "\nDate Completed: " + projectCompleteDate;
		output += "\n";
		
		return output;
	}
	/**
	 * 
	 * @param name sets project name
	 */
	public void setProjName(String name) {
		
		this.projectName = name;
		
	}
	/**
	 * 
	 * @param number sets project number
	 */
	public void setProjectNumber(int number) {
		
		this.projectNumber = number;
		
	}
	/**
	 * 
	 * @return returns project number
	 */
	public int getProjectNumber() {
		
		return projectNumber;
		
	}
	/**
	 * 
	 * @return returns project name
	 */
	public String getProjectName() {
		
		return projectName;
		
	}
	/**
	 * 
	 * @param dateCompleted sets project completion date
	 */
	public void setProjectCompleteDate(String dateCompleted){
		
		this.projectCompleteDate = dateCompleted;
		
	}
	/**
	 * 
	 * @param newDeadline sets projects estimated date of completion
	 */
	public void setDeadline(String newDeadline) {
		
		this.deadline = newDeadline;
		
	}
	/**
	 * 
	 * @return returns projects estimated date of completion
	 */
	public String getDeadline() {
				
		return deadline;
	}
	/**
	 * 
	 * @param paidAmmount sets payment received by customer for project
	 */
	public void setAmmountPaid(long paidAmmount) {
		
		this.receivedPayment = paidAmmount;
		
	}
	/**
	 *     
	 * @return returns amount paid by customer for project 
	 */
	public long getAmmountPaid() {
		
		return receivedPayment;
	}
	/**
	 * 
	 * @return returns an invoice generated for customer on completion of project
	 */
	public String getInvoice() {
		// Scanner for user input
		Scanner keyboard = new Scanner(System.in);
		NumberFormat currency = NumberFormat.getCurrencyInstance(); // Formatting number to currency
		
		DateFormat formattingDate = new SimpleDateFormat("dd/MM/yyyy"); // Formatting date
		Date today = new Date();
		String newDate = formattingDate.format(today);
		
		System.out.println("\nPlease enter the invoice number: "); // User input for invoice number
		int invoiceNum = keyboard.nextInt();
		
		long stillToPay = projectFee - receivedPayment;  // Calculation for outstanding amount on project
		
		// Invoice
		String invoice = "\t\tPoised";
		invoice += "\n";
		invoice += "\nDate: " + newDate + "\t\tInvoice number: " + invoiceNum;
		invoice += "\n";
		invoice += "\n" + customer.getFullName() ;  			// calling on classes for information
		invoice += "\n" + customer.getCustomerAddress();
		invoice += "\n" + customer.getCustomerEmail();
		invoice += "\n" + customer.getCustomerNumber();
		invoice += "\nProject name: " + projectName;
		invoice += "\n";
		invoice += "\nProject Fee: " + currency.format(projectFee);  // Formatting to currency
		invoice += "\nAmmount paid: " + currency.format(receivedPayment);
		invoice += "\nOutstanding ammount: " + currency.format(stillToPay);
		invoice += "\n";
		invoice += "\nPlease settle account within 30 days of receipt of this invoice.";
		
		return invoice;
	}
	/**
	 * 
	 * @return returns an array list of projects
	 */
		public static ArrayList<Projects> getProjectsArrayList() {
			// Creating an array list of type Projects to store project info in
			ArrayList<Projects> projectList = new ArrayList<Projects>();
			
			try {
				// Reading from file with project info in
				BufferedReader openProject = new BufferedReader(new FileReader("SearchProjects.txt"));
				
				String fileLine;
			
				String[] details = null;
				// Loop to loop through file and assigning info
				while ((fileLine = openProject.readLine()) != null) {

					details = fileLine.split(", ");
				// Changing info from string to correct type as per constructor to create new project object	
					int projectNum = Integer.parseInt(details[18]);
					int streetNum = Integer.parseInt(details[20]);
					int erfNum = Integer.parseInt(details[23]);
					long projFee = Long.parseLong(details[24]);
					long paymentRec = Long.parseLong(details[25]);
					long telCust = Long.parseLong(details[3]);
					int streetNumCust = Integer.parseInt(details[4]);
					long telContractor = Long.parseLong(details[9]);
					int streetNumContractor = Integer.parseInt(details[10]);
					long telArchitect = Long.parseLong(details[15]);
					int streetNumArchitect = Integer.parseInt(details[16]);
					
					// Creating new objects of customer, contractor and architect
					Customer customer1 = new Customer(details[0], details[1], details[2], telCust, streetNumCust,
							details[5]);
					Contractor contractor1 = new Contractor(details[6], details[7], details[8], telContractor, streetNumContractor,
							details[11]);
					Architect architect1 = new Architect(details[12], details[13], details[14], telArchitect,
							streetNumArchitect, details[17]);
					// Creating new project object
					Projects newProject = new Projects(projectNum, details[27], details[19], streetNum, details[21], details[22],
							erfNum, projFee, paymentRec, details[26], architect1, contractor1, customer1, details[28]);
					
					// Adding info to array list
						projectList.add(newProject);
				}
			}				
					catch (IOException e) {
						
						e.printStackTrace();
					}
			return(projectList);	
		
		}
	}
	
