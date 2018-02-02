package com.pointwest.java.main;

import java.util.HashMap;

import java.util.Map;

import com.pointwest.java.data.Animal;
import com.pointwest.java.data.Shelter;
import com.pointwest.java.ui.AddAnimalUI;
import com.pointwest.java.ui.AnimalInfoUI;
import com.pointwest.java.ui.ExitPageUI;
import com.pointwest.java.ui.FeedAnimalUI;
import com.pointwest.java.ui.HomePageUI;
import com.pointwest.java.ui.RemoveAnimalUI;
import com.pointwest.java.ui.AnimalShelterPageUI;
import com.pointwest.java.util.Constants;

public class AnimalShelterMain {
	public static void main(String[] args) {
		ExitPageUI exitPage = null;
		String homePageOption = "";
		Map<String, Shelter> shelterMap = new HashMap<String, Shelter>();

		for (String animal : Constants.ARRAY_AVAILABLE_ANIMALS) {
			doPopulateShelterInMap(shelterMap, animal, Constants.SHELTER_CAPACITY);
		}

		do {
			homePageOption = doHomePage(shelterMap);
			switch (homePageOption) {
			case Constants.STRING_EXIT: // Exit the program
				break;
			case Constants.STRING_VIEW_ALL_ANIMALS:
				doIntroduceAllAnimals(shelterMap);
				break;
			default:
				doAnimalShelterPage(shelterMap, homePageOption);
				break;
			}

		} while (homePageOption != Constants.STRING_EXIT);
		exitPage = new ExitPageUI(); // exit page
		exitPage.displayExitMessage();

	}

	// put the shelters along with name & capacity in a map
	private static void doPopulateShelterInMap(Map<String, Shelter> shelterMap, String animalName, int capacity) {
		Shelter shelter = new Shelter();
		shelter.setCapacity(capacity);
		shelter.setType(animalName);
		shelterMap.put(animalName + Constants.STRING_SHELTER, shelter);
	}

	// go to Home Page
	private static String doHomePage(Map<String, Shelter> shelterMap) {
		HomePageUI homePageUI = new HomePageUI();
		homePageUI.displayWelcomeMessage(Constants.SHELTER_NAME);
		String status = homePageUI.displayHeaderMessage(shelterMap); // get status of the shelter
		String homePageOption = homePageUI.displayOptions(shelterMap, status);
		return homePageOption;

	}

	// go introduce all animals in different shelter
	private static void doIntroduceAllAnimals(Map<String, Shelter> shelterMap) {
		AnimalInfoUI animalInfoPage = new AnimalInfoUI();
		animalInfoPage.introduceAnimalsInTheShelter(shelterMap);
	}

	// go to animal shelter page
	private static void doAnimalShelterPage(Map<String, Shelter> shelterMap, String shelterType) {
		AnimalShelterPageUI animalShelterPageUI = new AnimalShelterPageUI();
		Shelter shelter = shelterMap.get(shelterType);
		String shelterPageOption = "";
		do {
			animalShelterPageUI.displayWelcomeMessage(shelterType);
			String status = animalShelterPageUI.displayHeaderMessage(shelterMap, shelter, shelterType);
			shelterPageOption = animalShelterPageUI.displayOptions(shelter, status);
			switch (shelterPageOption) {
			case Constants.STRING_ADD:
				doAddAnimal(shelter);
				break;
			case Constants.STRING_VIEW_ALL:
				doIntroduceAnimals(shelter);
				break;
			case Constants.STRING_REMOVE:
				doRemoveAnimal(shelter);
				break;
			case Constants.STRING_FEED_SELECTED:
				doFeedAnimal(shelter);
				break;
			default:
				shelterPageOption = Constants.STRING_GO_BACK_TO_HOMEPAGE;
				break;
			}

		} while (shelterPageOption != Constants.STRING_GO_BACK_TO_HOMEPAGE);

	}

	// go introduce animals in a shelter
	private static void doIntroduceAnimals(Shelter shelter) {
		AnimalInfoUI animalInfoPage = new AnimalInfoUI();
		animalInfoPage.introduceAnimalsInTheShelter(shelter.getAnimalList(), shelter.getType());
	}

	// go to add animal menu page
	private static void doAddAnimal(Shelter shelter) {
		AddAnimalUI addAnimalPage = new AddAnimalUI();
		Animal animal = null;
		animal = addAnimalPage.setAnimalInfoFields(shelter);
		addAnimalPage.displaySuccessAddAnimal(shelter, animal);
	}

	// go to remove animal page
	private static void doRemoveAnimal(Shelter shelter) {
		AnimalInfoUI animalInfoPage = new AnimalInfoUI();
		RemoveAnimalUI removeAnimalPage = new RemoveAnimalUI();
		int animalRefID = 0;

		animalInfoPage.displayListAnimalsInShelter(shelter.getAnimalList());
		animalRefID = removeAnimalPage.displayRemoveAnimalForm();
		removeAnimalPage.displayRemoveAnimalNotification(shelter, animalRefID);
	}

	// do feed an animal
	private static void doFeedAnimal(Shelter shelter) {
		AnimalInfoUI animalInfoPage = new AnimalInfoUI();
		FeedAnimalUI feedAnimalUI = new FeedAnimalUI();
		int animalRefID = 0;
		animalInfoPage.displayListAnimalsInShelter(shelter.getAnimalList());
		animalRefID = feedAnimalUI.displayFeedAnimalForm();
		feedAnimalUI.displayFeedAnimalNotification(shelter, animalRefID);
	}
}
