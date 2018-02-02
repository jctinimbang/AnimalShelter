package com.pointwest.java.util;

public interface Constants {
	public static final int SHELTER_CAPACITY = 10;
	public static final int START_ID = 1000;
	
	public static final String SHELTER_NAME = "JC";
	public static final String STRING_DOG = "Dog";
	public static final String STRING_CAT = "Cat";
	public static final String STRING_PARROT = "Parrot";
	public static final String STRING_SHELTER = " Shelter";
	public static final String STRING_FULL = "FULL";
	public static final String STRING_EMPTY = "EMPTY";
	public static final String STRING_EXIT = "EXIT";
	public static final String STRING_YES = "YES";
	public static final String STRING_NO = "NO";
	public static final String STRING_ANIMAL_SHELTER = "Animal" + STRING_SHELTER;
	public static final String STRING_APOSTROHE_S = "'s";
	public static final String STRING_OK = "OK";
	public static final String STRING_FEED_SELECTED = "Feed a selected ";
	public static final String STRING_ADD = "Add";
	public static final String STRING_REMOVE = "Remove";
	public static final String STRING_HOME_PAGE = "Home Page";
	public static final String STRING_GO_BACK_TO_HOMEPAGE = "Go back to " + STRING_HOME_PAGE;
	public static final String STRING_VIEW_ALL = "View all";
	public static final String STRING_ANIMAL = "Animal";
	public static final String STRING_VIEW_ALL_ANIMALS = "View All Animals";
	public static final String SOUND_DOG = "Arf arf arf!";
	public static final String SOUND_CAT = "Meowww";
	public static final String SOUND_PARRROT = "Squawk";
	public static final String FEED_RESPONSE_DOG = "DELICIOUS!";
	public static final String FEED_RESPONSE_CAT = "YUM YUM!";
	public static final String FEED_RESPONSE_PARROT = "I LIKE THIS FOOD!";
	
	public static final String MESSAGE_WELCOME = "Welcome to";
	public static final String MESSAGE_THANK_YOU = "Thank you!";
	public static final String QUESTION_WHAT_SHELTER_TO_VISIT = "What Shelter would you like to visit?";
	public static final String MESSAGE_PLEASE_SELECT_OPTION = "Please select an option:";
	
	public static final String MESSAGE_ALPHABET_ONLY = "Accepts only alphabet characters";
	public static final String MESSAGE_NUMBERS_ONLY =  "Accepts only numeric values";
	
	public static final String HEADER_HOME = "MAIN MENU";
	public static final String HEADER_ADD_ANIMAL = "What animal you are trying to add?";
	public static final String HEADER_INTRODUCE_ANIMAL = "Meet our lovely " + STRING_ANIMAL + " friends!";
	
	public static final String NOTIF_CONTINUE = " Do you want to continue?";
	public static final String NOTIF_EMPTY_SHELTER = "The Shelter is currently empty";
	public static final String NOTIF_FULL_ALL_SHELTER = "All Shelters is now full. ";
	public static final String NOTIF_CANNOT_ACCEPT_ADDITIONAL_ANIMAL = "We can no longer be able to accept a new animal.";
	
	public static final String EXIT_SYSTEM_NOTIFICATION = MESSAGE_THANK_YOU + ". Terminating the system";
	public static final String REGEX_ALPHABET_ONLY = "^[A-z ]+$";
	public static final String REGEX_NUMBERS_ONLY = "[0-9]+";
	
	public static final String INDICATOR_RESPONSE = "-> ";
	public static final String ERROR_INVALID_INPUT = "Invalid Input. ";
	
	public static final String [] ARRAY_AVAILABLE_ANIMALS = {STRING_DOG, STRING_CAT, STRING_PARROT};
	public static final String [] ARRAY_LIST_OPTIONS = {STRING_ADD, STRING_FEED_SELECTED, STRING_REMOVE, STRING_VIEW_ALL, STRING_GO_BACK_TO_HOMEPAGE};
	public static final String [] ARRAY_ANIMAL_INFO = {"Name", "Age", "Gender"};
	public static final String [] ARRAY_YES_NO = {STRING_YES, STRING_NO};
	public static final String [] ARRAY_MALE_FEMALE  = {"Male", "Female"};
}
