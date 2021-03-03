# Project_3_DS

Morse Code Translator - March 2021 - Intro to Data Structures with Java Project 3B

TEAM SIX

Rachael Mallinson
Sofia Nikas
Aleksis Martin

Language: Java

Design Explanation

We build the binary tree from an input file with letters from the English alphabet and their Morse code translations. To build the tree, we trace the path from the root to the letter’s place in the tree by reading each character in the morse code and branching left for a dot and right for a dash, creating new nodes along the way to keep the connection from the root to each leaf.
Then the user can input a message, either in English or in Morse code, and the translator will output the translation into the console for them. Then they can start over if they wish, or they can quit the program.
In the Encoder method, we take in a single character and then the root of the tree. We recursively search the whole tree for the Node with the label that matches that character, and then print out the MorseCode that is also stored within the same Node. Then, we utilize a wrapper method that changes every letter in the input message to lowercase, and  encodes the whole message by calling the previous encode method with each of the characters in the message. The result is the translation of the message in MorseCode.
The decode method takes a string of morse code from user input and splits the codes into an array by a delimiter (space). For each code in the array we call the decoder method, which recursively searches the binary tree for a match, and then prints the letter stored in that node.

How to use the Morse Code Translator:

1) Launch the program.
2) Choose a Menu option
3) Input the phrase you want translated
4) The Translation will be shown in the console.
5) Try again or quit.
