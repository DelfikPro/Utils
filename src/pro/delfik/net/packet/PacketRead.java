package pro.delfik.net.packet;

import pro.delfik.net.Packet;
import pro.delfik.util.ByteUnzip;
import pro.delfik.util.ByteZip;

public class PacketRead extends Packet{
	private final String read, write;

	public PacketRead(ByteUnzip unzip) {
		read = unzip.getString();
		write = unzip.getString();
	}

	public PacketRead(String read, String write) {
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
	protected ByteZip encode() {
		return new ByteZip().add(read).add(write);
	}
}
