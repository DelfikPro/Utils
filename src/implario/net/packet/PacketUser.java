package implario.net.packet;

import implario.net.Packet;
import implario.util.ManualByteUnzip;
import implario.util.ManualByteZip;
import implario.util.Rank;

public class PacketUser extends Packet {
	private final String nick;
	private final long online;
	private final int money;
	
	private final Rank rank;

	private final boolean authorized;

	public PacketUser(ManualByteUnzip unzip){
		this.nick = unzip.getString();
		this.rank = Rank.decode(unzip.getString());
		this.authorized = unzip.getBoolean();
		this.online = unzip.getLong();
		this.money = 0;
	}

	public PacketUser(String nick, Rank rank, boolean authorized, long online, int money) {
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
	protected ManualByteZip encode() {
		return new ManualByteZip().add(nick).add(rank + "").add(authorized).add(online).add(money);
	}
}
