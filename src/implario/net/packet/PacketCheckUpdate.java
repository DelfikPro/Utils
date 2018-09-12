package implario.net.packet;

import implario.net.Packet;

public class PacketCheckUpdate extends Packet {

	private String plugin;
	private long time;

	public PacketCheckUpdate() {}

	public PacketCheckUpdate(String plugin, long time) {
		this.plugin = plugin;
		this.time = time;
	}

	public long getTime() {
		return time;
	}
	public String getPlugin() {
		return plugin;
	}
}
