package view;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import model.Member;
import model.MemberHandler;

public class Console {
	private IOController userInput;
	private MemberHandler user;
	public Console() throws IOException {
		// init these things
		userInput = new IOController();
		user = new MemberHandler();
	}
	public void welcomeWindow() throws IOException, InterruptedException {
		
		int choice;
		
		System.out.println("Welcome to The jolly pirate\n");
		
		
		 do{
			System.out.print("\nWhat do u like to do?\n"
					+ "1. Create new member\n"
					+ "2. Change/Add information about member\n"
					+ "3. Delete a member\n"
					+ "4. Quit");
			
			//The user input for the main menu option.
			choice  = userInput.intInput();
			 switch(choice) {
				 case 1: createMemberWindow(); break;
				 case 2: changeMemberWindow(); break;
				 case 3: deleteMemberWindow(); break;
			 }
			
		 } while(choice != 4);
			
		System.out.print("System shutdown ");
		for(int i = 0; i < 5; i++) {
			System.out.print(".");
			Thread.sleep(500);
		}
	}
	
	
	
	public void deleteMemberWindow() throws IOException {
		System.out.print("\nWhat is the ID of the member you want to delete? \n");
		int numberIDtoDelete = userInput.intInput();
		user.deleteMember(numberIDtoDelete);
	}

	public void createMemberWindow() throws IOException {
		System.out.println("\nAdd member information.");
		String name = userInput.stringInput("Name");
		int personalNumber = userInput.intInput("ID number");
		user.createMember(name, personalNumber);
	}
	
	public void changeMemberWindow() throws IOException {
		compactList(user.getMembers());
		System.out.print("\nWhat is the memberID of the member you want to change?");
		
		int memberID = userInput.intInput();
		
		int userChoice;
		do {
			System.out.print("\nWhat do you like to change ?\n"
					+ "1. name?\n"
					+ "2. Personal number?\n"
					+ "3. Boat information?\n"
					+ "4. Done, go back.");
			userChoice = userInput.intInput();
			if (userChoice == 1) {
				String newName = userInput.stringInput("New name");
				user.updateName(memberID, newName);
			} else if (userChoice == 2) {
				int newNumber = userInput.intInput("New personal number");
				user.updatePersonalNumber(memberID, newNumber);
			}
		} while (userChoice != 4);
	}
	
	public void optionChangeMemberWindow() {
	
	}
	
	
	public void compactList(List<Member> members) {
		System.out.printf("%-4s %-30s %-12s %-4s%n%n", "ID", "Name", "P.Number", "Boats");
		for (Member m: members) {
			System.out.printf("%-4d %-30s %-12d %-4d%n", m.getMemberID(), m.getName(), m.getPersonalNumber(), m.getNumberOfBoats());
		}
	}
	
	
}
