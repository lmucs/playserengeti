package com.playserengeti.util;

public class ArgumentChecker {

	public static void assertArgument(boolean req, String message) {
		if (!req) {
			throw new IllegalArgumentException(message);
		}
	}
	
}
