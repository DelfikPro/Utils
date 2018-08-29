package implario.net.packet;

import implario.net.Packet;
import implario.util.ManualByteUnzip;
import implario.util.ManualByteZip;

public class PacketSSU extends Packet {
	private String server;
	private int online;

	public PacketSSU() {
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
}
