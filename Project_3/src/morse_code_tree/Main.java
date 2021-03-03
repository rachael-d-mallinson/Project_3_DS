package morse_code_tree;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) throws IOException {
		//Open input file and scanner to read morse code text file
		FileInputStream inputFile = new FileInputStream("Morse_Code.txt"); 
		Scanner scanner = new Scanner(inputFile);
		
		// Create an empty node to be used as the root of the tree
		MorseNode root = new MorseNode(); 
		// Build the tree from the input file
		MorseCodeTree.buildMorseCodeTree(scanner, root);
		
		// Open a scanner to read user input from the console
		Scanner scnr = new Scanner(System.in);
		
		//Menu for User to Pick
		String UserMenuPrompt = "\n          Welcome to the Morse Code Translator\nPlease Choose your Menu Option by choosing a Number to enter.";
		String UserMenuOptions = " 1. Enter an English message to Translate into Morse code\n 2. Enter a Morse code message to Translate into English\n 3. Quit\nEnter here:";
		boolean systemRunning = true;
		String messageToTranslate = "";
		
		while (systemRunning){
			System.out.println(UserMenuPrompt);		//prints the title of the Translator 
			System.out.println(UserMenuOptions);		//prints the menu options for User
			int userChoice = scnr.nextInt();		//user's input number
			
			if (userChoice == 1) {
				System.out.print("Enter Message here: ");
				StringBuilder message = new StringBuilder();
				while (messageToTranslate.isEmpty()) {
					message.append(scnr.nextLine());
					messageToTranslate = message.toString();
				}
				System.out.print("Translation: ");
				MorseCodeTree.encode(messageToTranslate, root);
				messageToTranslate = "";
			} else if (userChoice == 2) {
				System.out.println("Enter Message here: ");
				StringBuilder message = new StringBuilder();
				while (messageToTranslate.isEmpty()) {
					message.append(scnr.nextLine());
					messageToTranslate = message.toString();
				}
				System.out.print("Translation: ");
				MorseCodeTree.decode(messageToTranslate, root);
				messageToTranslate = "";
			} else if (userChoice == 3) {
				System.out.println("Thank you for using the MorseCode Translator. Goodbye.");
				systemRunning = false;
			} else {
				System.out.println("Please Pick a Menu Option. You'll be redirected.\n");
			}
		}
		
		// Close scanners and input file
		scanner.close();
		scnr.close();
		inputFile.close();
	}
}