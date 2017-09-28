package view;

import java.io.IOException;

import model.Controller;
import model.MemberHandler;

public class Console {
	
	public void welcomeWindow() throws IOException, InterruptedException {
		
		Controller userInput = new Controller();
		MemberHandler user = new MemberHandler();
		int choice;
		
		System.out.println("Welcome to The jolly pirate\n");
		
		
		 do{
			System.out.print("\nWhat do u like to do?\n"
					+ "1. Create new member\n"
					+ "2. Change/Add information about member\n" 
					+ "3. Delete a member\n"
					+ "4. Quit\n"
					+ "Input: ");
			
			//The user input for the main menu option.
			choice  = userInput.intInput();
			user.option(choice);
			
		 } while(choice != 4);
			
		System.out.print("System shoutdown ");
		for(int i = 0; i < 5; i++) {
			System.out.print(".");
			Thread.sleep(500);
		}
	}
	
	
	public void deleteMemberWindow() {
		System.out.print("\nWhat is the memberID of the member you want to delete? \n");
		
	}

	public void createMemberWindow() {
		
		System.out.println("\nAdd member information, name and personal number");
	}
	
	public void saveMemberWindow() {
		System.out.println("\nYour members have been saved.");
	}
	
	public void changeMemberWindow() {
		
		System.out.print("\nWhat is the memberID of the member you want to change?\n"
				+ "Input: ");
	}
	
	public void optionChangeMemberWindow() {
		
		System.out.print("\nWhat do you like to change ?\n"
				+ "1. name?\n"
				+ "2. Personal number?\n"
				+ "3. Boat information?\n"
				+ "Input: ");
	}
	

	
	
}
