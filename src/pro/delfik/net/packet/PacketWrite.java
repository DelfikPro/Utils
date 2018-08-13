package pro.delfik.net.packet;

import pro.delfik.net.Packet;
import pro.delfik.util.ByteUnzip;
import pro.delfik.util.ByteZip;

import java.util.Base64;

public class PacketWrite extends Packet{
	private final String name;
	private final byte file[];

	public PacketWrite(ByteUnzip unzip){
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
	protected ByteZip encode() {
		return new ByteZip().add(name).add(file);
	}
}
