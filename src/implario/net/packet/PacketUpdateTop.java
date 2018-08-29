package implario.net.packet;

import implario.net.Packet;
import implario.util.ManualByteUnzip;
import implario.util.ManualByteZip;

public class PacketUpdateTop extends Packet {

	private final String nick;

	private final boolean win;

	private final int beds, deaths;

	public PacketUpdateTop(ManualByteUnzip unzip){
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
	protected ManualByteZip encode() {
		return new ManualByteZip().add(nick).add(win).add(beds).add(deaths);
	}
}
