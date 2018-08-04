package pro.delfik.net.packet;

import pro.delfik.net.Packet;
import pro.delfik.util.ByteUnzip;
import pro.delfik.util.ByteZip;
import pro.delfik.util.Converter;

public class PacketSSU extends Packet{
	
	private final String server;
	private final int online;

	public PacketSSU(ByteUnzip unzip) {
		this.server = unzip.getString();
		this.online = unzip.getInt();
	}

	public PacketSSU(String server, int online){
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
	protected ByteZip encode() {
		return new ByteZip().add(server).add(online);
	}
}
