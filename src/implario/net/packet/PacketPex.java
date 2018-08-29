package implario.net.packet;

import implario.net.Packet;
import implario.util.ManualByteUnzip;
import implario.util.ManualByteZip;
import implario.util.Rank;

public class PacketPex extends Packet {
	private final String nick;

	private final Rank rank;

	public PacketPex(ManualByteUnzip unzip){
		this.rank = Rank.decode(unzip.getString());
		this.nick = unzip.getString();
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

	@Override
	protected ManualByteZip encode() {
		return new ManualByteZip().add(rank.toString()).add(nick);
	}
}
