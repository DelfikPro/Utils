package implario.net.packet;

import implario.net.Packet;
import implario.util.ManualByteUnzip;
import implario.util.ManualByteZip;

public class PacketAuth extends Packet {
	private String nick;

	public PacketAuth(){

	}

	public PacketAuth(String nick){
		this.nick = nick;
	}

	public String getNick() {
		return nick;
	}
}
