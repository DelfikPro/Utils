package pro.delfik.net.packet;

import pro.delfik.net.Packet;
import pro.delfik.util.ByteUnzip;
import pro.delfik.util.ByteZip;

public class PacketOutAuth extends Packet{
	private final String nick, ip;

	public PacketOutAuth(ByteUnzip unzip){
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
	protected ByteZip encode() {
		return new ByteZip().add(nick).add(ip);
	}
}
