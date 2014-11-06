/*****************************************
 * Test Method for Tree.java 
 * Project 3 
 * CS 360 - Data Structures and Algorithms 
 * 
 * Written by Tarif Haque on 
 * February 15 2013
 *****************************************/

import java.io.*;
import java.util.Scanner;

public class TestTree {
	
	public static void main(String args[ ]) {
		Tree T = new Tree();
		
		System.out.println("1. Read instructions from file.");
		System.out.println("2. Input instructions within program.");
		System.out.print("Select input method: ");
		
		Scanner reader = new Scanner(System.in);
		String selection = reader.next();
		if (selection.equals("1")) runInstructionsFromFile(T);
		else if (selection.equals("2")) allowUserToInputCommands(T);
		else System.out.println("Select a valid input option.");
	}
	
	/* Test that reads instructions input by the user */
	private static void allowUserToInputCommands(Tree T) {
		Scanner in = new Scanner(System.in);
		String userinput = "";
		
		System.out.println("Type \'exit\' to quit.");
		
		while (!userinput.equals("exit")) {
			System.out.print("Enter tree instruction: ");
			userinput = in.next();
			executeInstruction(T, userinput, in);
		}
	}

	/* Test that reads instructions from input.txt */
	private static void runInstructionsFromFile(Tree T) {
		Scanner input = null;
		try { input = new Scanner (new FileReader ("input.txt")); } 
		catch (FileNotFoundException e) {
			System.out.println("Cannot find the input file.");
			System.exit(0);
		}
		
		while (input.hasNext()) {
			String x = input.next().toLowerCase();
			executeInstruction(T, x, input);
		}
	}
		
	/* Given a Tree, String instruction and Scanner, execute the instruction. */
	private static void executeInstruction(Tree T, String x, Scanner input) {
		int param;	
		switch(x) {
			case ("size"):
				System.out.println("Size: " + T.size());
				break;
				
			case ("label"):
				System.out.println("Label: " + T.label());
				break;
			
			case ("replacelabel"):
				param = input.nextInt();
				System.out.println("Replaced label " + T.label() + " with " + param + ".");
				T.replaceLabel(param);
				break;
			
			case ("addleftmostchild"):
				param = input.nextInt();
				System.out.println("Added " + param + " to left most child of " + T.currentNode.label + ".");
				T.addLeftmostChild(param);
				break;
			
			case ("addrightmostchild"):
				param = input.nextInt();
				System.out.println("Added " + param + " to right most child of " + T.currentNode.label + ".");
				T.addRightmostChild(param);
				break;
			
			case ("isroot"):
				System.out.println("Current node is Root: " + T.isRoot());
				break;
			
			case ("isleaf"):
				System.out.println("Current node is Leaf: " + T.isLeaf());
				break;
			
			case ("gotoroot"):
				System.out.println("Went to root node (" + T.root.label + ").");
				T.gotoRoot();
				break;
			
			case ("gotoparent"):
				if (T.currentNode.parent != null) {
					System.out.println("Went to parent (" + T.currentNode.parent.label + 
							") of current node (" + T.currentNode.label + ").");
					T.gotoParent();
				} else {System.out.println("Cannot travel to a null node.");}
				break;
			
			case ("gotoleftmostchild"):
				if (T.currentNode.leftMostChild != null) {
					System.out.println("Went to left most child (" + T.currentNode.leftMostChild.label + 
							") of current node (" + T.currentNode.label + ").");
					T.gotoLeftmostChild();
				} else {System.out.println("Cannot travel to a null node.");}
				break;
				
			case ("gotorightmostchild"):
				if (T.currentNode.rightMostChild != null) {
					System.out.println("Went to right most child (" + T.currentNode.rightMostChild.label + 
							") of current node (" + T.currentNode.label + ").");
					T.gotoRightmostChild();
				} else {System.out.println("Cannot travel to a null node.");}
				break;
			
			case ("gotoleftsibling"):
				if (T.currentNode.leftSibling != null) {
					System.out.println("Went to left sibling (" + T.currentNode.leftSibling.label + 
							") of current node (" + T.currentNode.label + ").");
					T.gotoLeftSibling();
				} else {System.out.println("Cannot travel to a null node.");}
				break;
			
			case ("gotorightsibling"):
				if (T.currentNode.rightSibling != null) {
					System.out.println("Went to right sibling (" + T.currentNode.rightSibling.label + 
							") of current node (" + T.currentNode.label + ").");
					T.gotoRightSibling();
				} else {System.out.println("Cannot travel to a null node.");}
				break;
			
			case ("preorder"):
				T.preOrder();
				break;
			
			case ("postorder"):
				T.postOrder();
				break;
			
			case ("levelorder"):
				T.levelOrder();
				break;
				
			case ("exit"):
				break;
			
			default:
				System.out.println("Did not recognize command: " + x);
	}
}
}