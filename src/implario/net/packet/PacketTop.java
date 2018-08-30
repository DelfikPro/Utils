package implario.net.packet;

import implario.net.Packet;
import implario.util.ByteUnzip;
import implario.util.ByteZip;
import implario.util.Byteable;

public class PacketTop extends Packet {
	private final Top top[];

	public PacketTop(ByteUnzip unzip){
		top = new Top[unzip.getInt()];
		for(int i = 0; i < top.length; i++){
			byte array[] = unzip.getBytes();
			if(array.length == 0) top[i] = null;
			else top[i] = Byteable.toByteable(array, Top.class);
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
		zip.add(top.length);
		for(Top top : top) zip.add(top == null ? new byte[]{} : top.toBytes());
		return zip;
	}

	public static class Top implements Byteable{
		private final String nick;

		private final int wins, games;

		public Top(ByteUnzip unzip){
			this.nick = unzip.getString();
			this.wins = unzip.getInt();
			this.games = unzip.getInt();
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
		public ByteZip toByteZip() {
			return new ByteZip().add(nick).add(wins).add(games);
		}
	}
}
