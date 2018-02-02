package com.pointwest.java.manager;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.pointwest.java.data.Animal;
import com.pointwest.java.data.Shelter;
import com.pointwest.java.util.Constants;

public class AnimalShelterManager {

	public List<String> manageAnimalMenuOptions(Shelter shelter, String status) {
		List<String> menuOptions = new ArrayList<String>();
		String shelterType = shelter.getType();
		String addAnimal = Constants.STRING_ADD + " a " + shelterType;
		String feedAnimal = Constants.STRING_FEED_SELECTED + shelterType;
		String removeAnimal = Constants.STRING_REMOVE + " a " + shelterType;
		String viewAllAnimal = Constants.STRING_VIEW_ALL + " " + shelterType + "s";
		String goBackToPage = Constants.STRING_GO_BACK_TO_HOMEPAGE;
		switch (status) {
		case Constants.STRING_FULL:
			menuOptions.add(feedAnimal);
			menuOptions.add(removeAnimal);
			menuOptions.add(viewAllAnimal);
			break;
		case Constants.STRING_EMPTY:
			menuOptions.add(addAnimal);
			break;
		default:
			menuOptions.add(addAnimal);
			menuOptions.add(feedAnimal);
			menuOptions.add(removeAnimal);
			menuOptions.add(viewAllAnimal);
			break;
		}
		menuOptions.add(goBackToPage);
		return menuOptions;

	}

	public String processKeywordOption(String option) {
		String keyword = "";
		for (String possibleOption : Constants.ARRAY_LIST_OPTIONS) {
			if (option.contains(possibleOption)) {
				keyword = possibleOption;
				break;
			}
		}
		return keyword;
	}

	public List<String> manageHomeMenuOptions(Set<String> options, String status) {
		List<String> menuOptions = null;
		if (!(Constants.STRING_EXIT.equalsIgnoreCase(status))) {
			menuOptions = new ArrayList<String>();
			for (String option : options) {
				menuOptions.add(option);
			}

			if (!(Constants.STRING_EMPTY.equalsIgnoreCase(status))) {
				menuOptions.add(Constants.STRING_VIEW_ALL_ANIMALS);
			}
			menuOptions.add(Constants.STRING_EXIT);
		}
		return menuOptions;

	}

	public String checkShelterStatus(Shelter shelter) {
		String status = Constants.STRING_OK;

		if (shelter.getAnimalCount() <= 0) {
			status = Constants.STRING_EMPTY;
		} else if (shelter.getAnimalCount() == shelter.getCapacity()) {
			status = Constants.STRING_FULL;
		}

		return status;
	}

	public String checkOverallShelterStatus(Map<String, Shelter> shelterMap) {
		String tempValue = "";
		String storedTempValue = "";
		String tempStatus = "";
		boolean isDifferentStatus = true;

		for (String key : shelterMap.keySet()) {
			tempValue = checkShelterStatus(shelterMap.get(key));
			if ("".equals(storedTempValue)) {
				storedTempValue = tempValue;
			} else if (!(storedTempValue.equals(tempValue))) {
				isDifferentStatus = false;
			}
		}

		if (isDifferentStatus == false) {
			tempStatus = Constants.STRING_OK;
		} else {
			tempStatus = storedTempValue;
		}

		return tempStatus;
	}

	public Animal manageFindAnimalFromShelter(Shelter shelter, int animalRefID) {
		Animal animal = null;
		Animal tempAnimal = null;
		List<Animal> animalList = shelter.getAnimalList();
		Iterator<Animal> iterator = animalList.iterator();
		while (iterator.hasNext()) {
			tempAnimal = iterator.next();
			if (tempAnimal.getId() == animalRefID) {
				animal = tempAnimal;
				break;
			}
		}

		return animal;
	}

	public boolean manageFeedAnimalFromShelter(Shelter shelter, Animal animal) {
		boolean isFed = false;
		List<Animal> animalList = shelter.getAnimalList();

		for (Animal tempAnimal : animalList) {
			if (tempAnimal.equals(animal)) {
				isFed = true;
				break;
			}
		}
		return isFed;

	}
}
