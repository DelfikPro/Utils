package implario.net.packet;

import implario.net.Packet;
import implario.util.ManualByteUnzip;
import implario.util.ManualByteZip;

public class PacketWrite extends Packet {
	private final String name;
	private final byte file[];

	public PacketWrite(ManualByteUnzip unzip){
		name = unzip.getString();
		file = unzip.getBytes();
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

	@Override
	protected ManualByteZip encode() {
		return new ManualByteZip().add(name).add(file);
	}
}
