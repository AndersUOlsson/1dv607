package view;

import java.io.IOException;

import model.Controller;
import model.MemberHandler;

public class Console {
	
	public void welcomeWindow() throws IOException {
		
		Controller userInput = new Controller();
		MemberHandler user = new MemberHandler();
		
		
		System.out.println("Welcome to The jolly pirate\n"
				+ "press enter to start program");
		
		 do{
			System.out.println("\nWhat do u like to do ?"
					+ "\nCreate user press 1"
					+ "\nEdit user press   2" 
					+ "\nDelete user press 3 "
					+ "\nLoad to XML press 4");
			
			//The user input for the main menu option.
			int choice  = userInput.intInput();
			user.option(choice);
			
		 } while(true);
			
			
	}
	
	
	public void deleteMemberWindow() {
		System.out.print("What is the memberID of the member"
				+ "you want to delete? \n");
		
	}

	public void createMemberWindow() {
		
		System.out.print("Add member information!"
				+ "\nName and personal number \n");
	}
	
	public void saveMemberWindow() {
		System.out.println("\nYour members have been saved.");
	}
	

	
	
}
