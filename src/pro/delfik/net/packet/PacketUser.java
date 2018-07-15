package pro.delfik.net.packet;

import pro.delfik.net.Packet;
import pro.delfik.util.Rank;

public class PacketUser extends Packet{

	private final String nick;

	private final Rank rank;

	public PacketUser(String serialize){
		super("user");
		this.nick = serialize.substring(1);
		this.rank = Rank.decode(serialize);
	}

	public PacketUser(String nick, Rank rank){
		super("user");
		this.nick = nick;
		this.rank = rank;
	}

	@Override
	protected String encode() {
		return rank + nick;
	}
}
