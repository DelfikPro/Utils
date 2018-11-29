package implario.net.packet;

import implario.net.Packet;

public class PacketMoney extends Packet {

	private int earned;
	private String user;

	public PacketMoney() {}

	public PacketMoney(int earned, String user) {
		this.earned = earned;
	}

	public int getEarned() {
		return earned;
	}
	public String getUser() {
		return user;
	}

}
