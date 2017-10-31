package model;

import java.io.IOException;
import java.util.Iterator;


public class MemberHandler {
	
	ThejollypirateDAO DAO = new ThejollypirateDAO();
	MemberList memberList = new MemberList();
	
	public MemberHandler() throws IOException {
		// get members from XML
		loadMembers();
	}
	
	
	/**
	 * Create new members and adding them in the array list member.
	 *
	 * @throws IOException
	 * @return A member of class member.
	 */
	public void createMember(String name, String personalNumber) throws IOException {
		
		int memberID = DAO.findMemberID();
		Member member = new Member(name, personalNumber, memberID);
		memberList.addMember(member);
		DAO.writeMembersToXml(memberList);
	}
	
	/**
	 * Delete a member from the XML file by giving the member ID.
	 *
	 * @throws IOException for XML read and write.
	 */
	public void deleteMember(int numberIDtoDelete) throws IOException {
		memberList.deleteMember(numberIDtoDelete); // moved to memberlist per "Don't return internal data structures"
		DAO.writeMembersToXml(memberList);
	}
	
	public void updateName(int id, String name) throws IOException {
		memberList.updateName(id, name);
		DAO.writeMembersToXml(memberList);
	}
	
	public void updatePersonalNumber(int id, String number) throws IOException {
		memberList.updatePersonalNumber(id, number);
		DAO.writeMembersToXml(memberList);
	}
	
	/**
	 * Load all the new created members to XML file (SAVE).
	 *
	 * @throws IOException
	 */
	private void loadMembers() throws IOException {
		
		this.memberList = DAO.loadMembersFromXml();
		
	}
	
	public void addBoat(int memberID, Boat.Type type, int length) throws IOException {
		Member m = memberList.getSpecificMember(memberID);
		m.addBoat(type, length);
		
		DAO.writeMembersToXml(memberList);
	}
	
	public void saveMember() throws IOException {
		DAO.writeMembersToXml(memberList);
	}
	
	
	// passing things on
	
	public Iterator<Member> getMemberIterator() {
		return memberList.getMemberIterator();
	}
	
	public Member getSpecificMember(int memberId) {
		return memberList.getSpecificMember(memberId);
	}
	
	
}
