package com.pointwest.java.ui;

import java.util.List;
import java.util.Map;

import com.pointwest.java.data.Shelter;
import com.pointwest.java.manager.AnimalShelterManager;
import com.pointwest.java.util.Constants;

public class AnimalShelterPageUI extends AbstractUI implements MainMenuInterface {

	@Override
	public void displayWelcomeMessage(String name) {
		String welcomeMessage = buildRepeatedString(" ", 5) + (Constants.MESSAGE_WELCOME + " " + name + "!");
		System.out.println(buildRepeatedString("-", welcomeMessage.length() + 10));
		System.out.println(welcomeMessage);
		System.out.println(buildRepeatedString("-", welcomeMessage.length() + 10));

	}

	public String displayHeaderMessage(Map<String, Shelter> shelterMap, Shelter shelter, String shelterName) {
		AnimalShelterManager animalShelterManager = new AnimalShelterManager();
		String status = "";
		
		shelter = shelterMap.get(shelterName);
		status = animalShelterManager.checkShelterStatus(shelter);

		if (Constants.STRING_FULL.equalsIgnoreCase(status)) {
			System.out.print("The " + shelterName + " is " + status.toLowerCase());
			System.out.println(".The capacity of the shelter to handle the " + shelter.getType() + "s is " + shelter.getCapacity());
		} else if(Constants.STRING_EMPTY.equalsIgnoreCase(status)) {
			System.out.println("The " + shelterName + " is " + status.toLowerCase());
		}
		System.out.println(Constants.MESSAGE_PLEASE_SELECT_OPTION);

		return status;
	}

	
	public String displayOptions(Shelter shelter, String status) {
		AnimalShelterManager animalShelterManager = new AnimalShelterManager();
		String option = "";
		String keywordOption = "";
		List<String> menuOptions = animalShelterManager.manageAnimalMenuOptions(shelter, status);
		
		displayOptionMenuTemplate(menuOptions);
		option = manageSelectedOption(menuOptions);
		keywordOption = animalShelterManager.processKeywordOption(option);
		return keywordOption;
	}

}
