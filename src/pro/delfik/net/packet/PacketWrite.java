package pro.delfik.net.packet;

import pro.delfik.net.Packet;

import java.util.Base64;

public class PacketWrite extends Packet{
	private final String name, file;

	public PacketWrite(String serialize){
		super("write");
		String split[] = serialize.split("\\?");
		name = split[0];
		file = new String(Base64.getDecoder().decode(split[1]));
	}

	public PacketWrite(String name, String file) {
		super("write");
		this.name = name;
		this.file = file;
	}

	public String getName() {
		return name;
	}

	public String getFile() {
		return file;
	}

	@Override
	protected String encode() {
		return name + "?" + Base64.getEncoder().encodeToString(file.getBytes());
	}
}
