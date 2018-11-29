package implario.net;

import implario.net.packet.*;
import implario.util.ByteUnzip;
import implario.util.ByteZip;
import implario.util.Byteable;
import implario.util.Coder;

import java.util.HashMap;
import java.util.Map;

public abstract class Packet {
	private static final Map<String, Class<? extends Packet>> packets = new HashMap<>();

	public String getType() {
		return getClass().getSimpleName();
	}

	protected ByteZip encode(){
		return null;
	}

	public byte[] zip() {
		String type = getType();
		byte[] b = new byte[type.length()];
		for(int i = 0; i < b.length; i++)
			b[i] = (byte)type.charAt(i);
		ByteZip result = new ByteZip();
		result.add(type);
		ByteZip zip = encode();
		if(zip != null) return result.add(zip.build()).build();
		result.add(Coder.toBytes(this));
		return result.build();
	}

	public static Packet getPacket(byte array[]) {
		ByteUnzip unzip = new ByteUnzip(array);
		String name = unzip.getString();
		Class<? extends Packet> packet = packets.get(name);
		if(packet == null)throw new IllegalArgumentException("Packet not registered " + name);
		return Byteable.toByteable(unzip.getBytes(), packet);
	}

	public static void register(Class<? extends Packet> clazz) {
		packets.put(clazz.getSimpleName(), clazz);
	}

	public static void init(){
		register(PacketUser.class);
		register(PacketInit.class);
		register(PacketAuth.class);
		register(PacketPex.class);
		register(PacketPunishment.class);
		register(PacketSummon.class);
		register(PacketSSU.class);
		register(PacketWrite.class);
		register(PacketRead.class);
		register(PacketGC.class);
		register(PacketOutAuth.class);
		register(PacketChangeTheme.class);
		register(PacketTopUpdate.class);
		register(PacketCreateTop.class);
		register(PacketMoney.class);
	}
}
