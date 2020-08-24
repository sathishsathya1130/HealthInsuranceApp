package com.sathish.utils;

public class PwdUtils {

	private static final String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

	public static String generateTempPwd(int count) {
		StringBuilder sb = new StringBuilder();
		while (count-- != 0) {
			int character = (int) (Math.random() * ALPHA_NUMERIC_STRING.length());
			sb.append(ALPHA_NUMERIC_STRING.charAt(character));
		}
		return sb.toString();

	}

}
