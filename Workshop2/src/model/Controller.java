package model;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class Controller {
	

	
	
	public int intInput() {
		Scanner scan = null;
		int input = 0;
		
		try {
			scan = new Scanner(System.in);
			input = scan.nextInt();
		}
		catch(NoSuchElementException e) {
			System.out.print("Enter a number, not a letter");
			input = intInput();
			
		}
		return input;
	}
	
	
	public String stringInput() {
		Scanner scan = null;
		String input = null;
		
		try {
			scan = new Scanner(System.in);
			input = scan.nextLine();
		}
		catch(NoSuchElementException e) {
			System.out.print("Enter a letter, not a number");
			input = stringInput();
			
		}
		return input;
	}	
}
