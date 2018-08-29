package implario.net.packet;

import implario.net.Packet;
import implario.util.ManualByteUnzip;
import implario.util.ManualByteZip;

public class PacketOutAuth extends Packet {
	private String nick, ip;

	public PacketOutAuth(){
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
}
