package pro.delfik.net.packet;

import pro.delfik.net.Packet;

public class PacketInit extends Packet{
	private final String server;

	public PacketInit(String server){
		super("init");
		this.server = server;
	}

	@Override
	protected String encode() {
		return server;
	}
}
