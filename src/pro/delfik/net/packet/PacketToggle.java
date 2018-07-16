package pro.delfik.net.packet;

import pro.delfik.net.Packet;

public class PacketToggle extends Packet {
	
	private final String player, setting;
	
	public PacketToggle(String type) {
		super("toggle");
		String[] parameters = type.split("\\?");
		player = parameters[0];
		setting = parameters[1];
	}
	
	public PacketToggle(String player, String setting) {
		super("toggle");
		this.player = player;
		this.setting = setting;
	}
	
	@Override
	protected String encode() {
		return player + '?' + setting;
	}
	
	public enum Setting {
		IPBOUND,
		PMDISABLED
	}
}
