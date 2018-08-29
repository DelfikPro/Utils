package implario.net.packet;

import implario.net.Packet;
import implario.util.ManualByteUnzip;
import implario.util.ManualByteZip;
import implario.util.Rank;

public class PacketPex extends Packet {
	private String nick;

	private Rank rank;

	public PacketPex(){
	}

	public PacketPex(String nick, Rank rank){
		this.nick = nick;
		this.rank = rank;
	}

	public String getNick() {
		return nick;
	}

	public Rank getRank() {
		return rank;
	}
}
