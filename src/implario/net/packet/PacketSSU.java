package implario.net.packet;

import implario.net.Packet;
import implario.util.ManualByteUnzip;
import implario.util.ManualByteZip;

public class PacketSSU extends Packet {
	
	private final String server;
	private final int online;

	public PacketSSU(ManualByteUnzip unzip) {
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
	protected ManualByteZip encode() {
		return new ManualByteZip().add(server).add(online);
	}
}
