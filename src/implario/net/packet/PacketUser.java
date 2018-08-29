package implario.net.packet;

import implario.net.Packet;
import implario.util.ManualByteUnzip;
import implario.util.ManualByteZip;
import implario.util.Rank;

public class PacketUser extends Packet {
	private String nick;
	private long online;
	private int money;
	
	private Rank rank;

	private boolean authorized;

	public PacketUser(){
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
}
