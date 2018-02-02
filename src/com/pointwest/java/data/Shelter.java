package com.pointwest.java.data;

import java.util.ArrayList;
import java.util.List;

public class Shelter {
	private List<Animal> animalList;
	private int animalCount;
	private String type;
	private int capacity;

	public List<Animal> getAnimalList() {
		if (animalList == null) {
			animalList = new ArrayList<Animal>();
		}
		return animalList;
	}

	public void setAnimalList(List<Animal> animalList) {
		this.animalList = animalList;
	}

	public int getAnimalCount() {
		if (animalList == null) {
			animalCount = 0;
		} else {
			animalCount = animalList.size();
		}

		return animalCount;
	}

	public String getType() {
		return type;
	}

	public void setType(String name) {
		this.type = name;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
}
