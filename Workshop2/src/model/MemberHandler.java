package model;

import java.util.ArrayList;

public class MemberHandler {
	
	public ArrayList<Member> member = new ArrayList<Member>();
	
	public void option(int choice) {
		switch(choice) {
			case 1: member.add(createMember()); break;
		}
	}
	
	/**
	 * Create new members and adding them in the array list member.
	 * @return	A member of class member.
	 */
	private Member createMember() {
		
		Controller scan = new Controller();
		Member member;
		int personalNumber = 0;
		String name = null;
		
		name = scan.stringInput();
		personalNumber = scan.intInput();
		member = new Member(name, personalNumber);
		
		return member;
	}
}
