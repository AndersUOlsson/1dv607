package model;

import java.io.IOException;
import java.util.ArrayList;

import view.Console;

public class MemberHandler {
	
	Console consloe = new Console();
	public ArrayList<Member> members = new ArrayList<Member>();
	ThejollypirateDAO DAO = new ThejollypirateDAO();
	MemberList memberList = new MemberList();
	private boolean nullIndicator = true;
	Controller scan = new Controller();
	
	
	public void option(int choice) throws IOException {
		switch(choice) {
			case 1: createMember(); break;
			case 3: deleteMember(); break;
			case 4: loadToXMLFile(); break;
		}
	}
	
	/**
	 * Create new members and adding them in the array list member.
	 * @return	A member of class member.
	 */
	private void createMember() {
		
		consloe.createMemberWindow();
		
		
		Member member;
		int personalNumber = 0;
		String name = null;
		int memberID = DAO.findMemberID();
	
		
		name = scan.stringInput();
		personalNumber = scan.intInput();
		member = new Member(name, personalNumber, memberID);
		this.members.add(member);
	}
	
	private void deleteMember() throws IOException {
		
		consloe.deleteMemberWindow();
		MemberList memberList = new MemberList();
		memberList = DAO.loadMembersFromXml();
		int numberIDtoDelete = scan.intInput();
		 
		for(int i = 0; i < memberList.getMembers().size(); i++) {
			if(memberList.getMembers().get(i).getMemberID() == numberIDtoDelete) {
				memberList.deleteMember(i);
			}
		} 
		 
		DAO.writeMembersToXml(memberList);
		
		
		
	}
	
	/**
	 * Load all the new created members to XML file (SAVE).
	 * @throws IOException 
	 */
	private void loadToXMLFile() throws IOException {
		
		 
//		Load in all the members from XML to arrayList memberList.
		try{
			if(nullIndicator) {
				nullIndicator = false;
				for(int i = 0; i < DAO.loadMembersFromXml().getMembers().size(); i++) {
					this.members.add(DAO.loadMembersFromXml().getMembers().get(i));		
				}
			}
			
		}
		catch(NullPointerException e) {}
		
			

		
		memberList.setMembers(this.members);
		DAO.writeMembersToXml(memberList);
		
		
		consloe.saveMemberWindow();
	}

}
