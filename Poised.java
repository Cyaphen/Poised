/** Project management program for a structural engineering firm
*to manage their construction projects.
*Invoice number needs to be the same as the project number,
*if the project number is 22 then the invoice number for that project needs to be 22.
*<p>
*@author JP Geyer
*@version 2
*/

// Importing modules
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;
import java.sql.*;



public class Poised {

	public static void main(String[] args) {
		
		try {
			
			// Establishing connection with server and database
			Connection connection = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/poisedpms?useSSL = false",
					"otheruser",
					"swordfish"
					);
		
			// Statement variable with direct access to database for running queries
			Statement statement = connection.createStatement();		
		
		// Initializing scanner and file writer
		Scanner keyboard = new Scanner(System.in);
		
		// Formatting date
		DateFormat formattingDate = new SimpleDateFormat("yyyy-MM-dd"); 
		Date today = new Date();
		
		// Variables for while loop menu selection		
		int menuChoice = 0; // Main menu
		int choice = 0;		// Update details menu
		int find = 0;		// Find project menu
				
		System.out.println("Welcome to Poised Project Management System.");
		System.out.println();
		
		try {		
						
			while (menuChoice != -1) {
			
				// Displaying menu information	
			System.out.println();
			System.out.println("Please select from the following menu options:"
				  + "\n1 - Load new project."
				  + "\n2 - Update project information."
				  + "\n3 - Finalize existing project."
				  + "\n4 - Find a project."
				  + "\n5 - View all projects."
				  + "\n6 - View projects overdue."
				  + "\n-1 - To exit."
				  + "\n:");
		
			menuChoice = keyboard.nextInt(); //scanner
			// Load new project section
			
			if (menuChoice == 1) {
				try {
								
					// Getting project info from user
					System.out.println();
					System.out.println("Please enter the name of the client: ");
					String custName = keyboard.next().trim();
											
					System.out.println("Please enter the surname of the client:  ");
					String custSurname = keyboard.next().trim();
										
					System.out.println("Please enter the email address of the client: ");
					String custEmail = keyboard.next().trim();
												
					System.out.println("Please enter the cellphone number of the client:");
					long custTelNumber = keyboard.nextLong();
										
					System.out.println("Please enter the street number of the client's address: ");
					int custStreetNumber = keyboard.nextInt();
											
					System.out.println("Please enter the street name of the client's address: ");
					String custStreetName = keyboard.next().trim();
										
					// Assigning new customer object
					Customer customerNew = new Customer(custName, custSurname, custEmail, custTelNumber, custStreetNumber,
							custStreetName);
					// Creating string variable to load into database
					String custAddress;
					String custNumberStreet = String.valueOf(custStreetNumber); // Converting integer value to string
					custAddress = custNumberStreet + " " + custStreetName;

					// SQL statement to perform info update from user on database
					String custData = String.format("INSERT INTO customer VALUES('%s', '%s', '%s', '%s', '%s)", custName, custSurname, custEmail,
							custTelNumber, custAddress);
					statement.executeUpdate(custData); // Updating database
								
					System.out.println("Please enter the name of the building contractor: ");
					String contractorName = keyboard.next().trim();
										
					System.out.println("Please enter the surname of the building contratcor");
					String contractorSurname = keyboard.next().trim();
										
					System.out.println("Please enter the email address of the building contractor: ");
					String contractorEmail = keyboard.next().trim();
										
					System.out.println("Please enter the cellphone number of the building contractor: ");
					long contractorTelNumber = keyboard.nextLong();
										
					System.out.println("Please enter the street number of the building contractor's address: ");
					int contractorStreetNumber = keyboard.nextInt();
										
					System.out.println("Please enter the street name of the building contractor's address: ");
					String contractorStreetName = keyboard.next().trim();
										
					// assigning new contractor object
					Contractor contractorNew = new Contractor(contractorName, contractorSurname, contractorEmail, contractorTelNumber,
							contractorStreetNumber, contractorStreetName);
					
					// Creating variable for address to load into database 
					String contAddress;
					String contAddressNumber = String.valueOf(contractorStreetNumber); // converting integer into string value
					contAddress = contAddressNumber + " " + contractorStreetName;

					// SQL statement to perform info update from user on database
					String contData = String.format("INSERT INTO contractor(cont_name, cont_surname, cont_email, cont_tel, cont_address) VALUES('%s',"
							+ "'%s', '%s', '%s', '%s)", contractorName, contractorSurname, 
							contractorEmail, contractorTelNumber, contAddress);
					statement.executeUpdate(contData); // Updating database
					
					System.out.println("Please enter the name of the architect: ");
					String architectName = keyboard.next().trim();
										
					System.out.println("Please enter the surname of the architect: ");
					String architectSurname = keyboard.next().trim();
										
					System.out.println("Please enter the email address of the architect: ");
					String architectEmail = keyboard.next().trim();
										
					System.out.println("Please enter the cellphone number of the architect: ");
					long architectTelNumber = keyboard.nextLong();
										
					System.out.println("Please enter the street number of the architect's address: ");
					int architectStreetNumber = keyboard.nextInt();
										
					System.out.println("Please enter the street name of the architect's address: ");
					String architectStreetName = keyboard.next().trim();
										
					// Assigning new architect object
					Architect architectNew = new Architect(architectName, architectSurname, architectEmail, architectTelNumber,
							architectStreetNumber, architectStreetName);
					
					// Creating variable for address to load into database 
					String archAddress;
					String archAddressNumber = String.valueOf(architectStreetNumber); // converting integer into string value
					archAddress = archAddressNumber + " " + architectStreetName;

					// SQL statement to perform info update from user on database
					String archData = String.format("INSERT INTO architect VALUES('%s', '%s', '%s', '%s', '%s)", architectName, architectSurname, 
							architectEmail, architectTelNumber, archAddress);
					statement.executeUpdate(archData); // Updating database
					
					
					System.out.println("Please enter the project number: ");
					int projectNumber = keyboard.nextInt();
										
					System.out.println("Please enter the building type of the project: ");
					String buildingType = keyboard.next().trim();
										
					System.out.println("Please enter the street number of the project site");
					int projectStreetNumber = keyboard.nextInt();
										
					System.out.println("Please enter the street name of the project site: ");
					String projectStreetName = keyboard.next().trim();
										
					System.out.println("Please enter the suburb name of the project site");
					String projectSuburbName = keyboard.next().trim();
										
					System.out.println("Please enter the ERF number of the project: ");
					int erfNumber = keyboard.nextInt();
										
					System.out.println("Total fee for the project: ");
					long projectFee = keyboard.nextLong();
										
					System.out.println("Enter total ammount paid to date: ");
					long ammountPaidToDate = keyboard.nextLong();
										
					keyboard.nextLine(); // Allows scanner to stop and wait for user input
					System.out.println("Please enter the deadline for the project (eg.yyyy-mm-dd): ");
					String deadline = keyboard.nextLine();
										
					// Creating project name
					String projectName = (buildingType.toLowerCase() + " " + custSurname.toLowerCase());
					
					String toBeCompleted = "To be completed";
					
					// Creating variable for address to load into database 
					String projAddress;
					String projAddressNumber = String.valueOf(projectStreetNumber); // converting integer into string value
					projAddress = projAddressNumber + " " + projectStreetName;

					// SQL statement to perform info update from user on database
					String projAddressData = String.format("INSERT INTO proj_address VALUES('%s', '%s', '%s', '%s', '%s')", projectNumber, erfNumber, projAddress, 
							projectSuburbName, buildingType);
					statement.executeUpdate(projAddressData); // Updating database
					
					// SQL statement to perform info update from user on database
					String projInfoData = String.format("INSERT INTO proj_info VALUES('%s', '%s', '%s', '%s', %s, %s, %s)", projectNumber, projectFee, 
							deadline, architectName, contractorName, projectName, custSurname);
					statement.executeUpdate(projInfoData); // Updating database
					
					String invoiceData = String.format("INSERT INTO invoice VALUES('%s', '%s', '%s', '%s')", projectNumber, erfNumber, toBeCompleted, ammountPaidToDate);
					statement.executeUpdate(invoiceData); // Updating database
					
					// Assigning new projects object
					Projects projectNew = new Projects(projectNumber, projectName, buildingType, projectStreetNumber, projectStreetName,
							projectSuburbName, erfNumber, projectFee, ammountPaidToDate, deadline, architectNew, contractorNew,
					  		customerNew, toBeCompleted);
					
					// Displaying created project to user with 'toString' method
					System.out.println(projectNew.toString());
			}
								
				catch (InputMismatchException e) {
					
					System.out.println("Error, please try again.");
					
				}
			}
		
		// Update project information menu
		else if (menuChoice == 2) {
				
			ArrayList<Projects> listOfProjects = Projects.getProjectsArrayList(); 
			
			System.out.println(listOfProjects);
			
			// While loop menu for user to select what information they want to update
			while (choice != -1) {
				
				System.out.println("Please enter the project number of the project you want to update: ");
				int projectNum = keyboard.nextInt();
			
				Projects selectedProject = listOfProjects.get(projectNum - 1);

				System.out.println();
				System.out.println("Please select the information you would like to update: "
					+ "\n1 - Deadline."
					+ "\n2 - Payment received."
					+ "\n3 - Building contractor's details."
					+ "\n-1 - Exit to menu.");
			choice = keyboard.nextInt();
			
			if (choice == 1) {
				
				try {
					
					// Updating deadline date of project
					System.out.println();
					
					keyboard.nextLine();  // Scanner waits for user input
					System.out.println("Please enter the new deadline for the project(eg. yyyy-mm-dd): ");
					String newDate = keyboard.nextLine();
					selectedProject.setDeadline(newDate);  // assigning new date to object deadline
					
					String updateDeadline = String.format("UPDATE proj_info SET proj_deadline = '%s' WHERE inv_num = '%s'", newDate,
							projectNum);
					statement.executeUpdate(updateDeadline);
					
					System.out.println(selectedProject.getDeadline());
				}
				catch(InputMismatchException | IndexOutOfBoundsException e) {
					
					System.out.println("Error, please try again");
					
				}
			}
			else if (choice == 2) {
				
				try {
					
					//Updating payment received
					System.out.println();
					System.out.println("Please enter the ammount paid by the client: ");
					long tenderAmmount = keyboard.nextLong();
					
					// Adding new amount paid to amount already paid by customer
					long onFilePaid = selectedProject.getAmmountPaid();
					long newPaidAmmount = onFilePaid + tenderAmmount;
					selectedProject.setAmmountPaid(newPaidAmmount); // assigning new paid amount to received payment
					
					String updatePaidAmmount = String.format("UPDATE invoice SET total_paid = '%s' WHERE inv_num = '%s'", newPaidAmmount,
							projectNum);
					statement.executeUpdate(updatePaidAmmount);
					
					// Displaying finance info to user
					System.out.println(selectedProject.getFinances());
				}
				catch(InputMismatchException | IndexOutOfBoundsException e) {
					
					System.out.println("Error, please try again.");
					
				}
			}
				
			else if (choice == 3) {
				
				try {
							
					// Updating contractor information
					System.out.println();
					System.out.println("Please enter the name of the new contractor: ");
					String newName = keyboard.next().trim();
					selectedProject.contractor.setName(newName);
					String updateName = String.format("UPDATE contractor SET cont_name = '%s' WHERE proj_num = '%s'", newName, projectNum);
					statement.executeUpdate(updateName);
					
					System.out.println("Please enter the surname of the new contractor: ");
					String newSurname = keyboard.next().trim();
					selectedProject.contractor.setSurname(newSurname);
					String updateSurname = String.format("UPDATE contractor SET cont_surname = '%s' WHERE proj_num = '%s'", newSurname, projectNum);
					statement.executeUpdate(updateSurname);
					
					System.out.println("Please enter their email address: ");
					String newEmail = keyboard.next().trim();
					selectedProject.contractor.setEmail(newEmail);
					String updateEmail = String.format("UPDATE contractor SET cont_email = '%s' WHERE proj_num = '%s'", newEmail, projectNum);
					statement.executeUpdate(updateEmail);
					
					System.out.println("Please enter their cellphone number: ");
					long newTelNumber = keyboard.nextLong();
					selectedProject.contractor.setNumber(newTelNumber);
					String updateTelNum = String.format("UPDATE contractor SET cont_tel = '%s' WHERE proj_num = '%s'", newTelNumber, projectNum);
					statement.executeUpdate(updateTelNum);
					
					System.out.println("Please enter the street number of the building contractor's address");
					int newStreetNumber = keyboard.nextInt();
					selectedProject.contractor.setStreetNumber(newStreetNumber);
					
					System.out.println("Please enter the street name of the building contractor's address: ");
					String newStreetName = keyboard.next().trim();
					selectedProject.contractor.setStreetName(newStreetName);
					
					String newContAddress;
					String newContAddressNumber = String.valueOf(newStreetNumber); // converting integer into string value
					newContAddress = newContAddressNumber + " " + newStreetName;
					
					String updateContAddress = String.format("UPDATE contractor SET cont_address = '%s' WHERE proj_num = '%s'", newContAddress,
							projectNum);
					statement.executeUpdate(updateContAddress);
					
					getContInfo(statement);
					
				}
				catch(InputMismatchException | IndexOutOfBoundsException e) {
					
					System.out.println("Error, please try again");
				}
			}
				// Returning to main menu
			else if (choice == -1){
				System.out.println("Returning to menu.");
				}
			
			// Statement to inform user of incorrect choice made
			else {
			System.out.println("You have made an incorrect selection, try again.");
			}
		}
		}
		// Finalize project and generate invoice menu
		else if (menuChoice == 3){
			
			try {
				
				System.out.print("Please enter the project number of the project you want to finalize: ");
				int numComplete = keyboard.nextInt();
		               
				// Calling on array list method to create list of projects
				ArrayList<Projects> projectList = Projects.getProjectsArrayList();
				
				// Creating project object from user input 
				Projects completedProject = projectList.get(numComplete - 1);
				
				System.out.println("Please enter the date the project was completed eg.(yyyy-mm-dd):");
				String projectCompleteDate = keyboard.nextLine(); // adding completion date to project
				completedProject.setProjectCompleteDate(projectCompleteDate);
				completedProject.setDeadline(projectCompleteDate);
				
				// Updating completion date on database for project
				String updateComplDate = String.format("UPDATE invoice SET compl_date = '%s' WHERE inv_num = '%s'", projectCompleteDate,
						numComplete);
				String updateDeadline = String.format("update proj_info set proj_deadline = '%s' where proj_num = '%s'", projectCompleteDate,
						numComplete);
				
				statement.executeUpdate(updateComplDate);
				statement.executeUpdate(updateDeadline);
				
				// Informing user project marked complete
				System.out.println(completedProject.toString());
				System.out.println("Project has been marked complete.");
				System.out.println();
				System.out.println(completedProject.getInvoice()); // Generating invoice
					
				}
			
			catch (InputMismatchException e) {
				
				System.out.println("Error, please try again.");
				e.printStackTrace();
			}         
		
		}
		// Search for project menu by number or by name
		else if (menuChoice == 4){
			
				// While loop for searching for a project, either by name or number
				while (find != -1) {
					System.out.println();
					System.out.println("Select one of the following options:"
							+ "\n1 - Find project by name."
							+ "\n2 - Find project by project number."
							+ "\n-1 - Exit to menu."
							+ ": ");
					find = keyboard.nextInt();
					// Find project by name
				if (find == 1) {
				
				// Input from user
				System.out.println("Please enter the name of the project you are looking for: ");
				keyboard.nextLine();
				String userInput = keyboard.nextLine().trim().toLowerCase();
				// Calling on method to create array list of projects
				ArrayList<Projects> searchProject = Projects.getProjectsArrayList();
				// Assigning variable to compare user input with project name.
				String projName = " ";	
				// loop to check through list and find project name
				for (Projects line : searchProject){
						
					projName = (line.getProjectName());
					// Conditional to check if names are equal, ignoring case to avoid errors	
					if (userInput.equalsIgnoreCase(projName)){
						
						// Displaying selected project to user
						String selectProject = line.toString();	
						System.out.println(selectProject);
					}
					// Conditional if user input is not found
					if (!userInput.equalsIgnoreCase(projName)) {
					
						System.out.println("Project not found, check your entry and try again.");
					}
				}					
				}
				// Find project by number
			else if (find == 2) {
				
				try {
				System.out.println("Please enter the project number of the project you are looking for: ");
				int numProject = keyboard.nextInt();
				// Calling on method to create list of projects
				ArrayList<Projects> searchProject = Projects.getProjectsArrayList();
				// Getting the project from user input
				Projects selectedProject = searchProject.get(numProject - 1);
				// Displaying info
				System.out.print(selectedProject.toString());
				}
				// Error handling 
				catch (IndexOutOfBoundsException | InputMismatchException e) {
				
					System.out.println("Project not found, please try again.");
			}
			}
			else if (find == -1) {
				// Return to main menu
				System.out.println("Returning to main menu.");
			}
				
			else {
				// Error handling for wrong selection
				System.out.println("You have made an incorrect selection, try again.");
			}
		}
			
		}
		// View all projects menu                                                          
			else if (menuChoice == 5){
			// Creating projects list
			ArrayList<Projects> viewAll = Projects.getProjectsArrayList();
			// Displaying info
			System.out.println(viewAll.toString());
			
		}
		// View projects that are overdue menu
		else if (menuChoice == 6){
			// Creating project list
			ArrayList<Projects> projList = Projects.getProjectsArrayList();
			// Looping over list to get project dates	
			for (Projects fileLine : projList) {
				
				// Getting project completion date on file
				String projCompDate = fileLine.getProjectCompleteDate();
				String datecompl = "To be completed";
					
				// Getting project date deadline	
				String projDeadline = fileLine.getDeadline();
				
				// Changing info from string to type date in order to compare dates
				Date dateDeadline;
				try {
					dateDeadline = formattingDate.parse(projDeadline);
					
				// Checking for overdue projects
				if (dateDeadline.before(today) && (Objects.equals(projCompDate, datecompl))) {
					
						// Displaying overdue projects
						System.out.println("Overdue Project:");
						System.out.println(fileLine.toString());
						
				}
			}
			catch (ParseException e) {

				e.printStackTrace();
			}
		}
		}

			// Statement to exit program	
		else if (menuChoice == -1) {
			System.out.println("Exiting program, goodbye.");
		}
			
		// Statement if an incorrect entry is made by user on main menu
		else {
			System.out.println("You have made an incorrect selection, try again.");
		}
			}
			
			keyboard.close();  // Closing scanner
	
		}
		catch (InputMismatchException e){
		
			System.out.println("Incorrect selection, please try again.");
		}
		catch (SQLException e) {
			
			System.out.println("Can't connect to the database.");
			e.printStackTrace();
		}
		}
		catch (SQLException e1) {
			
			e1.printStackTrace();
		}

	}
		
		public static void getCustInfo(Statement statement) throws SQLException{
			
			ResultSet results = statement.executeQuery("SELECT cust_surname, cust_name, cust_email, cust_tel, cust_address FROM customer");
			
			while (results.next()) {
				
				String surname = results.getString("cust_surname");
				String name = results.getString("cust_name");
				String email = results.getString("cust_email");
				long telNumber = results.getLong("cust_tel");
				String address = results.getString("cust_address");
				
				String number1 = address.substring(0, 2);
				String streetName = address.substring(3);
				int addressNum = Integer.parseInt(number1);
				
				Customer customer1 = new Customer(name, surname, email, telNumber, addressNum, streetName);
				
				System.out.println(customer1.toString());
				
			}
		}
		
		public static void getContInfo(Statement statement) throws SQLException{
			
			ResultSet contractor = statement.executeQuery("SELECT cont_name, cont_surname, cont_email, cont_tel, cont_address FROM proj_info");
			
			while (contractor.next()) {
				
				String contName = contractor.getString("cont_name");
				String contSurname = contractor.getString("cont_surname");
				String contEmail = contractor.getString("cont_email");
				long contTelNumber = contractor.getLong("cont_tel");
				String contAddress = contractor.getString("cont_address");
				
				String streetNumber = contAddress.substring(0, 2);
				String streetName = contAddress.substring(3);
				int addressNum = Integer.parseInt(streetNumber);
			
				
				Contractor contractor1 = new Contractor(contName, contSurname, contEmail, contTelNumber, addressNum, streetName);
				
				System.out.println(contractor1.toString());
			}
		}
		
	}
	
// https://www.youtube.com/watch?v=_9BgM9c8mIo, Number format
// stackoverflow.com/questions/35990394/eclipse-error-cannot-make-a-static-reference-to-a-non-static-field	
// https://stackoverflow.com/questions/5050170/how-do-i-get-a-date-without-time-in-java	
// https://stackoverflow.com/questions/7877529/java-string-scanner-input-does-not-wait-for-info-moves-directly-to-next-stateme	
// https://stackoverflow.com/questions/26448352/counting-the-number-of-lines-in-a-text-file-java
// https://stackoverflow.com/questions/24816853/comparing-string-date-with-todays-date
//https://stackoverflow.com/questions/54582495/sql-having-a-primary-key-also-be-a-foreign-key

