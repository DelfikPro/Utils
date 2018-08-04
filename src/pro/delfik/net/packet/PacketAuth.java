package pro.delfik.net.packet;

import pro.delfik.net.Packet;
import pro.delfik.util.ByteUnzip;
import pro.delfik.util.ByteZip;

public class PacketAuth extends Packet{
	private final String nick;

	public PacketAuth(ByteUnzip unzip){
		nick = unzip.getString();
	}

	public PacketAuth(String nick){
		this.nick = nick;
	}

	public String getNick() {
		return nick;
	}

	@Override
	protected ByteZip encode() {
		return new ByteZip().add(nick);
	}
}
