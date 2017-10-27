/*
 * @author Tristan Mortimer
 * 
 * A short pig latin translator I made for my Grand Circus lab 6
 * 
 */

package net.qwuke;

import java.util.Scanner;

public class PigLatinTranslator {

	final static String vowels = "aeiouy";


	public static int posOfFirstVowel(String word) {
		//where we find vowels in a string for anything not starting with a vowel
		for (int index = 0; index < word.length(); index++) {
			if (vowels.contains(String.valueOf(word.charAt(index)))) {
				return index;
			}
		}

		// Index when vowels aren't found
		return -1;
	}
	

	public static String translate(String input) {
		// Method for starting off translating the input by initially breaking up the
		// input into a string array

		// This is where the bulk of translating goes on where we examine individual
		// words and work from there
		String translatedWords = "";

		for (String word : input.toLowerCase().split("\\s+")) {
			char firstChar = Character.toUpperCase(word.charAt(0));
			if (firstChar == 'a' || firstChar == 'e' || firstChar == 'i' || firstChar == 'o' || firstChar == 'u') {
				translatedWords += (word + "way");
			} else if (firstChar == 'q') {
				
			} else {
				int i = posOfFirstVowel(word);
				System.out.print(word.substring(i) + word.substring(0, i) + "ay");
			}

		}

		return translatedWords;

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String valid = " "; // String for validating whether or not to continue based on y or n
		System.out.println("Welcome to the Pig Latin Translator");

		do {
			// First we validate user input
			System.out.println("Enter a line to be translated: ");
			// method to handle

			translate(sc.nextLine());// Input handling line
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