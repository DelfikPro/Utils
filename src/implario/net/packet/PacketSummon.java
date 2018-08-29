package implario.net.packet;

import implario.net.Packet;
import implario.util.ManualByteUnzip;
import implario.util.ManualByteZip;

public class PacketSummon extends Packet {
	
	private final String player, server;
	
	public PacketSummon(ManualByteUnzip unzip) {
		player = unzip.getString();
		server = unzip.getString();
	}
	
	public PacketSummon(String player, String server) {
		this.player = player;
		this.server = server;
	}
	
	public String getPlayer() {
		return player;
	}
	
	public String getServer() {
		return server;
	}
	
	@Override
	protected ManualByteZip encode() {
		return new ManualByteZip().add(player).add(server);
	}
}
