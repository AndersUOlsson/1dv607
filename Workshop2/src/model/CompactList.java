
package model;


public class CompactList extends Member {
	
	private int boats;

	public CompactList(String name, int personalNumber, int memberID, int boats) {
		super(name, personalNumber, memberID);
		this.boats = boats;
	}

	public void setNumberOfBoats(int boats) {
		this.boats = boats;
	}
	
	public int getNumberOfBoats() {
		return this.boats;
	}
}
