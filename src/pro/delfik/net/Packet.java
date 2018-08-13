package pro.delfik.net;

import pro.delfik.net.packet.PacketAuth;
import pro.delfik.net.packet.PacketGC;
import pro.delfik.net.packet.PacketInit;
import pro.delfik.net.packet.PacketPex;
import pro.delfik.net.packet.PacketPunishment;
import pro.delfik.net.packet.PacketRead;
import pro.delfik.net.packet.PacketSSU;
import pro.delfik.net.packet.PacketSummon;
import pro.delfik.net.packet.PacketTop;
import pro.delfik.net.packet.PacketUpdateTop;
import pro.delfik.net.packet.PacketUser;
import pro.delfik.net.packet.PacketWrite;
import pro.delfik.util.ByteUnzip;
import pro.delfik.util.ByteZip;
import pro.delfik.util.Byteable;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public abstract class Packet implements Byteable{
	private static final Map<String, Class<? extends Packet>> packets = new HashMap<>();

	public String getType() {
		return getClass().getName().substring(6);
	}

	protected abstract ByteZip encode();

	@Override
	public ByteZip zip() {
		String type = getType();
		byte[] b = new byte[type.length()];
		for(int i = 0; i < b.length; i++)
			b[i] = (byte)type.charAt(i);
		return encode().addStart(b);
	}

	public static Packet getPacket(ByteUnzip unzip){
		String name = unzip.getString();
		Class<? extends Packet> packet = packets.get(name);
		if(packet == null)throw new IllegalArgumentException("Packet not registered " + name);
		return Byteable.decode(packet, unzip);
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
	}
}
