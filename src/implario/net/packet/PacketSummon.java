package implario.net.packet;

import implario.net.Packet;
import implario.util.ManualByteUnzip;
import implario.util.ManualByteZip;

public class PacketSummon extends Packet {
	
	private String player, server;
	
	public PacketSummon() {
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
}
