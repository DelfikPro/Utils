package implario.util;

import java.security.SecureRandom;

public class StringUtils {

	public static final char[] allChars = "1234567890qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM_".toCharArray();

	public static boolean contains(String s, char[] c) {
		for (char a : s.toCharArray()) if (contains(c, a)) return true;
		return false;
	}

	public static boolean contains(char[] a, char c) {
		for (char b : a) if (b == c) return true;
		return false;
	}

	public static boolean contains(String s, char c) {
		return contains(s.toCharArray(), c);
	}

	public static boolean unContains(String s, char[] c) {
		for (char b : s.toCharArray()) if (!contains(c, b)) return true;
		return false;
	}

	private static final String ALPHABET = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ-_";
	private static final SecureRandom RANDOM = new SecureRandom();

	public static String random(int length) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < length; ++i) {
			sb.append(ALPHABET.charAt(RANDOM.nextInt(ALPHABET.length())));
		}
		return sb.toString();
	}

	public static String plural(long number, String one, String couple, String much) {
		switch ((int) (number % 100)) {
			case 11:
			case 12:
			case 13:
			case 14:
				return much;
			default:
				break;
		}
		switch ((int) (number % 10)) {
			case 1:
				return one;
			case 2:
			case 3:
			case 4:
				return couple;
			default:
				return much;
		}
	}

}
