package view;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class IOController {
	
	
	
	
	public int intInput() {
		return intInput("");
	}
	public int intInput(String text) {
		Scanner scan = null;
		int input = 0;
		
		try {
			System.out.print("\n" + text + ">");
			scan = new Scanner(System.in);
			input = scan.nextInt();
		}
		catch(NoSuchElementException e) {
			System.out.print("Enter a number, not a letter.");
			input = intInput(text);
			
		}
		return input;
	}
	
	
	public String stringInput() {
		return stringInput("");
	}
	public String stringInput(String text) {
		Scanner scan = null;
		String input = null;
		
		try {
			System.out.print(text + ">");
			scan = new Scanner(System.in);
			input = scan.nextLine();
		}
		catch(NoSuchElementException e) {
			System.out.print("Enter a letter, not a number.");
			input = stringInput(text);
			
		}
		return input;
	}	
}
