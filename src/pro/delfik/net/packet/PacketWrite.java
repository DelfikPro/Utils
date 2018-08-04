package pro.delfik.net.packet;

import pro.delfik.net.Packet;
import pro.delfik.util.ByteUnzip;
import pro.delfik.util.ByteZip;

import java.util.Base64;

public class PacketWrite extends Packet{
	private final String name, file;

	public PacketWrite(ByteUnzip unzip){
		name = unzip.getString();
		file = unzip.getString();
	}

	public PacketWrite(String name, String file) {
		this.name = name;
		this.file = file;
	}

	public String getName() {
		return name;
	}

	public String getFile() {
		return file;
	}

	@Override
	protected ByteZip encode() {
		return new ByteZip().add(name).add(file);
	}
}
