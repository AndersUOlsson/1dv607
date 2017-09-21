package view;

import model.Controller;
import model.MemberHandler;

public class Console {
	
	public void welcomeWindow() {
		
		Controller userInput = new Controller();
		MemberHandler user = new MemberHandler();
		
		
		System.out.println("Welcome to The jolly pirate"
				+ "\nWhat do u like to do ?"
				+ "\nCreate user press 1"
				+ "\nEdit user press   2" 
				+ "\nDelete user press 3 ");
		
		
		
		//The user input for the main menu option.
		int choice  = userInput.intInput();
		if(choice == 1) {
			createMemberWindow();
			user.option(choice);
		}
		else {
			System.out.print("Hello");
		}
		
		
	
		
		
	}
	
	public void createMemberWindow() {
		
		System.out.print("Add member information!"
				+ "\nName and personal number \n");
	}
	


	
}
