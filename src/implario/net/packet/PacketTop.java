package implario.net.packet;

import implario.net.Packet;
import implario.util.ByteUnzip;
import implario.util.ByteZip;
import implario.util.ManualByteUnzip;
import implario.util.ManualByteZip;
import implario.util.Converter;

import java.util.ArrayList;
import java.util.List;

public class PacketTop extends Packet {
	private final Top top[];

	public PacketTop(ByteUnzip unzip){
		List<String> list = new ArrayList<>();
		while (unzip.next())
			list.add(unzip.getString());
		top = new Top[list.size()];
		for(int i = 0; i < list.size(); i++){
			if(list.get(i).equals("null"))
				top[i] = null;
			else top[i] = new Top(list.get(i));
		}
	}

	public PacketTop(Top[] top) {
		this.top = top;
	}

	public Top[] getTop() {
		return top;
	}

	@Override
	protected ByteZip encode() {
		ByteZip zip = new ByteZip();
		for(Top top : top)
			zip.add(top == null ? "null" : top.toString());
		return zip;
	}

	public static class Top{
		private final String nick;

		private final int wins, games;

		public Top(String serialize){
			String split[] = serialize.split("}");
			boolean b = split.length < 2;
			this.nick = b ? null : split[0];
			this.wins = Converter.toInt(split[1]);
			this.games = Converter.toInt(split[2]);
		}

		public Top(String nick, int wins, int games) {
			this.nick = nick;
			this.wins = wins;
			this.games = games;
		}

		public String getNick() {
			return nick;
		}

		public int getWins() {
			return wins;
		}

		public int getGames() {
			return games;
		}

		@Override
		public String toString() {
			return nick + "}" + wins + "}" + games;
		}
	}
}
