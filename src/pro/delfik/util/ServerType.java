package pro.delfik.util;

public enum ServerType {
	UNKNOWN,
	LOBBY,
	PVP,
	BW,
	SF;

	public static ServerType getType(String line){
		for(ServerType type : values())
			if(line.startsWith(type.toString()))return type;
		return UNKNOWN;
	}
}
