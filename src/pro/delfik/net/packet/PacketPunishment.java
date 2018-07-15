package pro.delfik.net.packet;

import pro.delfik.net.Packet;
import pro.delfik.util.Converter;

import javax.naming.CompositeName;

public class PacketPunishment extends Packet{

	private final String nick, moder;

	private final int time;

	private final Punishment punishment;

	public PacketPunishment(String serialize){
		super("punishment");
		String split[] = serialize.split("\\?");
		this.nick = split[0];
		this.punishment = Punishment.valueOf(split[1]);
		this.moder = split[2];
		this.time = Converter.toInt(split[3]);
	}

	public PacketPunishment(String nick, Punishment punishment, String moder, int time){
		super("punishment");
		this.nick = nick;
		this.punishment = punishment;
		this.moder = moder;
		this.time = time;
	}

	public PacketPunishment(String nick, Punishment punishment, String moder){
		this(nick, punishment, moder, 0);
	}

	@Override
	protected String encode() {
		return nick + "?" + punishment + "?" + moder + "?" + time;
	}

	public enum Punishment{
		BAN,
		UNBAN,
		MUTE,
		UNMUTE
	}
}
