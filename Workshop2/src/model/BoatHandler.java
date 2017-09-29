package model;

public class BoatHandler {
	public static void addBoat(Member m, Boat.Type t, double l) {
		Boat b = new Boat(t, l);
		// m.addBoat(b);
	}
	public static void removeBoat(Member m, int index) {
		//m.getBoats().remove(index);
	}
	public static void updateBoat(Member m, int index, Boat.Type t, double l) {
		//m.getBoats.get(index).setLength(l);
		//m.getBoats.get(index).setType(t);
	}
}
