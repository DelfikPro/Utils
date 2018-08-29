package implario.net.packet;

import implario.net.Packet;
import implario.util.ManualByteUnzip;
import implario.util.ManualByteZip;

public class PacketRead extends Packet {
	private String read, write;

	public PacketRead() {
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
}
