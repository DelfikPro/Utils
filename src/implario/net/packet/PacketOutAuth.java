package implario.net.packet;

import implario.net.Packet;
import implario.util.ManualByteUnzip;
import implario.util.ManualByteZip;

public class PacketOutAuth extends Packet {
	private final String nick, ip;

	public PacketOutAuth(ManualByteUnzip unzip){
		this.nick = unzip.getString();
		this.ip = unzip.getString();
	}

	public PacketOutAuth(String nick, String ip){
		this.nick = nick;
		this.ip = ip;
	}

	public String getNick() {
		return nick;
	}

	public String getIp() {
		return ip;
	}

	@Override
	protected ManualByteZip encode() {
		return new ManualByteZip().add(nick).add(ip);
	}
}
