package com.maker.utils;

import java.util.UUID;

public class Common {
	
	public static String getUUID() {
		String uuid = UUID.randomUUID().toString();
		return uuid.replaceAll("-", "");
	}

}
