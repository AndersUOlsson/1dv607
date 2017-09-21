package view;

import model.Controller;
import model.MemberHandler;

public class Console {
	
	public void welcomeWindow() {
		
		Controller userInput = new Controller();
		MemberHandler user = new MemberHandler();
		
		
		System.out.println("Welcome to The jolly pirate\n"
				+ "press enter to start program");
		
		 do{
			System.out.print("\nWhat do u like to do ?"
					+ "\nCreate user press 1"
					+ "\nEdit user press   2" 
					+ "\nDelete user press 3 "
					+ "\nQuit user press 4 ");
			
			//The user input for the main menu option.
			int choice  = userInput.intInput();
			switch(choice) {
				case 1: createMemberWindow(); break;
				case 2: break;
				case 3: deleteMemberWindow(); break;
			}
			user.option(choice);
		 } while(true);
			
			
	}
	
	
	private void deleteMemberWindow() {
		System.out.print("What is the memberID of the member"
				+ "you want to delete? \n");
		
	}

	public void createMemberWindow() {
		
		System.out.print("Add member information!"
				+ "\nName and personal number \n");
	}
	

	
	
}
