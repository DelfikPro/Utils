package pro.delfik.net.packet;

import pro.delfik.net.Packet;

public class PacketAuth extends Packet{
	private final String nick;

	public PacketAuth(String nick){
		super("auth");
		this.nick = nick;
	}

	public String getNick() {
		return nick;
	}

	@Override
	protected String encode() {
		return nick;
	}
}
