package com.pointwest.java.manager;

import java.util.List;

import com.pointwest.java.data.Animal;
import com.pointwest.java.data.Cat;
import com.pointwest.java.data.Dog;
import com.pointwest.java.data.Parrot;
import com.pointwest.java.data.Shelter;
import com.pointwest.java.util.Constants;

public class AddAnimalManager {
	public Animal manageAnimalType(String type) {
		Animal animal = null;

		switch (type) {
		case Constants.STRING_DOG:
			animal = new Dog();
			break;

		case Constants.STRING_CAT:
			animal = new Cat();
			break;

		case Constants.STRING_PARROT:
			animal = new Parrot();
			break;
		}
		return animal;

	}
	public void manageAddAnimalToShelter(Shelter shelter, Animal animal) {
		List<Animal> animalList = null;
		animalList = shelter.getAnimalList();
		animalList.add(animal);
		shelter.setAnimalList(animalList);
	}
	
	
}
