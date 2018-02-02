package com.pointwest.java.data;

import com.pointwest.java.util.Constants;

public class Parrot extends Animal{

	@Override
	public String getSignatureSound() {
		return Constants.SOUND_PARRROT;
	}

	@Override
	public String getType() {
		return Constants.STRING_PARROT;
	}

	@Override
	public String getfeedResponse() {
		return Constants.FEED_RESPONSE_PARROT;
	}

}
