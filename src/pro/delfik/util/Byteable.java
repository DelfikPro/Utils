package pro.delfik.util;

import java.lang.reflect.InvocationTargetException;

public interface Byteable {
	ByteZip zip();

	static <T> T decode(Class<T> clazz, byte array[]){
		return decode(clazz, new ByteUnzip(array));
	}

	static <T> T decode(Class<T> clazz, ByteUnzip unzip){
		try{
			return clazz.getConstructor(ByteUnzip.class).newInstance(unzip);
		}catch (NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException ex){
			ex.printStackTrace();
			System.out.println(clazz.getCanonicalName());
			throw new IllegalArgumentException(ex);
		}
	}
}
