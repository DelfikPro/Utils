package pro.delfik.net.packet;

import pro.delfik.net.Packet;
import pro.delfik.util.Converter;

public class PacketUpdateTop extends Packet{

	private final String nick;

	private final boolean win;

	private final int beds, deaths;

	public PacketUpdateTop(String serialize){
		super("updatetop");
		String split[] = serialize.split("\\?");
		this.nick = split[0];
		this.win = Converter.toBoolean(split[1]);
		this.beds = Converter.toInt(split[2]);
		this.deaths = Converter.toInt(split[3]);
	}

	public PacketUpdateTop(String nick, boolean win, int beds, int deaths) {
		super("updatetop");
		this.nick = nick;
		this.win = win;
		this.beds = beds;
		this.deaths = deaths;
	}

	public String getNick() {
		return nick;
	}

	public boolean isWin() {
		return win;
	}

	public int getBeds() {
		return beds;
	}

	@Override
	protected String encode() {
		return nick + "?" + win + "?" + beds + "?" + deaths;
	}
}
