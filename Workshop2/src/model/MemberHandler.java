package model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import view.Console;
import view.IOController;

public class MemberHandler {
	
	//Console consloe = new Console();
	ThejollypirateDAO DAO = new ThejollypirateDAO();
	MemberList memberList = new MemberList();
	private boolean nullIndicator = true;
	
	public MemberHandler() throws IOException {
		// get members from XML
		loadMembers();
	}	
	
	
	/**
	 * Create new members and adding them in the array list member.
	 * @return	A member of class member.
	 * @throws IOException 
	 */
	public void createMember(String name, String personalNumber) throws IOException {
		
		int memberID = DAO.findMemberID();
		
		Member member = new Member(name, personalNumber, memberID);
		this.memberList.getMembers().add(member);
		DAO.writeMembersToXml(memberList);
	}
	
	/**
	 * Delete a member from the XML file by giving the member ID.
	 * @throws IOException for XML read and write.
	 */
	public void deleteMember(int numberIDtoDelete) throws IOException {
		
		 
		for(int i = 0; i < memberList.getMembers().size(); i++) {
			if(memberList.getMembers().get(i).getMemberID() == numberIDtoDelete) {
				memberList.deleteMember(i);
			}
		} 
		 
		DAO.writeMembersToXml(memberList);
	}
	
	public void updateName(int id, String name) throws IOException  {
		for (Member m: memberList.getMembers()) {
			if (m.getMemberID() == id) {
				m.setName(name);
			}
		}
		DAO.writeMembersToXml(memberList);
	}
	public void updatePersonalNumber(int id, String number) throws IOException  {
		for (Member m: memberList.getMembers()) {
			if (m.getMemberID() == id) {
				m.setPersonalNumber(number);
			}
		}
		DAO.writeMembersToXml(memberList);
	}
	
	
	/**
	 * Load all the new created members to XML file (SAVE).
	 * @throws IOException 
	 */
	private  void loadMembers() throws IOException {
		
		this.memberList = DAO.loadMembersFromXml();
		
	}

	public List<Member> getMembers() {
		return this.memberList.getMembers();
	}
	
	
	public void addBoat(int memberID, Boat.Type type, int length) throws IOException  {
		for (Member m: memberList.getMembers()) {
			if (m.getMemberID() == memberID) {
				BoatHandler.addBoat(m, type, length);
			}
		}
		DAO.writeMembersToXml(memberList);
	}
	
	public void saveMember() throws IOException 
	{
		DAO.writeMembersToXml(memberList);
	}

}
