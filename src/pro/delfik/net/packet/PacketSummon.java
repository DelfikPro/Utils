package pro.delfik.net.packet;

import pro.delfik.net.Packet;
import pro.delfik.util.ByteUnzip;
import pro.delfik.util.ByteZip;

public class PacketSummon extends Packet {
	
	private final String player, server;
	
	public PacketSummon(ByteUnzip unzip) {
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
	protected ByteZip encode() {
		return new ByteZip().add(player).add(server);
	}
}
