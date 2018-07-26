package pro.delfik.net.packet;

import pro.delfik.net.Packet;
import pro.delfik.util.Converter;

public class PacketPunishment extends Packet{

	private final String nick, moder, reason;

	private final int time;

	private final Punishment punishment;

	public PacketPunishment(String serialize){
		super("punishment");
		String split[] = serialize.split("\\?");
		this.nick = split[0];
		this.punishment = Punishment.valueOf(split[1]);
		this.moder = split[2];
		this.time = Converter.toInt(split[3]);
		this.reason = split[4];
	}

	public PacketPunishment(String nick, Punishment punishment, String moder, int time, String reason){
		super("punishment");
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
	protected String encode() {
		return nick + "?" + punishment + "?" + moder + "?" + time + "?" + reason;
	}

	public enum Punishment{
		BAN,
		UNBAN,
		MUTE,
		UNMUTE,
		KICK
	}
}
