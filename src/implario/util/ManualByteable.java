package implario.util;

import java.lang.reflect.InvocationTargetException;

public interface ManualByteable {
	ManualByteZip zip();

	static <T> T decode(Class<T> clazz, byte array[]){
		return decode(clazz, new ManualByteUnzip(array));
	}

	static <T> T decode(Class<T> clazz, ManualByteUnzip unzip){
		try{
			return clazz.getConstructor(ManualByteUnzip.class).newInstance(unzip);
		}catch (NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException ex){
			ex.printStackTrace();
			System.out.println(clazz.getCanonicalName());
			throw new IllegalArgumentException(ex);
		}
	}
}
