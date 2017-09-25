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
			case 2: changeMember(); break;
			case 3: deleteMember(); break;
		}
	}
	
	/**
	 * Create new members and adding them in the array list member.
	 * @return	A member of class member.
	 * @throws IOException 
	 */
	private void createMember() throws IOException {
		
		consloe.createMemberWindow();
		
		
		loadMembers();
		
		int personalNumber = 0;
		String name = null;
		int memberID = DAO.findMemberID();
		
//		Input data from administrator.
		name = scan.stringInput();
		personalNumber = scan.intInput();
		
		Member member = new Member(name, personalNumber, memberID);
		this.members.add(member);
		memberList.setMembers(members);
		DAO.writeMembersToXml(memberList);
	}
	
	/**
	 * Delete a member from the XML file by giving the member ID.
	 * @throws IOException for XML read and write.
	 */
	private void deleteMember() throws IOException {
		
		consloe.deleteMemberWindow();
		this.memberList = DAO.loadMembersFromXml();
		
		int numberIDtoDelete = scan.intInput();
		 
		for(int i = 0; i < memberList.getMembers().size(); i++) {
			if(memberList.getMembers().get(i).getMemberID() == numberIDtoDelete) {
				memberList.deleteMember(i);
			}
		} 
		 
		DAO.writeMembersToXml(memberList);
	}
	
	private void changeMember() {}
	
	/**
	 * Load all the new created members to XML file (SAVE).
	 * @throws IOException 
	 */
	private  void loadMembers() throws IOException {
		
		this.memberList = DAO.loadMembersFromXml();
		 
//		Load in all the members from XML to arrayList memberList.
		try{
			if(nullIndicator) {
				nullIndicator = false;
				for(int i = 0; i < this.memberList.getMembers().size(); i++) {
					this.members.add(this.memberList.getMembers().get(i));		
				}
			}
			
		}
		catch(NullPointerException e) {}
	}


}
