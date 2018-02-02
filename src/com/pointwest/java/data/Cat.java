package com.pointwest.java.data;

import com.pointwest.java.util.Constants;

public class Cat extends Animal {

	@Override
	public String getSignatureSound() {
		return Constants.SOUND_CAT;
	}

	@Override
	public String getType() {
		return Constants.STRING_CAT;
	}

	@Override
	public String getfeedResponse() {
		return Constants.FEED_RESPONSE_CAT;
	}

}
