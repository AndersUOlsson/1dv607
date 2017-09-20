package model;

public class Member {
	
	//Variables for member.
	String name;
	int personalNumber;
	int memberID;

	//Constructor.
	public Member( ) {
		this.name = "";
		this.personalNumber = 0;
		this.memberID = 0;
	}
	
	//Set and get name for member.
	public void setName(String name) {this.name = name;}
	public String getName() {return this.name;}
	
	//Set and get personal number for member.
	public void setPersonalNumber(int personalNumber) {this.personalNumber = personalNumber;}
	public int getPersonalNumber() {return this.personalNumber;}
	
	//Set and get member id.
	public void setMemberID(int memberID) {this.memberID = memberID;}
	public int getMemberID() {return this.memberID;}
	

}
