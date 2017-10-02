package view;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import model.Boat;
import model.Boat.Type;
import model.BoatHandler;
import model.Member;
import model.MemberHandler;
import model.MemberList;
import model.ThejollypirateDAO;

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
			System.out.print("\n============================\nWhat would you like to do?\n"
					+ "1. Show verbose list of members and boats\n"
					+ "2. Show compact list of members\n"
					+ "3. Show specific user\n"
					+ "4. Create new member\n"
					+ "5. Change/Add information about member\n"					
					+ "6. Delete a member\n"
					+ "7. Quit");
			
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
					viewUser();
					break;
				case 4:
					createMemberWindow();
					break;
				case 5:
					changeMemberWindow();
					break;
				case 6:
					deleteMemberWindow();
					break;
			}
			
		} while (choice != 7);
		
		System.out.print("System shutdown ");
		for (int i = 0; i < 5; i++) {
			System.out.print(".");
			Thread.sleep(500);
		}
	}
	
	
	public void deleteMemberWindow() throws IOException {
		compactList(user.getMembers());
		System.out.print("\nWhat is the ID of the member you want to delete? \n");
		int numberIDtoDelete = userInput.intInput();
		user.deleteMember(numberIDtoDelete);
	}
	
	public void createMemberWindow() throws IOException {
		System.out.println("\nAdd member information.");
		String name = userInput.stringInput("Name");
		String personalNumber = this.inputPersonalNumber();
		user.createMember(name, personalNumber);
	}
	
	public void changeMemberWindow() throws IOException {
		compactList(user.getMembers());
		System.out.print("\nWhat is the memberID of the member you want to change?");
		
		int memberID = userInput.intInput();		
		int userChoice;
		Member member = new Member();						
		for (int i = 0; i < user.getMembers().size(); i++) {
			if (user.getMembers().get(i).getMemberID() == memberID) {
				member = user.getMembers().get(i);															
			}												
		}
		do {
			System.out.print("\nWhat do you like to change ?\n" + "1. name?\n" + "2. Personal number?\n" + "3. Boat information?\n" + "4. Done, go back.");
			userChoice = userInput.intInput();
			if (userChoice == 1) {
				String newName = userInput.stringInput("New name");
				user.updateName(memberID, newName);
			} else if (userChoice == 2) {
				String newNumber = inputPersonalNumber();
				user.updatePersonalNumber(memberID, newNumber);
			} else if (userChoice == 3) {
				// BOAT MENU
				int boatChoice;
				do {
					System.out.print("\nWhat about boats?\n" + "1. Add boat\n" + "2. Change boat details\n" + "3. Remove boat\n" + "4. Done with boats, go back.");
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
						System.out.println("\n" + member.getName() + "'s boats:");
						for (int j = 0; j < member.getBoats().size(); j++)
						{
							System.out.println((j +1) + ". " + member.getBoats().get(j).getType().toString());
						}
						System.out.println("\nWhat is the number of the boat whose details you wish to modify?");
						int boatIndex = userInput.intInput();
						Boat boat = member.getBoats().get(boatIndex -1);
						System.out.println("\n1. Boat Type: " + boat.getType().toString() + "\n2. Boat Length: " + boat.getLength() + "\n\nWhat information would you like to modify?" );
						int infoIndex = userInput.intInput();						
						if (infoIndex == 1)
						{
							System.out.println("\nIndicate new boat type: \n1. Sail Boat \n2. Motor Sailer \n3. Canoe/Kayak \n4. Other");
							int boatType = userInput.intInput();
							if (boatType == 1)
							{
								boat.setType(Type.SAILBOAT);
							}
							else if (boatType == 2)
							{
								boat.setType(Type.MOTORSAILER);
							}
							else if (boatType == 3)
							{
								boat.setType(Type.CANOE);
							}
							else if (boatType == 4)
							{
								boat.setType(Type.OTHER);
							}
						}
						else
						{
							System.out.println("\nIndicate the boat's new length in meters:");
							int boatLength = userInput.intInput();	
							boat.setLength(boatLength);
						}
						user.saveMember();
						
					} else if (boatChoice == 3) {
						// delete boat						
						int boatNum = member.getNumberOfBoats();
						System.out.println(member.getName() + "'s boats: ");
						for (int j = 0; j < member.getBoats().size(); j++)
						{
							System.out.println((j +1) + ". " + member.getBoats().get(j).getType().toString());
						}
						System.out.println("\nWhat is the number of the boat you want to delete?");
						int boatIndex = userInput.intInput();
						BoatHandler.removeBoat(member, boatIndex-1);
						if (boatNum == member.getNumberOfBoats() +1)
						{
							System.out.println("Boat Successfully deleted." + member.getName() + "'s current boats: ");
							for (int j = 0; j < member.getBoats().size(); j++)
							{
								System.out.println((j +1) + ". " + member.getBoats().get(j).getType().toString());
							}
						}
						else
						{
							System.out.println("Error deleting boat.");
						}
						user.saveMember();
					}
				} while (boatChoice != 4);
			}
		} while (userChoice != 4);
	}
	
	public void optionChangeMemberWindow() {
	
	}
	
	
	public void compactList(List<Member> members) {
		System.out.printf("%-4s %-30s %-4s%n%n", "ID", "Name", "Boats");
		for (Member m : members) {
			this.printCompactInfo(m);
		}
	}
	
	public void verboseList(List<Member> members) {
		System.out.printf("%-4s %-30s %-12s %-4s%n%n", "ID", "Name", "P.Number", "Boats");
		for (Member m : members) {
			this.printInfo(m); // User info, yas
			// now lets do their boats
			if (m.getBoats().size() >0 )
				System.out.printf("     %-20s %10s%n", "Type", "Length (m)");
			for (model.Boat b : m.getBoats()) {
				System.out.printf("     %-20s %10.0f%n", b.getType().toString(), b.getLength());
			}
			System.out.println("");
		}
	}
	
	public void printInfo(Member m) {
		System.out.printf("%-4d %-30s %-12s %-4d%n", m.getMemberID(), m.getName(), m.getPersonalNumber(), m.getNumberOfBoats());
	}
	public void printCompactInfo(Member m) {
		System.out.printf("%-4d %-30s %-4d%n", m.getMemberID(), m.getName(), m.getNumberOfBoats());
	}
	
	private void viewUser() {
		compactList(user.getMembers());
		System.out.print("\nWhat is the memberID of the member you want to view?");
		
		int memberID = userInput.intInput();
		for (Member m: user.getMembers()) {
			if (m.getMemberID() == memberID) {
				System.out.printf("%-4s %-30s %-12s %-4s%n%n", "ID", "Name", "P.Number", "Boats");
				printInfo(m);
				if (m.getBoats().size() >0 )
					System.out.printf("     %-20s %10s%n", "Type", "Length (m)");
				for (model.Boat b : m.getBoats()) {
					System.out.printf("     %-20s %10.0f%n", b.getType().toString(), b.getLength());
				}
			}
		}
		
	}
	
	private String inputPersonalNumber() {
		String personalNumber;
		do {
			personalNumber = userInput.stringInput("ID number");
			if (!personalNumber.matches("([0-9]+)")) {
				System.out.println("Numbers only, please!");
			}
		} while (!personalNumber.matches("([0-9]+)"));
		return personalNumber;
	}
	
	
}
