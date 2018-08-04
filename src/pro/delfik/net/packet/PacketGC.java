package pro.delfik.net.packet;

import pro.delfik.net.Packet;
import pro.delfik.util.ByteUnzip;
import pro.delfik.util.ByteZip;

public class PacketGC extends Packet{
	private final boolean rl;

	public PacketGC(ByteUnzip unzip){
		rl = unzip.getBoolean();
	}

	public PacketGC(boolean rl){
		this.rl = rl;
	}

	public boolean isRl() {
		return rl;
	}

	@Override
	protected ByteZip encode() {
		return new ByteZip().add(rl);
	}
}
