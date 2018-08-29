package implario.util;

import java.lang.reflect.Constructor;

import static implario.util.Coder.toObject;
import static implario.util.Reflect.create;
import static implario.util.Reflect.getConstructor;

public interface Byteable {
	default byte[] toBytes(){
		ByteZip zip = toByteZip();
		if(zip != null)return zip.build();
		Packet packet = toPacket();
		if(packet != null)return packet.toBytes();
		return Coder.toBytes(toString());
	}

	default Packet toPacket(){
		return null;
	}

	default ByteZip toByteZip(){
		return null;
	}

	static <T> T toByteable(byte array[], Class<T> clazz){
		Constructor<T> constructor = getConstructor(clazz);
		if(constructor != null) return toObject(array, clazz);
		constructor = getConstructor(clazz, byte[].class);
		if(constructor == null)constructor = getConstructor(clazz, ByteUnzip.class);
		if(constructor == null)constructor = getConstructor(clazz, Packet.class);
		if(constructor == null)constructor = getConstructor(clazz, String.class);
		if(constructor == null) throw new IllegalArgumentException("No such constructor :c");
		return create(constructor, Coder.toString(array));
	}
}
