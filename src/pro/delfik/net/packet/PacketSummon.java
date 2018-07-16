package pro.delfik.net.packet;

import pro.delfik.net.Packet;

public class PacketSummon extends Packet {
	
	private final String player, server;
	
	public PacketSummon(String type) {
		super("summon");
		String[] parameters = type.split("\\?");
		if (parameters.length < 2) throw new IllegalArgumentException("Invalid packet format");
		player = parameters[0];
		server = parameters[1];
	}
	
	public PacketSummon(String player, String server) {
		super("summon");
		this.player = player;
		this.server = server;
	}
	
	@Override
	protected String encode() {
		return player + '?' + server;
	}
}
