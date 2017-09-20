package controller;

import java.util.Scanner;

public class Diplay {
	
	Scanner scanner = null;
	int userInput = 0;
	
	
	public void options() {
		
		
		try {
		    scanner = new Scanner(System.in);
		    userInput = scanner.nextInt();
		    
		    switch(userInput) {
			case 1: createMember();
		
		    }
		}
		finally {
		    if(scanner!=null)
		        scanner.close();
		}
	
		
		
		
	}
	
	public void createMember() {System.out.print("HEllo");}
	
	

}
