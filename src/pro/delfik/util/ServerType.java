package pro.delfik.util;

public enum ServerType {
	UNKNOWN(""),
	LOBBY("LOBBY"),
	PVP("PVP"),
	SF("SF");

	private final String prefix;

	private ServerType(String prefix){
		this.prefix = prefix;
	}

	public String getPrefix() {
		return prefix;
	}
}
