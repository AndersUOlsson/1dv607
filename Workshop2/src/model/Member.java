package model;

public class Member implements IMembers {
	
	//Variables for member.
	private String name;
	private int personalNumber;
	private int memberID;
	
	public Member(){}

	//Constructor.
	public Member(String name, int personalNumber, int MemberID ) {
		this.name = name;
		this.personalNumber = personalNumber;
		this.memberID = MemberID;
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
