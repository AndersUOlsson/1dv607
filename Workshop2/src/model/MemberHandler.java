package model;

import java.io.IOException;
import java.util.ArrayList;

import view.Console;

public class MemberHandler {
	
	Console consloe = new Console();
	public ArrayList<Member> members = new ArrayList<Member>();
	
	
	public void option(int choice) throws IOException {
		switch(choice) {
			case 1: createMember(); break;
			case 4: loadToXMLFile(); break;
		}
	}
	
	/**
	 * Create new members and adding them in the array list member.
	 * @return	A member of class member.
	 */
	private void createMember() {
		
		consloe.createMemberWindow();
	
		Controller scan = new Controller();
		Member member;
		int personalNumber = 0;
		String name = null;
		
		name = scan.stringInput();
		personalNumber = scan.intInput();
		member = new Member(name, personalNumber);
		this.members.add(member);
	}
	
	private void loadToXMLFile() throws IOException {
		
		ThejollypirateDAO DAO = new ThejollypirateDAO();
		MemberList memberList = new MemberList();
		
//		Load in all the members from XML to arrayList memberList.
		for(int i = 0; i < DAO.loadMembersFromXml().getMembers().size(); i++) {
			this.members.add(DAO.loadMembersFromXml().getMembers().get(i));
		}
		
		memberList.setMembers(this.members);
		
		DAO.writeMembersToXml(memberList);
		
		
		consloe.saveMemberWindow();
	}
}
