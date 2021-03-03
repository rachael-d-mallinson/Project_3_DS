package morse_code_tree;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MorseCodeTree {
	/**
	 * Builds a binary tree from an input file containing letters and morse code translation
	 * @param scanner: Reads the input file
	 * @param root: The root of the tree
	 * @return: The root of the tree after the tree has been created
	 */
	public static MorseNode buildMorseCodeTree(Scanner scanner, MorseNode root) {
		// While scanner has more to read
		while(scanner.hasNextLine()) {
			// Create a pointer node
			MorseNode current = root;
			// Split the label from the morse code
			String morseLine = scanner.nextLine();
			String symbol = morseLine.substring(1);
			String temp = morseLine.substring(0, 1);
			char label = temp.charAt(0);
			// Iterate through the morse code 
			for (int i = 0; i < symbol.length(); i++) {
				// Branch left for a dot
				if (symbol.charAt(i) == '.') {
					if (current.left == null) {
						// If no node create new node
						if (i < symbol.length() - 1) {
							current.left = new MorseNode();
							current = current.left;
						// If end of string is reached place label and code into node
						} else {
							current.left = new MorseNode(label, symbol);
						}
					} else {
						// If a node exists but the end of the string has not been reached continue
						if (i < symbol.length() - 1) {
							current = current.left;
						// If end of string has been reached place label and code into node
						} else {
							current.left.label = label;
							current.left.mCode = symbol;
						}
					}
				} else if (symbol.charAt(i) == '-') {
					if (current.right == null) {
						if (i < symbol.length() - 1) {
							current.right = new MorseNode();
							current = current.right;
						} else {
							current.right = new MorseNode(label, symbol);
						}
					} else {
						if (i < symbol.length() - 1) {
							current = current.right;
						} else {
							current.right.label = label;
							current.right.mCode = symbol;
						}
					}
				}
			}
		}
		return root;		
	}
	
	/** 
	 * Encodes a message from English into Morse code
	 * @param currentChar: current character to search the binary tree for
	 * @param root: root of the binary tree
	 */
	private static void encode(char currentChar, MorseNode root) {
		//base case	
		if (root != null) {
			//if the character matches the label, print the MorseCode
			if (currentChar == root.label) {
				System.out.print(root.mCode + " ");
				

			}
			//recursively call the method with Left and Right children
			encode(currentChar, root.left);
			encode(currentChar, root.right);
		}
	}
	
	/**
	 * wrapper method for encode method
	 * @param message: message to encode into MorseCode
	 * @param root: root of binary tree to search
	 */
	public static void encode(String message, MorseNode root) {
		//make the message lower case, so that it will always be read
		message = message.toLowerCase();
		
		//call the method for every letter in the message
		for(int index = 0; index < message.length(); index++) {
			char currentChar = message.charAt(index);
			encode(currentChar, root);
		}
		System.out.println();
	
	}
	
	/**
	 * Translates a letter in Morse code to English
	 * @param code: A letter in morse code
	 * @param root: The root of the binary tree
	 */
	private static void decoder(String code, MorseNode root) {
		// base case
		if (root != null) {
			// if the argument code matches the code in the node, print the label
			if (code.equals(root.mCode)) {
				System.out.print(root.label);
			}
			// recursively call the method with Left and Right children
			decoder(code, root.left);
			decoder(code, root.right);
		}
	}
	
	/**
	 * Wrapper method for decoder method
	 * @param message: A morse code string with space as the delimiter
	 * @param root: The root of the binary tree
	 */
	public static void decode(String message, MorseNode root) {
		// Create a list of strings split at the delimiter (space)
		List<String> morseMessage = Arrays.asList(message.split(" "));
		// Loop through the list and translate each code
		for (int i = 0; i < morseMessage.size(); i ++) {
			decoder(morseMessage.get(i), root);
		}
		System.out.println();
	}
	
}
