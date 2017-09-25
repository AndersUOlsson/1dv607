
package model;

import java.util.ArrayList;

public class VerboseList extends Member {

	ArrayList<String> boats = new ArrayList<String>();
	String name;
	int personalNumber;
	int memberID;
	
	public VerboseList(String name, int personalNumber, int memberID, ArrayList<String> boats) {
		
		super(name, personalNumber, memberID);
		CompactList compact = new CompactList(name,personalNumber ,memberID, boats.size());
		
		this.boats = boats;
	}

	public void setBoatInformation(String boats) {
		this.boats.add(boats);
	}
	
	public ArrayList<String> getBoatInformation() {
		return this.boats;
	}
}
