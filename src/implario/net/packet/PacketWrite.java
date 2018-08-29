package implario.net.packet;

import implario.net.Packet;
import implario.util.ManualByteUnzip;
import implario.util.ManualByteZip;

public class PacketWrite extends Packet {
	private String name;
	private byte file[];

	public PacketWrite(){
	}

	public PacketWrite(String name, byte file[]) {
		this.name = name;
		this.file = file;
	}

	public String getName() {
		return name;
	}

	public byte[] getFile() {
		return file;
	}
}
