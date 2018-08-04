package pro.delfik.net.packet;

import pro.delfik.net.Packet;
import pro.delfik.util.ByteUnzip;
import pro.delfik.util.ByteZip;
import pro.delfik.util.Converter;

public class PacketUpdateTop extends Packet{

	private final String nick;

	private final boolean win;

	private final int beds, deaths;

	public PacketUpdateTop(ByteUnzip unzip){
		this.nick = unzip.getString();
		this.win = unzip.getBoolean();
		this.beds = unzip.getInt();
		this.deaths = unzip.getInt();
	}

	public PacketUpdateTop(String nick, boolean win, int beds, int deaths) {
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

	public int getDeaths() {
		return deaths;
	}

	@Override
	protected ByteZip encode() {
		return new ByteZip().add(nick).add(win).add(beds).add(deaths);
	}
}
