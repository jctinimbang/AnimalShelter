package com.pointwest.java.ui;


import com.pointwest.java.data.Animal;
import com.pointwest.java.data.Shelter;
import com.pointwest.java.manager.AddAnimalManager;
import com.pointwest.java.util.Constants;

public class AddAnimalUI extends AbstractUI {
	
	public Animal setAnimalInfoFields(Shelter shelter) {
		String tempInput = "";
		Animal animal = null;
		AddAnimalManager addAnimalManager = new AddAnimalManager();
		
		animal = addAnimalManager.manageAnimalType(shelter.getType());
		
		tempInput = verifyInputFields(animal.getType() + "'s Name:", Constants.REGEX_ALPHABET_ONLY, Constants.INDICATOR_RESPONSE 
				+ Constants.ERROR_INVALID_INPUT + Constants.MESSAGE_ALPHABET_ONLY);
		animal.setName(tempInput);
		
		tempInput = verifyInputFields( animal.getType() + "'s Age:", Constants.REGEX_NUMBERS_ONLY, Constants.INDICATOR_RESPONSE 
				+ Constants.ERROR_INVALID_INPUT + Constants.MESSAGE_NUMBERS_ONLY);
		animal.setAge(Integer.parseInt(tempInput));

		System.out.println(animal.getName() + "'s gender:");
		displayOptionMenuTemplate(Constants.ARRAY_MALE_FEMALE);
		tempInput = manageSelectedOption(Constants.ARRAY_MALE_FEMALE);
		animal.setGender(tempInput);
		
		animal.setId(Constants.START_ID + animal.getcount());
		
		return animal;
	}
	
	public void displaySuccessAddAnimal(Shelter shelter, Animal animal) {
		AddAnimalManager addAnimalManager = new AddAnimalManager();
		addAnimalManager.manageAddAnimalToShelter(shelter, animal);
		System.out.println(Constants.INDICATOR_RESPONSE + animal.getName() + " has been added to the shelter with an id: " + animal.getId());
	}
}
