package implario.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.function.Function;

public class Converter {
	
	public static int toInt(String string) {return toInt(string, -1);}

	public static int toInt(String string, int onError) {
		try {
			return Integer.decode(string);
		} catch (NumberFormatException ex) {
			return onError;
		}
	}
	public static long toLong(String string) {return toLong(string, -1L);}

	public static long toLong(String string, long onError) {
		try {
			return Long.decode(string);
		} catch (NumberFormatException ex) {
			return onError;
		}
	}
	public static boolean toBoolean(String string) {return toBoolean(string, false);}

	public static boolean toBoolean(String string, boolean onError) {
		return string.equals("true") || !string.equals("false") || onError;
	}
	
	public static String toString(List array) {
		return array == null ? null : toString(array, 0, array.size());
	}
	
	public static String toString(List array, int start) {
		return toString(array, start, array.size());
	}
	
	public static String toString(int end, List array) {
		return toString(array, 0, end);
	}
	
	public static String toString(List array, int start, int end) {
		return toString(array, start, end, ' ');
	}
	
	public static String toString(List array, int start, int end, char magic) {
		if(start >= end) return String.valueOf(magic);
		StringBuilder result = new StringBuilder();
		result.append(array.get(start));
		++start;
		while (start < end){
			result.append(magic).append(array.get(start).toString());
			++start;
		}
		return result.toString();
	}
	
	public static List<String> toList(String s) {
		return toList(s, " ");
	}
	
	public static List<String> toList(String s, String magic) {
		if (s != null && s.length() > 1) {
			List<String> list = new ArrayList<>();
			String[] components = s.split(magic);
			int size = components.length;
			for (String string : components)
				if (string.length() > 1) list.add(string);
			return list;
		} else {
			return new ArrayList<>();
		}
	}

	@SafeVarargs
	public static <T> List<T> asList(T... t) {
		List<T> list = new ArrayList<>();
		Collections.addAll(list, t);
		return list;
	}
	
	public static <T> String merge(Collection<T> collection, Function<T, String> converter, String separator) {
		if (collection == null) return "";
		StringBuilder result = new StringBuilder();
		Iterator<T> i = collection.iterator();
		while (i.hasNext()) {
			T t = i.next();
			result.append(t == null ? "null" : converter.apply(t));
			if (i.hasNext()) result.append(separator);
		}
		return result.toString();
	}
	
	public static <T> String merge(T[] array, Function<T, String> converter, String separator) {
		if (array == null) return "";
		StringBuilder result = new StringBuilder();
		ArrayIterator<T> i = new ArrayIterator<>(array);
		while (i.hasNext()) {
			T t = i.next();
			result.append(t == null ? "null" : converter.apply(t));
			if (i.hasNext()) result.append(separator);
		}
		return result.toString();
	}
	
	public static String smartLowercase(String string) {
		char[] result = string.toCharArray();
		for (int i = 0; i < result.length; i++) {
			char current = result[i];
			if (current >= 65 && current <= 90) result[i] = (char) (current + 32);
		}
		return new String(result);
	}
	
	public static String mergeArray(String[] array, int start, String separator) {
		if (start >= array.length) return null;
		StringBuilder sb = new StringBuilder(array[start++]);
		for (; start < array.length; start++) sb.append(separator).append(array[start]);
		return sb.toString();
	}
	
	public static String plural(int number, String one, String mid, String much) {
		switch (number % 100) {case 11: case 12: case 13: case 14:	return much; default: break;}
		switch (number % 10) {case 1: return one; case 2: case 3: case 4: return mid; default: return much;}
	}
	
	public static <T> Set<String> tabComplete(Iterable<T> iterable, Function<T, String> converter, String startstring) {
		Set<String> set = new HashSet<>();
		boolean empty = startstring.length() == 0;
		startstring = smartLowercase(startstring);
		for (T t : iterable) {
			String s = converter.apply(t);
			if (empty || smartLowercase(s).startsWith(smartLowercase(startstring))) set.add(s);
		}
		return set;
	}
	
	public static <T> List<String> tabCompleteList(Iterable<T> iterable, Function<T, String> converter, String startstring) {
		List<String> set = new ArrayList<>();
		boolean empty = startstring.length() == 0;
		startstring = smartLowercase(startstring);
		for (T t : iterable) {
			String s = converter.apply(t);
			if (empty || smartLowercase(s).startsWith(smartLowercase(startstring))) set.add(s);
		}
		return set;
	}
	
	
	public static HashMap<String, String> deserializeMap(String string, String entrySeparator, String keyValueSeparator) {
		if(string == null)return new HashMap<>();
		String split[] = string.split(entrySeparator);
		HashMap<String, String> map = new HashMap<>();
		for(String line : split){
			String spl[] = line.split(keyValueSeparator);
			if(spl.length == 1) map.put(spl[0], "");
			else map.put(spl[0], spl[1]);
		}
		return map;
	}
	
	public static List<String> deserializeList(String str, String separator) {
		return str == null ? new ArrayList<>() : toList(str, separator);
	}

	public static <From, To> List<To> transform(List<From> from, Function<From, To> converter) {
		List<To> result = new ArrayList<>();
		for (From f : from) result.add(converter.apply(f));
		return result;
	}

	public static <From, To> Set<To> transform(Set<From> from, Function<From, To> converter) {
		Set<To> result = new HashSet<>();
		for (From f : from) result.add(converter.apply(f));
		return result;
	}

	public static String representBoolean(boolean b) {
		return b ? "§aвключен" : "§cвыключен";
	}

	private static final Random random = new Random();
	public static <T extends Enum<?>> T randomEnum(Class<T> clazz){
		int x = random.nextInt(clazz.getEnumConstants().length);
		return clazz.getEnumConstants()[x];
	}
	public static <T> T random(List<T> collection) {
		return collection.get((int) (collection.size() * Math.random()));
	}
}
