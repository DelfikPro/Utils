package implario.net.packet;

import implario.net.Packet;
import implario.util.ManualByteUnzip;
import implario.util.ManualByteZip;

public class PacketGC extends Packet {
	private boolean rl;

	public PacketGC(){

	}

	public PacketGC(boolean rl){
		this.rl = rl;
	}

	public boolean isRl() {
		return rl;
	}
}
