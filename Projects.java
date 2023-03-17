/**
 * @author jpgeyer
 * Projects class for Poised.java
 * @version 2
 * 
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
	 * @return returns project completion date
	 */
	public String getProjectCompleteDate() {
		
		return projectCompleteDate;
		
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
		
		DateFormat formattingDate = new SimpleDateFormat("yyyy-mm-dd"); // Formatting date
		Date today = new Date();
		String newDate = formattingDate.format(today);
		
		int invoiceNum = getProjectNumber();
		
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
				
				// Establishing connection with server and database
				Connection connection = DriverManager.getConnection(
						"jdbc:mysql://localhost:3306/poisedpms?useSSL = false",
						"otheruser",
						"swordfish"
						);
			
				// Statement variable with direct access to database for running queries
				Statement statementCust = connection.createStatement();
				Statement statementArch = connection.createStatement();
				Statement statementCont = connection.createStatement();
				Statement statementInfo = connection.createStatement();
				Statement statementDetails = connection.createStatement();
				Statement statementInfo1 = connection.createStatement();
				
				// SQL statements
				ResultSet customer = statementCust.executeQuery("SELECT cust_surname, cust_name, cust_email, cust_tel, cust_address FROM customer");
				ResultSet architect = statementArch.executeQuery("SELECT arch_name, arch_surname, arch_email, arch_tel, arch_address FROM architect");
				ResultSet contractor = statementCont.executeQuery("SELECT cont_name, cont_surname, cont_email, cont_tel, cont_address FROM contractor");
				ResultSet projInfo = statementInfo.executeQuery("SELECT proj_num, proj_fee, proj_deadline FROM proj_info");
				ResultSet projDetails = statementDetails.executeQuery("SELECT proj_address, proj_suburb, proj_name, build_type, erf_num FROM proj_address");
				ResultSet projInfo1 = statementInfo1.executeQuery("SELECT date_complete, total_paid FROM invoice");
				
				// Getting info from database and creating objects
				while (customer.next() && architect.next() && contractor.next() && projInfo.next() && projDetails.next() && projInfo1.next()) { 

					
					String custSurname = customer.getString("cust_surname");
					String custName = customer.getString("cust_name");
					String custEmail = customer.getString("cust_email");
					long custTelNumber = customer.getLong("cust_tel");
					String custAddress = customer.getString("cust_address");
					
					// Splitting address to match constructor
					String custNumber = custAddress.substring(0, 2);
					String custStreetName = custAddress.substring(3);
					int custAddressNum = Integer.parseInt(custNumber);
					
					Customer customer1 = new Customer(custName, custSurname, custEmail, custTelNumber, custAddressNum, custStreetName);

				// Getting architect info from the database and creating architect object
					
					String archName = architect.getString("arch_name");
					String archSurname = architect.getString("arch_surname");
					String archEmail = architect.getString("arch_email");
					long archTelNumber = architect.getLong("arch_tel");
					String archAddress = architect.getString("arch_address");
						
					// Splitting address to match constructor
					String archNumber = archAddress.substring(0, 2);
					String archStreetName = archAddress.substring(3);
					int archAddressNum = Integer.parseInt(archNumber);
						
					Architect architect1 = new Architect(archName, archSurname, archEmail, archTelNumber, archAddressNum, archStreetName); 

				// Getting contractor info from database and creating contractor object
						
					String contName = contractor.getString("cont_name");
					String contSurname = contractor.getString("cont_surname");
					String contEmail = contractor.getString("cont_email");
					long contTelNumber = contractor.getLong("cont_tel");
					String contAddress = contractor.getString("cont_address");
						
					// Splitting address to match constructor
					String contNumber = contAddress.substring(0, 2);
					String contStreetName = contAddress.substring(3);
					int contAddressNum = Integer.parseInt(contNumber);
							
					Contractor contractor1 = new Contractor(contName, contSurname, contEmail, contTelNumber, contAddressNum, contStreetName); 

				// Getting info to create project object
							
					int projNum = projInfo.getInt("proj_num");
					long projFee = projInfo.getLong("proj_fee");
					String projDeadline = projInfo.getString("proj_deadline");
									
					String nameProj = projDetails.getString("proj_name");
					String buildType = projDetails.getString("build_type");
					int erfNum = projDetails.getInt("erf_num");
				
					String projSuburb = projDetails.getString("proj_suburb");
					String addressProj = projDetails.getString("proj_address");
									
					// Splitting address to match constructor
					String projStreetNumber = addressProj.substring(0, 2);
					String projStreetName = addressProj.substring(3);
					int projAddressNum = Integer.parseInt(projStreetNumber);									
										
					String complDate = projInfo1.getString("date_complete");
					long totalPaid = projInfo1.getLong("total_paid");
									
					// Creating project object	
					Projects newProject = new Projects(projNum, nameProj, buildType, projAddressNum, projStreetName, projSuburb, erfNum,
							projFee, totalPaid, projDeadline, architect1, contractor1, customer1, complDate);
									
					// Adding projects to array list
					projectList.add(newProject);

				}
			}				
					catch (SQLException e) {
						
						e.printStackTrace();
						System.out.println("An error has occured, please try again");
					}
			
			return(projectList);
			
		}
	}
	
