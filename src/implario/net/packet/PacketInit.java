package implario.net.packet;

import implario.net.Packet;
import implario.util.ManualByteUnzip;
import implario.util.ManualByteZip;

public class PacketInit extends Packet {
	private String server;

	public PacketInit(){

	}

	public PacketInit(String server){
		this.server = server;
	}

	public String getServer() {
		return server;
	}
}
