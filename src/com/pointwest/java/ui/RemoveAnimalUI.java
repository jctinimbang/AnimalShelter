package com.pointwest.java.ui;

import com.pointwest.java.data.Animal;
import com.pointwest.java.data.Shelter;
import com.pointwest.java.manager.AnimalShelterManager;
import com.pointwest.java.manager.RemoveAnimalManager;
import com.pointwest.java.util.Constants;

public class RemoveAnimalUI extends AbstractUI {
	public int displayRemoveAnimalForm() {
		String tempInput = "";
		tempInput = verifyInputFields("Please enter the reference ID of the animal to remove:",
				Constants.REGEX_NUMBERS_ONLY,
				Constants.INDICATOR_RESPONSE + Constants.ERROR_INVALID_INPUT + Constants.MESSAGE_NUMBERS_ONLY);

		return Integer.parseInt(tempInput);
	}
	
	public void displayRemoveAnimalNotification(Shelter shelter, int animalRefID) {
		boolean isRemove = false;
		Animal animal = null;
		
		AnimalShelterManager animalShelterManager = new AnimalShelterManager();
		RemoveAnimalManager removeAnimalManager = new RemoveAnimalManager();
		animal = animalShelterManager.manageFindAnimalFromShelter(shelter, animalRefID);
		isRemove = removeAnimalManager.manageRemoveAnimalFromShelter(shelter, animal);
		if(isRemove == true) {
			System.out.println(Constants.INDICATOR_RESPONSE + "Successful: The animal is now removed.");
		} else {
			System.out.println(Constants.INDICATOR_RESPONSE + "Fail: Animal ID not found.");
		}
		
	}
}
