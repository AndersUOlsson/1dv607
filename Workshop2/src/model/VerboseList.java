
package model;

import java.util.ArrayList;

public class VerboseList extends Member {

	ArrayList<String> boats = new ArrayList<String>();
	String name;
	int personalNumber;
	int memberID;
	
	public VerboseList(String name, int personalNumber, int memberID, ArrayList<String> boats) {
		
		super(name, personalNumber, memberID);
		this.boats = boats;
	}

	@Override
	public void setName(String name) {
		// TODO Auto-generated method stub
		super.setName(name);
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return super.getName();
	}

	@Override
	public void setPersonalNumber(int personalNumber) {
		// TODO Auto-generated method stub
		super.setPersonalNumber(personalNumber);
	}

	@Override
	public int getPersonalNumber() {
		// TODO Auto-generated method stub
		return super.getPersonalNumber();
	}

	@Override
	public void setMemberID(int memberID) {
		// TODO Auto-generated method stub
		super.setMemberID(memberID);
	}

	@Override
	public int getMemberID() {
		// TODO Auto-generated method stub
		return super.getMemberID();
	}
	
	public void setBoatInformation(ArrayList<String> boats) {
		this.boats = boats;
	}
	
	public ArrayList<String> getBoatInformation() {
		return this.boats;
	}
}
