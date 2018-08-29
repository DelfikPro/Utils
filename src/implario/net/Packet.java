package implario.net;

import implario.net.packet.PacketAuth;
import implario.net.packet.PacketGC;
import implario.net.packet.PacketInit;
import implario.net.packet.PacketOutAuth;
import implario.net.packet.PacketPex;
import implario.net.packet.PacketPunishment;
import implario.net.packet.PacketRead;
import implario.net.packet.PacketSSU;
import implario.net.packet.PacketSummon;
import implario.net.packet.PacketTop;
import implario.net.packet.PacketUpdateTop;
import implario.net.packet.PacketUser;
import implario.net.packet.PacketWrite;
import implario.util.ManualByteUnzip;
import implario.util.ManualByteZip;
import implario.util.ManualByteable;

import java.util.HashMap;
import java.util.Map;

public abstract class Packet implements ManualByteable {
	private static final Map<String, Class<? extends Packet>> packets = new HashMap<>();

	public String getType() {
		return getClass().getName().substring(6);
	}

	protected abstract ManualByteZip encode();

	@Override
	public ManualByteZip zip() {
		String type = getType();
		byte[] b = new byte[type.length()];
		for(int i = 0; i < b.length; i++)
			b[i] = (byte)type.charAt(i);
		return encode().addStart(b);
	}

	public static Packet getPacket(ManualByteUnzip unzip){
		String name = unzip.getString();
		Class<? extends Packet> packet = packets.get(name);
		if(packet == null)throw new IllegalArgumentException("Packet not registered " + name);
		return ManualByteable.decode(packet, unzip);
	}

	public static void register(Class<? extends Packet> clazz) {
		packets.put(clazz.getName().substring(6), clazz);
	}

	public static void init(){
		register(PacketUser.class);
		register(PacketInit.class);
		register(PacketAuth.class);
		register(PacketPex.class);
		register(PacketPunishment.class);
		register(PacketSummon.class);
		register(PacketSSU.class);
		register(PacketUpdateTop.class);
		register(PacketTop.class);
		register(PacketWrite.class);
		register(PacketRead.class);
		register(PacketGC.class);
		register(PacketOutAuth.class);
	}
}
