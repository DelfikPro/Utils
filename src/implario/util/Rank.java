package implario.util;

import java.util.HashMap;

public enum Rank {

	DEV("§3[§lDev§3] ", "§3", "Разработчик"),
	ADMIN("§c[§lA§c] ", "§c", "Админ"),
	LMAO("§c[§lA§c] ", "§c", "Админ"),
	IMPLARIO("§8[§lImplario§8] ", "§8", "Implario"),
	KURATOR("§6[§lK§6] ", "§6", "Куратор"),
	ULTIBUILDER("§e[§lB§e+] ", "§e", "Архитектор"),
	SPONSOR("§2[§lM§2++] ", "§b", "Модератор III"),
	WARDEN("§2[§lM§2+] ", "§2", "Модератор II"),
	MODER("§2[§lM§2] ", "§2", "Модератор"),
	RECRUIT("§2[§lR§2] ", "§2", "Модератор-стажёр"),
	BUILDER("§e[§lB§e] ", "§e", "Билдер"),
	YOUTUBE("§c[§f§lY§c§lT§c] ", "§c", "Ютубер"),
	TESTER("§a[§lT§a] ", "§a", "Тестер"),
	VIP("§a[§lV§a] ", "§a", "VIP"),
	PLAYER("", "", "Игрок");

	public static final HashMap<Character, Rank> byChar = new HashMap<>();
	static {for (Rank rank : values()) byChar.put(rank.name().charAt(0), rank);}

	private final String name;
	private String prefix;
	private String nameColor;

	Rank(String prefix, String nameColor, String name) {
		this.name = name;
		this.prefix = prefix;
		this.nameColor = nameColor;
	}

	public String getNameColor() {
		return nameColor;
	}

	public String getPrefix() {
		return prefix;
	}

	public String getName() {
		return name;
	}

	public static Rank decode(String line) {
		if (line == null || line.length() == 0) return PLAYER;
		Rank r = byChar.get(line.charAt(0));
		return r == null ? Rank.PLAYER : r;
	}

	public String toString() {
		return String.valueOf(name().charAt(0));
	}
	
	public String represent() {
		return nameColor + name;
	}

	public byte getByte() {
		return (byte) name().charAt(0);
	}

	public static Rank random() {
		return values()[(int) (values().length * Math.random())];
	}
}
