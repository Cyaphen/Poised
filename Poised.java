/** Project management program for a structural engineering firm
*to manage their construction projects
*<p>
*@author jpgeyer
*@version 1
*/

// Importing modules
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.io.*;

public class Poised {

	public static void main(String[] args) {
		
		// Initializing scanner and file writer
		Scanner keyboard = new Scanner(System.in);
		FileWriter open = null; // New Projects file
		PrintWriter writer = null; // New Projects file, written in easy to read format for user
		FileWriter open1 = null; // Search Projects file
		PrintWriter writer1 = null;// Search Projects file, written on one line for developer use
		
		
		// Formatting date
		DateFormat formattingDate = new SimpleDateFormat("dd-MM-yyyy"); 
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
					System.out.println("Please enter the deadline for the project (eg.dd-mm-yyyy): ");
					String deadline = keyboard.nextLine();
										
					// Creating project name
					String projectName = (buildingType.toLowerCase() + " " + custSurname.toLowerCase());
					
					String toBeCompleted = "To be completed";
					
					// Assigning new projects object
					Projects projectNew = new Projects(projectNumber, projectName, buildingType, projectStreetNumber, projectStreetName,
							projectSuburbName, erfNumber, projectFee, ammountPaidToDate, deadline, architectNew, contractorNew,
					  		customerNew, toBeCompleted);
					
					
					open1 = new FileWriter("SearchProjects.txt", true);
					writer1 = new PrintWriter(open1);
					
					String projDetails = (custName + ", " + custSurname + ", " + custEmail + ", " + custTelNumber
							+ ", " + custStreetNumber + ", " + custStreetName + ", " + contractorName + ", " + contractorSurname
							+ ", " + contractorEmail + ", " + contractorTelNumber + ", " + contractorStreetNumber 
							+ ", " + contractorStreetName + ", " + architectName + ", " + architectSurname + ", " + architectEmail
							+ ", " + architectTelNumber + ", " + architectStreetNumber + ", " + architectStreetName
							+ ", " + projectNumber + ", " + buildingType + ", " + projectStreetNumber + ", " + projectStreetName
							+ ", " + projectSuburbName + ", " + erfNumber + ", " + projectFee + ", " + ammountPaidToDate
							+ ", " + deadline + ", " + projectName + ", " + toBeCompleted + "\n");
					
					writer1.write(projDetails);
					writer1.flush();
					
					open = new FileWriter("NewProjects.txt", true);
					writer = new PrintWriter(open);
									
					writer.write(projectNew.toString());
					writer.flush();
					
					// Displaying created project to user with 'toString' method
					System.out.println(projectNew.toString());
			}
								
				catch (InputMismatchException e) {
					
					System.out.println("Error, please try again.");
					
				}
				
				catch (IOException e) {
				
					System.out.println("File not found.");
					e.printStackTrace();
				}
			}
		
		// Update project information menu
		else if (menuChoice == 2) {
				
			ArrayList<Projects> listOfProjects = Projects.getProjectsArrayList(); 
			
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
					System.out.println("Please enter the new deadline for the project(eg. dd-mm-yyyy): ");
					String newDate = keyboard.nextLine();
					selectedProject.setDeadline(newDate);  // assigning new date to object deadline
					
					System.out.println(selectedProject.getDeadline());
				}
				catch(InputMismatchException e) {
					
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
					
					// Displaying finance info to user
					System.out.println(selectedProject.getFinances());
				}
				catch(InputMismatchException e) {
					
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
					
					System.out.println("Please enter the surname of the new contractor: ");
					String newSurname = keyboard.next().trim();
					selectedProject.contractor.setSurname(newSurname);
					
					System.out.println("Please enter their email address: ");
					String newEmail = keyboard.next().trim();
					selectedProject.contractor.setEmail(newEmail);
					
					System.out.println("Please enter their cellphone number: ");
					long newTelNumber = keyboard.nextLong();
					selectedProject.contractor.setNumber(newTelNumber);
					
					System.out.println("Please enter the street number of the building contractor's address");
					int newStreetNumber = keyboard.nextInt();
					selectedProject.contractor.setStreetNumber(newStreetNumber);
					
					System.out.println("Please enter the street name of the building contractor's address: ");
					String newStreetName = keyboard.next().trim();
					selectedProject.contractor.setStreetName(newStreetName);
					
				}
				catch(InputMismatchException e) {
					
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
				// Opening file to write completed projects to
				open = new FileWriter("ComplpetedProjects.txt", true);
				writer = new PrintWriter(open);		               
				// Calling on array list method to create list of projects
				ArrayList<Projects> projectList = Projects.getProjectsArrayList();
				
				// Creating project object from user input 
				Projects completedProject = projectList.get(numComplete - 1);
										
				String projectCompleteDate = formattingDate.format(today); // adding completion date to project
				completedProject.setProjectCompleteDate(projectCompleteDate);
				// Informing user project marked complete
				System.out.println(completedProject.toString());
				System.out.println("Project has been marked complete.");
				System.out.println();
				System.out.println(completedProject.getInvoice()); // Generating invoice
				// Writing project to text file for completed projects
				writer.write(completedProject.toString());
				writer.flush();
					
				}
			
			catch (IOException e) {
				
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
				catch (IndexOutOfBoundsException e) {
				
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
			ArrayList<Projects> searchProject = Projects.getProjectsArrayList();
			// Displaying info
			System.out.println(searchProject.toString());
			
		}
		// View projects that are overdue menu
		else if (menuChoice == 6){
			// Creating project list
			ArrayList<Projects> projList = Projects.getProjectsArrayList();
			// Looping over list to get project dates	
			for (Projects fileLine : projList) {
				// Getting project date deadline	
				String projDate = fileLine.getDeadline();
				// Changing info from string to type date in order to compare dates
				Date date;
				try {
					date = formattingDate.parse(projDate);
				// Checking for overdue projects
				if (date.before(today)) {
					
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
		
			System.out.println("Please enter a correct option and try again. Goodbye");
		}	
	}
}	
// https://www.youtube.com/watch?v=_9BgM9c8mIo, Number format
// stackoverflow.com/questions/35990394/eclipse-error-cannot-make-a-static-reference-to-a-non-static-field	
// https://stackoverflow.com/questions/5050170/how-do-i-get-a-date-without-time-in-java	
// https://stackoverflow.com/questions/7877529/java-string-scanner-input-does-not-wait-for-info-moves-directly-to-next-stateme	
// https://stackoverflow.com/questions/26448352/counting-the-number-of-lines-in-a-text-file-java
// https://stackoverflow.com/questions/24816853/comparing-string-date-with-todays-date		

