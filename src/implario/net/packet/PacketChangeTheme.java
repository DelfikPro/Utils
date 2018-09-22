package implario.net.packet;

import implario.net.Packet;

public class PacketChangeTheme extends Packet {
	public boolean dark;
	public String player;
	public PacketChangeTheme() {}
	public PacketChangeTheme(boolean dark, String player) {
		this.dark = dark;
		this.player = player;
	}
}
