package pro.delfik.net.packet;

import pro.delfik.net.Packet;
import pro.delfik.util.Converter;
import pro.delfik.util.Rank;

public class PacketUser extends Packet{
	private final String nick;
	private final long online;
	private final int money;
	
	private final Rank rank;

	private final boolean authorized;

	public PacketUser(String serialize){
		super("user");
		String split[] = serialize.split("\\?");
		this.nick = split[0].substring(1);
		this.rank = Rank.decode(serialize);
		this.authorized = Converter.toBoolean(split[1]);
		this.online = Converter.toLong(split[2], 0);
		this.money = Converter.toInt(split[3], 0);
	}

	public PacketUser(String nick, Rank rank, boolean authorized, long online, int money) {
		super("user");
		this.nick = nick;
		this.rank = rank;
		this.authorized = authorized;
		this.online = online;
		this.money = money;
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
	public long getOnline() {
		return online;
	}
	public int getMoney() {
		return money;
	}
	
	@Override
	protected String encode() {
		return rank + nick + "?" + authorized + "?" + online + "?" + money;
	}
}
