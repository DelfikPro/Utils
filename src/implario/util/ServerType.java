package implario.util;

public enum ServerType {
	UNKNOWN,
	SPLEEF,
	LOBBY,
	TEST,
	PVP,
	BW,
	SF,
	B,
	UHC;

	public static ServerType getType(String line){
		for(ServerType type : values())
			if(line.startsWith(type.toString()))return type;
		return UNKNOWN;
	}
}
