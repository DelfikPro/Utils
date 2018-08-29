package implario.net.packet;

import implario.net.Packet;
import implario.util.ManualByteUnzip;
import implario.util.ManualByteZip;

public class PacketUpdateTop extends Packet {

	private String nick;
	private boolean win;
	private int beds, deaths;

	public PacketUpdateTop(){
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
}
