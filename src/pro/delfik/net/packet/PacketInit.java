package pro.delfik.net.packet;

import pro.delfik.net.Packet;
import pro.delfik.util.ByteUnzip;
import pro.delfik.util.ByteZip;

public class PacketInit extends Packet{
	private final String server;

	public PacketInit(ByteUnzip unzip){
		server = unzip.getString();
	}

	public PacketInit(String server){
		this.server = server;
	}

	public String getServer() {
		return server;
	}

	@Override
	protected ByteZip encode() {
		return new ByteZip().add(server);
	}
}
