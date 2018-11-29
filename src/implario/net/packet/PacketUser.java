package implario.net.packet;

import implario.net.Packet;
import implario.util.ByteUnzip;
import implario.util.ByteZip;
import implario.util.debug.UserInfo;

public class PacketUser extends Packet {

	private UserInfo userInfo;
	private boolean authorized;

	public PacketUser(ByteUnzip unzip) {
		this.userInfo = UserInfo.Version.unzip(unzip);
		this.authorized = unzip.getBoolean();
	}

	public PacketUser(UserInfo userInfo, boolean authorized) {
		this.userInfo = userInfo;
		this.authorized = authorized;
	}

	public boolean isAuthorized() {
		return authorized;
	}
	public UserInfo getUserInfo() {
		return userInfo;
	}

	@Override
	protected ByteZip encode() {
		return userInfo.encode().add(authorized);
	}
}
