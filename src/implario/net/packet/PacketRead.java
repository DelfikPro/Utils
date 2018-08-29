package implario.net.packet;

import implario.net.Packet;
import implario.util.ManualByteUnzip;
import implario.util.ManualByteZip;

public class PacketRead extends Packet {
	private final String read, write;

	public PacketRead(ManualByteUnzip unzip) {
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
	protected ManualByteZip encode() {
		return new ManualByteZip().add(read).add(write);
	}
}
