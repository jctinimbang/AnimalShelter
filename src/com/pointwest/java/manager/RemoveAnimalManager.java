package com.pointwest.java.manager;

import java.util.List;

import com.pointwest.java.data.Animal;
import com.pointwest.java.data.Shelter;

public class RemoveAnimalManager {
	public boolean manageRemoveAnimalFromShelter(Shelter shelter, Animal animal) {
		boolean isRemove = false;
		List<Animal> animalList = shelter.getAnimalList();
		isRemove = animalList.remove(animal);

		if (isRemove) {
			shelter.setAnimalList(animalList);
		}

		return isRemove;
	}
}
