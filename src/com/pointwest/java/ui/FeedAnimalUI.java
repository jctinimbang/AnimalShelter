package com.pointwest.java.ui;

import com.pointwest.java.data.Animal;
import com.pointwest.java.data.Shelter;
import com.pointwest.java.manager.AnimalShelterManager;
import com.pointwest.java.util.Constants;

public class FeedAnimalUI extends AbstractUI {
	public int displayFeedAnimalForm() {
		String tempInput = "";
		tempInput = verifyInputFields("Please enter the reference ID of which animal is to feed:",
				Constants.REGEX_NUMBERS_ONLY,
				Constants.INDICATOR_RESPONSE + Constants.ERROR_INVALID_INPUT + Constants.MESSAGE_NUMBERS_ONLY);

		return Integer.parseInt(tempInput);
	}
	
	public void displayFeedAnimalNotification(Shelter shelter, int animalRefID) {
		boolean isFed = false;
		Animal animal = null;
		
		AnimalShelterManager animalShelterManager = new AnimalShelterManager();
		animal = animalShelterManager.manageFindAnimalFromShelter(shelter, animalRefID);
		isFed = animalShelterManager.manageFeedAnimalFromShelter(shelter, animal);
		if(isFed == true) {
			System.out.println(animal.getName() + " :" + animal.getfeedResponse());
		} else {
			System.out.println(Constants.INDICATOR_RESPONSE + "Fail: Animal ID not found.");
		}
		
	}
}
