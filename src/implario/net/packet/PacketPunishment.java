package implario.net.packet;

import implario.net.Packet;
import implario.util.ByteUnzip;
import implario.util.ByteZip;

public class PacketPunishment extends Packet {
	private String nick, moder, reason;

	private int time;

	private Punishment punishment;

	public PacketPunishment(ByteUnzip unzip){
		this.nick = unzip.getString();
		this.punishment = Punishment.valueOf(unzip.getString());
		this.moder = unzip.getString();
		this.time = unzip.getInt();
		this.reason = unzip.getString();
	}

	public PacketPunishment(String nick, Punishment punishment, String moder, int time, String reason){
		this.nick = nick;
		this.punishment = punishment;
		this.moder = moder;
		this.time = time;
		this.reason = reason;
	}

	public PacketPunishment(String nick, Punishment punishment, String moder){
		this(nick, punishment, moder, 0, "null");
	}

	public String getNick() {
		return nick;
	}

	public String getModer() {
		return moder;
	}

	public int getTime() {
		return time;
	}

	public Punishment getPunishment() {
		return punishment;
	}

	public String getReason() {
		return reason;
	}

	@Override
	protected ByteZip encode() {
		return new ByteZip().add(nick).add(punishment + "").add(moder).add(time).add(reason);
	}

	public enum Punishment{
		BAN,
		UNBAN,
		MUTE,
		UNMUTE,
		KICK
	}
}
