package com.pointwest.java.ui;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;


abstract class AbstractUI {
	String manageSelectedOption(List<String> options) {
		Scanner sc = new Scanner(System.in);
		String tempOption = ""; 
		String optionName = "";
		int selectedOption = 0;
		boolean isOptionCorrect = false;
		do {
			System.out.print("Enter choice: ");
			tempOption = sc.nextLine().trim();
			System.out.println(buildRepeatedString("-", 25));
			if (tempOption.matches("[0-9]+")) {
				selectedOption = Integer.parseInt(tempOption);
				if (selectedOption > 0 && selectedOption <= (options.size())) {
					isOptionCorrect = true;
					optionName = options.get(selectedOption - 1);
				}
			}
			if (!isOptionCorrect) {
				System.out.println("-> Invalid Input.Please input number ranging from 1 - " 
				+ options.size() + " only.");
			}

		} while (!isOptionCorrect);
		
		return optionName;
	}
	
	String manageSelectedOption(String[] options) {
		Scanner sc = new Scanner(System.in);
		String tempOption = ""; 
		String optionName = "";
		int selectedOption = 0;
		boolean isOptionCorrect = false;
		do {
			System.out.print("Enter choice: ");
			tempOption = sc.nextLine().trim();
			System.out.println(buildRepeatedString("-", 25));
			if (tempOption.matches("[0-9]+")) {
				selectedOption = Integer.parseInt(tempOption);
				if (selectedOption > 0 && selectedOption <= (options.length)) {
					isOptionCorrect = true;
					optionName = options[selectedOption - 1];
				}
			}
			if (!isOptionCorrect) {
				System.out
						.println("-> Invalid Input.Please input number ranging from 1 - " + options.length + " only.");
			}

		} while (!isOptionCorrect);
		
		return optionName;
	}
	
	protected void displayOptionMenuTemplate(List<String> choices) {
		Iterator<String> iterate = choices.iterator();
		String template = "";
		int i = 0;

		while (iterate.hasNext()) {
			template += "[" + (i + 1) + "] " + iterate.next() + "\n";
			i++;
		}
		System.out.println(template);
		
	}
	
	protected void displayOptionMenuTemplate(String[] choices) {
		String template = "";
	
		for (int i = 0; i < choices.length; i++) {
			template += "[" + (i + 1) + "] " + choices[i] + "\n";
		}
		System.out.println(template);
	}
	
	String verifyInputFields(String fieldName, String regexStr, String errorStatement) {
		Scanner sc = new Scanner(System.in);
		String input = "";
		boolean isCorrect = false;
		
		do {
			System.out.print(fieldName);
			input = sc.nextLine();
			if (input.matches(regexStr)) {
				isCorrect = true;
			}
			else {
				System.out.println(errorStatement);
			}
			
		} while (!isCorrect);
		return input;
	}
	
	String buildRepeatedString(String string, int count) {
		String buildString = "";
		
		for (int i = 0; i < count; i++) {
			buildString += string;
		}
		
		return buildString;
	}
	
	
}
