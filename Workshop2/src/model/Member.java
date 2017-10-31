package model;

import javax.xml.bind.annotation.XmlElement;
import java.util.ArrayList;
import java.util.List;

public class Member implements IMembers {
	
	//Variables for member.
	private String name;
	private String personalNumber;
	private int memberID;
	
	private List<Boat> boats = new ArrayList<>();
	
	public Member() {
	}
	
	//Constructor.
	public Member(String name, String personalNumber, int MemberID) {
		this.name = name;
		this.personalNumber = personalNumber;
		this.memberID = MemberID;
	}
	
	//Set and get name for member.
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	//Set and get personal number for member.
	public void setPersonalNumber(String personalNumber) {
		this.personalNumber = personalNumber;
	}
	
	public String getPersonalNumber() {
		return this.personalNumber;
	}
	
	//Set and get member id.
	public void setMemberID(int memberID) {
		this.memberID = memberID;
	}
	
	public int getMemberID() {
		return this.memberID;
	}
	
	//Set and get boats information.
	public void addBoat(Boat b) {
		this.boats.add(b);
	}
	
	public List<Boat> getBoats() {
		return this.boats;
	}
	
	public void setBoats(List<Boat> boatsn) {
		this.boats = boatsn;
	}
	
	// Boat stuff
	public int getNumberOfBoats() {
		return this.boats.size();
	}
	
	public void addBoat(Boat.Type t, double l) {
		Boat b = new Boat(t, l);
		this.addBoat(b);
	}
	
	public void removeBoat(int index) {
		boats.remove(index);
	}
	
	public void updateBoat(int index, Boat.Type t, double l) {
		boats.get(index).setLength(l);
		boats.get(index).setType(t);
		
	}
	
}
