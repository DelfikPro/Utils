package pro.delfik.net.packet;

import pro.delfik.net.Packet;

public class PacketRead extends Packet{
	private final String read, write;

	public PacketRead(String serialize) {
		super("read");
		String split[] = serialize.split("\\?");
		read = split[0];
		write = split[1];
	}

	public PacketRead(String read, String write) {
		super("read");
		this.read = read;
		this.write = write;
	}

	public String getRead() {
		return read;
	}

	public String getWrite() {
		return write;
	}

	@Override
	protected String encode() {
		return read + '?' + write;
	}
}
