package model;

public class Boat {
	// variables
	private double length;
	private Type type;
	
	public enum Type {
		SAILBOAT, MOTORSAILER, CANOE, OTHER
	}
	
	public Boat(Type t, double l) {
		this.setType(t);
		this.setLength(l);
	}
	public Boat() {
		// for marshalling. setting dummy values here so you cant init a faulty object
		this.setType(Type.OTHER);
		this.setLength(3);
	}
	
	
	public Type getType() {
		return this.type;
	}
	public double getLength() {
		return this.length;
	}
	public void setType(Type type) {
		this.type = type; // dont need error checking here, right?
		                  // should be impossible to send in an erroneous Type
	}
	public void setLength(double len) {
		if (len >= 1) { // arbitrary min length
			this.length = len;
		}
	}
}
