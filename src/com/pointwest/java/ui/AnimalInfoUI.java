package com.pointwest.java.ui;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.pointwest.java.data.Animal;
import com.pointwest.java.data.Shelter;
import com.pointwest.java.util.Constants;

public class AnimalInfoUI {
	public void introduceAnimalsInTheShelter(List<Animal> animalList, String type) {
		Iterator<Animal> iterator = animalList.iterator();
		Animal animal = null;
		
		System.out.println(Constants.HEADER_INTRODUCE_ANIMAL.replace(Constants.STRING_ANIMAL, type));
		while (iterator.hasNext()) {
			animal = iterator.next();
			System.out.println(animal.getId() + ": " + animal.getSignatureSound() + " Hi I'm " + animal.getName()
					+ ", a " + animal.getGender() + " " + animal.getType() + ". My age is " + animal.getAge()
					+ " years old");
		}
	}
	
	public void displayListAnimalsInShelter(List<Animal> animalList) {
		Iterator<Animal> iterator = animalList.iterator();
		Animal animal = null;
		
		System.out.println("---List of animals in the shelter---");
		while (iterator.hasNext()) {
			animal = iterator.next();
			System.out.println("ID: " + animal.getId() + " |Name: " + animal.getName()
					+ " |Type: " + animal.getType() + " |Gender: " + animal.getGender() + " |Age: " + animal.getAge()
					+ " years old");
		}
	}
	
	public void introduceAnimalsInTheShelter(Map<String, Shelter> shelterMap) {
		for (String key : shelterMap.keySet()) {
			Shelter shelter = shelterMap.get(key);
			if(shelter.getAnimalCount() == 0 ) {
				System.out.println("I am sorry but the animals in " + key + " is empty.");
			} else {
				introduceAnimalsInTheShelter(shelter.getAnimalList(), shelter.getType());
			}
		}
	}
}
