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

	public static int getPosOfFirstVowel(String word) {
		// where we find vowels in a string for anything not starting with a vowel
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
			} else {
				int i = getPosOfFirstVowel(word);
				// Process for translating words based on the position of the first vowel
				if (i<0) {
					//handling words without any vowels
					translatedWords += (word + " ");
				} else if (i == 0) {
					//Extra handling for words with multiple vowels are the start e.g. 'uuuuu'
					translatedWords += (word + "way ");
				} else if ((word.charAt(i) == 'u') && (word.charAt(i - 1) == 'q')) {
					//Handling for the 'qu' digraph such that it is treated as a consonant
					translatedWords += (word.substring(i + 1) + word.substring(0, i + 1) + "ay ");
				} else {
					//Translation for most words by adding the consonants before the first vowel to the end
					translatedWords += (word.substring(i) + word.substring(0, i) + "ay ");
				}
			}

		}
		//Return the final string of words that has been fully translated in the for loop
		return translatedWords;

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String valid = " "; // String for validating whether or not to continue based on y or n
		System.out.println("Welcome to the Pig Latin Translator");

		do {
			System.out.println("Enter a line to be translated: ");

			System.out.println(translate(sc.nextLine()));// Translate input
			System.out.println();
			System.out.println("Continue? Type y to continue or n to end the program");
			valid = sc.nextLine();
			while (!(valid.equalsIgnoreCase("y") || valid.equalsIgnoreCase("n") )) {
				System.out.println("That wasn't a valid input! Type y to continue or n to stop");
				valid = sc.nextLine();
			}
		} while (valid.equalsIgnoreCase("y")); // If y, rerun the program
		sc.close();
	}

}