package com.pointwest.java.data;

import com.pointwest.java.util.Constants;

public class Dog extends Animal {

	@Override
	public String getSignatureSound() {
		return Constants.SOUND_DOG;
	}

	@Override
	public String getType() {
		return Constants.STRING_DOG;
	}

	@Override
	public String getfeedResponse() {
		return Constants.FEED_RESPONSE_DOG;
	}

}
