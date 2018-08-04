package pro.delfik.net.packet;

import pro.delfik.net.Packet;
import pro.delfik.util.ByteUnzip;
import pro.delfik.util.ByteZip;
import pro.delfik.util.Rank;

public class PacketPex extends Packet{
	private final String nick;

	private final Rank rank;

	public PacketPex(ByteUnzip unzip){
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
	protected ByteZip encode() {
		return new ByteZip().add(rank.toString()).add(nick);
	}
}
