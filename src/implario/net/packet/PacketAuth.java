package implario.net.packet;

import implario.net.Packet;
import implario.util.ManualByteUnzip;
import implario.util.ManualByteZip;

public class PacketAuth extends Packet {
	private final String nick;

	public PacketAuth(ManualByteUnzip unzip){
		nick = unzip.getString();
	}

	public PacketAuth(String nick){
		this.nick = nick;
	}

	public String getNick() {
		return nick;
	}

	@Override
	protected ManualByteZip encode() {
		return new ManualByteZip().add(nick);
	}
}
