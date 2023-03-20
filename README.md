# Poised

#Project Management Program

##Description

A project management system for an engineering firm to help them keep track of the projects they are working on.
The program captures information about new projects, if a project name is not provided
when the information is captured, the project is named using the surname of
the customer. For example, a house being built by Mike Tyson would be
called “House Tyson” and an apartment block owned by Jared Goldman
would be called “Apartment Goldman”.

The program stores the following information for each project being worked on and new project being loaded:

* Project Number
* Project Name
* Building being designed. E.g. House, apartment block, store, etc.
* Physical address of the project
* ERF number.
* The total fee being charged for the project.
* The total amount paid to date.
* Deadline for the project.
* The name, telephone number, email address and physical address of the
  architect for the project.
* The name, telephone number, email address and physical address of the
  contractor for the project.
* The name, telephone number, email address and physical address of the
  customer for the project

The user can update information about existing projects as information may need to be
adjusted at different stages throughout the lifecycle of a project. For
example, the deadline might change after a meeting with various
stakeholders.
The user can finalise existing projects. When a project is finalised, the following
happens:
* An invoice is generated for the client. The invoice
contains the customer’s contact details and the total amount that the
customer must still pay. This amount is calculated by subtracting the
total amount paid to date from the total fee for the project. If the
customer has already paid the full fee, an invoice should not be
generated.
* The project should be marked as “finalised” and the completion date
should be added.

The program allows the user to see a list of projects that still need to be completed, a list of projects that 
are past the due date as well as find and select a project by entering either the project number or project
name.

##Database

A database called PoisePMS has been designed, the program reads and writes data about projects and people associated with
projects from the database.

## Program Classes

###Customer Class

The customer class is used for all customer related information regarding projects.
The class has a toString method as well as getters and setters for each of the customer details required for the project.

###Architect Class

The architect class is used for all architect related information regarding projects.
The class has a toString method as well as getters and setters for each of the architect details required for the project.

###Contractor Class

The contractor class is used for all contractor related information regarding projects.
The class has a toString method as well as getters and setters for each of the contractor details required for the project.

###Project Class

The project class is used for all information regarding the projects the company is working on.
In the class attributes it has an attribute of type customer, architect and contractor respectively in order
for the classes to comunicate and share information.
**Methods**
* Basic getters and setters for information.
* toString - displays information in easy to read format.
* Finances - calculates and displays ammount still owed on the project.
* Project details - project information without the information of the customer, architect and contractor.
* Invoice - Generates an invoice when a project is marked complete.
* Array List - Connects to the database and retrieves all projects information on the database and stores it in an array list.
		   Array list is used to retrieve information the user is requesting for specific projects,
		   to search for projects and to view all projects.
 
###Poised

Where the main menu is displayed for user to perform specific operations.
* Load a new project
* Update project information
* Finalize a project
* Find a project
* View all projects
* View projects that are overdue.

##Author

**Name:** JP Geyer
**Email:** jpgeyergit@petalmail.com


