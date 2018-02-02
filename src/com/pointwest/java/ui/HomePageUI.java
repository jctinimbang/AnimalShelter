package com.pointwest.java.ui;

import java.util.List;
import java.util.Map;

import com.pointwest.java.data.Shelter;
import com.pointwest.java.manager.AnimalShelterManager;
import com.pointwest.java.util.Constants;

public class HomePageUI extends AbstractUI implements MainMenuInterface {

	@Override
	public void displayWelcomeMessage(String name) {
		String welcomeMessage = buildRepeatedString(" ", 5) + (Constants.MESSAGE_WELCOME + " " + name
				+ Constants.STRING_APOSTROHE_S + " " + Constants.STRING_ANIMAL_SHELTER);
		System.out.println(buildRepeatedString("-", welcomeMessage.length() + 10));
		System.out.println(welcomeMessage);
		System.out.println(buildRepeatedString("-", welcomeMessage.length() + 10));

	}


	public String displayHeaderMessage(Map<String, Shelter> shelterMap) {
		AnimalShelterManager animalShelterManager = new AnimalShelterManager();
		String status = "";
		status = animalShelterManager.checkOverallShelterStatus(shelterMap);
		
		if(Constants.STRING_FULL.equalsIgnoreCase(status)) {
			//exit if all shelters is full
//			System.out.println(Constants.NOTIF_FULL_ALL_SHELTER + ".");
//			status = Constants.STRING_EXIT;
//			
//			// asking first if want to exit if all shelters is full
			displayFullCapacityNotif();
			String choice = manageSelectedOption(Constants.ARRAY_YES_NO);
			if (choice == Constants.STRING_NO) {
				status = Constants.STRING_EXIT;
			}
			
		} else {
			System.out.println(Constants.QUESTION_WHAT_SHELTER_TO_VISIT);
		}
		
		return status;
	}


	public String displayOptions(Map<String, Shelter> shelterMap, String status) {
		if(Constants.STRING_EXIT.equals(status)) {
			return status;
		}
		AnimalShelterManager animalShelterManager = new AnimalShelterManager();
		String option = "";
		List<String> menuOptions = animalShelterManager.manageHomeMenuOptions(shelterMap.keySet(),status);
		
		displayOptionMenuTemplate(menuOptions);
		option = manageSelectedOption(menuOptions);

		return option;
		
	}

	
	private void displayFullCapacityNotif() {
		System.out.println(Constants.NOTIF_FULL_ALL_SHELTER + Constants.NOTIF_CANNOT_ACCEPT_ADDITIONAL_ANIMAL
				+ Constants.NOTIF_CONTINUE);
		displayOptionMenuTemplate(Constants.ARRAY_YES_NO);
	}
}
