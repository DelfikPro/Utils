package pro.delfik.net.packet;

import pro.delfik.net.Packet;
import pro.delfik.util.Converter;
import pro.delfik.util.Rank;

public class PacketUser extends Packet{
	private final String nick;

	private final Rank rank;

	private final boolean authorized;

	public PacketUser(String serialize){
		super("user");
		String split[] = serialize.split("\\?");
		this.nick = split[0].substring(1);
		this.rank = Rank.decode(serialize);
		this.authorized = Converter.toBoolean(split[1]);
	}

	public PacketUser(String nick, Rank rank, boolean authorized){
		super("user");
		this.nick = nick;
		this.rank = rank;
		this.authorized = authorized;
	}

	public String getNick() {
		return nick;
	}

	public Rank getRank() {
		return rank;
	}

	public boolean isAuthorized() {
		return authorized;
	}

	@Override
	protected String encode() {
		return rank + nick + "?" + authorized;
	}
}
