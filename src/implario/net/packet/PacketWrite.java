package implario.net.packet;

import implario.net.Packet;
import implario.util.ByteUnzip;
import implario.util.ByteZip;
import implario.util.ManualByteUnzip;
import implario.util.ManualByteZip;

public class PacketWrite extends Packet {
	private final String name;
	private final byte file[];

	public PacketWrite(ByteUnzip unzip){
		this.name = unzip.getString();
		this.file = unzip.getBytes();
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
	protected ByteZip encode() {
		return new ByteZip().add(name).add(file);
	}
}
