
import controller.Diplay;

import view.StartGUI;


public class main {

	public static void main(String[] args) {
		
		StartGUI welcome = new StartGUI();
		Diplay display = new Diplay();
		welcome.welcomeWindow();
		welcome.option();
		display.options();
		
		

	}

}
