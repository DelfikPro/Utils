package pro.delfik.net.packet;

import pro.delfik.net.Packet;
import pro.delfik.util.Rank;

public class PacketPex extends Packet{
	private final String nick;

	private final Rank rank;

	public PacketPex(String serialize){
		super("pex");
		this.nick = serialize.substring(1);
		this.rank = Rank.decode(serialize);
	}

	public PacketPex(String nick, Rank rank){
		super("pex");
		this.nick = nick;
		this.rank = rank;
	}

	public String getNick() {
		return nick;
	}

	public Rank getRank() {
		return rank;
	}

	@Override
	protected String encode() {
		return rank + nick;
	}
}
