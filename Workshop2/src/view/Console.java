package view;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import model.Boat;
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
		
		System.out.println("Welcome to The jolly pirate!\n");
		
		
		do {
			System.out.print("\n============================\nWhat do u like to do?\n"
					+ "1. Show verbose list of members and boats\n"
					+ "2. Show compact list of members\n"
					+ "3. Create new member\n"
					+ "4. Change/Add information about member\n"
					+ "5. Delete a member\n"
					+ "6. Quit");
			
			//The user input for the main menu option.
			choice = userInput.intInput();
			switch (choice) {
				case 1:
					verboseList(user.getMembers());
					break;
				case 2:
					compactList(user.getMembers());
					break;
				case 3:
					createMemberWindow();
					break;
				case 4:
					changeMemberWindow();
					break;
				case 5:
					deleteMemberWindow();
					break;
			}
			
		} while (choice != 6);
		
		System.out.print("System shutdown ");
		for (int i = 0; i < 5; i++) {
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
			System.out.print("\nWhat do you like to change ?\n" + "1. name?\n" + "2. Personal number?\n" + "3. Boat information?\n" + "4. Done, go back.");
			userChoice = userInput.intInput();
			if (userChoice == 1) {
				String newName = userInput.stringInput("New name");
				user.updateName(memberID, newName);
			} else if (userChoice == 2) {
				int newNumber = userInput.intInput("New personal number");
				user.updatePersonalNumber(memberID, newNumber);
			} else if (userChoice == 3) {
				// BOAT MENU!!!!!
				int boatChoice;
				do {
					System.out.print("\nWhat about boats?\n" + "1. Add boat\n" + "2. Change boat\n" + "3. Remove boat\n" + "4. Done with boats, go back.");
					boatChoice = userInput.intInput();
					if (boatChoice == 1) {
						// add boat
						
						do {
							System.out.println("Select boat type:\n(1) Sail boat\n(2) Motor sailer\n(3)Canoe/kayak\n(4)Other");
							boatChoice = userInput.intInput();
						} while (boatChoice < 1 || boatChoice > 4);
						
						int boatLength = userInput.intInput("Boat length (in meters)");
						
						// ok we have what we need
						Boat.Type type;
						switch(boatChoice) {
							case 1:
								type = Boat.Type.SAILBOAT; break;
							case 2:
								type = Boat.Type.MOTORSAILER; break;
							case 3:
								type = Boat.Type.CANOE; break;
							case 4:
							default:
								type = Boat.Type.OTHER; break;
						}
						
						user.addBoat(memberID, type, boatLength);
						
					} else if (boatChoice == 2) {
						// change boat
						
					} else if (boatChoice == 3) {
						// delete boat
						
					}
				} while (boatChoice != 4);
			}
		} while (userChoice != 4);
	}
	
	public void optionChangeMemberWindow() {
	
	}
	
	
	public void compactList(List<Member> members) {
		System.out.printf("%-4s %-30s %-12s %-4s%n%n", "ID", "Name", "P.Number", "Boats");
		for (Member m : members) {
			this.printInfo(m);
		}
	}
	
	public void verboseList(List<Member> members) {
		System.out.printf("%-4s %-30s %-12s %-4s%n%n", "ID", "Name", "P.Number", "Boats");
		for (Member m : members) {
			this.printInfo(m); // User info, yas
			// now lets do their boats
			if (m.getBoats().size() >0 )
				System.out.printf("\t\t%-20s %10s%n", "Type", "Length (m)");
			for (model.Boat b : m.getBoats()) {
				System.out.printf("\t\t%-20s %10.0f%n", b.getType().toString(), b.getLength());
			}
		}
	}
	
	public void printInfo(Member m) {
		System.out.printf("%-4d %-30s %-12d %-4d%n", m.getMemberID(), m.getName(), m.getPersonalNumber(), m.getNumberOfBoats());
	}
	
	
}
