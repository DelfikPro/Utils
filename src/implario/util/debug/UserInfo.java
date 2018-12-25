package implario.util.debug;

import implario.util.ByteUnzip;
import implario.util.ByteZip;
import implario.util.Byteable;
import implario.util.Rank;

import javax.jws.soap.SOAPBinding;
import java.util.List;
import java.util.function.Function;

public class UserInfo implements Byteable {
	public int version = Version.last();

	public String name, passhash, lastIP;
	public boolean ipAttached, pmDisabled, darkTheme;
	public Rank rank;
	public int online, money;
	public List<String> friends, ignored;
	public long items;

	protected UserInfo() {}

	public UserInfo(String name, String passhash, Rank rank, int online, String lastIP,
					int money, boolean ipAttached, boolean pmDisabled, List<String> ignored,
					List<String> friends, boolean darkTheme, long items) {
		this.name = name;
		this.passhash = passhash;
		this.rank = rank;
		this.online = online;
		this.lastIP = lastIP;
		this.money = money;
		this.ipAttached = ipAttached;
		this.pmDisabled = pmDisabled;
		this.ignored = ignored;
		this.friends = friends;
		this.darkTheme = darkTheme;
		this.items = items;
	}

	public ByteZip encode() {
		return new ByteZip()
				.add(Version.last())
				.add(name)
				.add(passhash)
				.add(rank.getByte())
				.add(online)
				.add(lastIP)
				.add(money)
				.add(ipAttached)
				.add(pmDisabled)
				.add(ignored)
				.add(friends)
				.add(darkTheme)
				.add(items);
	}

	public enum Version {
		V0(u -> new UserInfo(
				u.getString(),
				u.getString(),
				Rank.byChar.get((char) u.getByte()),
				u.getInt(),
				u.getString(),
				u.getInt(),
				u.getBoolean(),
				u.getBoolean(),
				u.getList(),
				u.getList(),
				false,
				0
		)),
		V1_DARKTHEME(u -> new UserInfo(
				u.getString(),
				u.getString(),
				Rank.byChar.get((char) u.getByte()),
				u.getInt(),
				u.getString(),
				u.getInt(),
				u.getBoolean(),
				u.getBoolean(),
				u.getList(),
				u.getList(),
				u.getBoolean(),
				0
		)),
		V2_ITEMS(u -> new UserInfo(
				u.getString(),
				u.getString(),
				Rank.byChar.get((char) u.getByte()),
				u.getInt(),
				u.getString(),
				u.getInt(),
				u.getBoolean(),
				u.getBoolean(),
				u.getList(),
				u.getList(),
				u.getBoolean(),
				u.getLong()
		));

		private final Function<ByteUnzip, UserInfo> unzipper;

		Version(Function<ByteUnzip, UserInfo> unzipper) {
			this.unzipper = unzipper;
		}

		public static UserInfo unzip(ByteUnzip unzip) {
			Version v = Version.values()[unzip.getInt()];
			return v.unzipper.apply(unzip);
		}

		public static int last() {
			return values().length - 1;
		}
	}
}
