package implario.net.packet;

import implario.net.Packet;
import implario.util.ManualByteUnzip;
import implario.util.ManualByteZip;

public class PacketInit extends Packet {
	private final String server;

	public PacketInit(ManualByteUnzip unzip){
		server = unzip.getString();
	}

	public PacketInit(String server){
		this.server = server;
	}

	public String getServer() {
		return server;
	}

	@Override
	protected ManualByteZip encode() {
		return new ManualByteZip().add(server);
	}
}
