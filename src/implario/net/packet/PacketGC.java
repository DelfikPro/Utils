package implario.net.packet;

import implario.net.Packet;
import implario.util.ManualByteUnzip;
import implario.util.ManualByteZip;

public class PacketGC extends Packet {
	private final boolean rl;

	public PacketGC(ManualByteUnzip unzip){
		rl = unzip.getBoolean();
	}

	public PacketGC(boolean rl){
		this.rl = rl;
	}

	public boolean isRl() {
		return rl;
	}

	@Override
	protected ManualByteZip encode() {
		return new ManualByteZip().add(rl);
	}
}
