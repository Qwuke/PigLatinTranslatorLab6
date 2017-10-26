/*
 * @author Tristan Mortimer
 * 
 * A short pig latin translator I made for my Grand Circus lab 6
 * 
 */

package net.qwuke;

import java.util.Scanner;

public class PigLatinTranslator {
	
	
	
	public static String translate(String input) {
		//Method for starting off translating the input by initially breaking up the input into a string array
		String[] dividedInput = input.split("\\s+");
		
		//This is where the bulk of translating goes on where we examine individual words and work from there
		for(String e:dividedInput) {
			System.out.println(e);
			
		}
		
		return "translated input";
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String valid = " "; // String for validating whether or not to continue based on y or n
		System.out.println("Welcome to the Pig Latin Translator");

		do {
			//First we validate user input
			System.out.println("Enter a line to be translated: ");
			//method to handle 
			
			
			
			translate(sc.nextLine());//Input handling line
			System.out.println();
			System.out.println("Continue? Type y to continue or n to end the program");
			valid = sc.nextLine();
			while (!(valid.equals("y") || valid.equals("Y") || valid.equals("n") || valid.equals("N"))) {
				System.out.println("That wasn't a valid input! Type y to continue or n to stop");
				valid = sc.nextLine();
			}
		} while (valid.equals("y") || valid.equals("Y")); // If y, rerun the program
		sc.close();
	}
	
}