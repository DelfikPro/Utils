package pro.delfik.net.packet;

import pro.delfik.net.Packet;
import pro.delfik.util.Converter;

public class PacketSSU extends Packet{
	private final String server;

	private final int online;

	public PacketSSU(String serialize) {
		super("ssu");
		String split[] = serialize.split("\\?");
		this.server = split[0];
		this.online = Converter.toInt(split[1]);
	}

	public PacketSSU(String server, int online){
		super("ssu");
		this.server = server;
		this.online = online;
	}

	public String getServer() {
		return server;
	}

	public int getOnline() {
		return online;
	}

	@Override
	protected String encode() {
		return server + "?" + online;
	}
}
