package pro.delfik.net.packet;

import pro.delfik.net.Packet;
import pro.delfik.util.Converter;

public class PacketTop extends Packet{
	private final Top top[];

	public PacketTop(String serialize){
		super("top");
		String split[] = serialize.split("\n");
		top = new Top[split.length];
		for(int i = 0; i < split.length; i++){
			if(split[i].equals("null"))
				top[i] = null;
			top[i] = new Top(split[i]);
		}
	}

	public PacketTop(Top[] top) {
		super("top");
		this.top = top;
	}

	public Top[] getTop() {
		return top;
	}

	@Override
	protected String encode() {
		return Converter.merge(getTop(), Top::toString, "\n");
	}

	public static class Top{
		private final String nick;

		private final int wins, games;

		public Top(String serialize){
			String split[] = serialize.split("\\?");
			this.nick = split[0];
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
			return nick + "?" + wins + "?" + games;
		}
	}
}
