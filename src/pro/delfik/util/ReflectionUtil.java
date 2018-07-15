package pro.delfik.util;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionUtil {
	
	public static Class<?> getBungeeClass(String path, String clazz)
			throws Exception {
		return Class.forName("net.md_5.bungee." + path + "." + clazz);
	}
	
	public static Constructor<?> getConstructor(Class<?> clazz, Class<?>... args)
			throws Exception {
		Constructor<?> c = clazz.getConstructor(args);
		c.setAccessible(true);
		return c;
	}
	
	public static Field getField(Class<?> clazz, String fname)
			throws Exception {
		Field f;
		try {
			f = clazz.getDeclaredField(fname);
		} catch (Exception e) {
			f = clazz.getField(fname);
		}
		setFieldAccessible(f);
		return f;
	}
	
	public static Object getFirstObject(Class<?> clazz, Class<?> objclass, Object instance)
			throws Exception {
		Field f = null;
		for (Field fi : clazz.getDeclaredFields()) {
			if (fi.getType().equals(objclass)) {
				f = fi;
				break;
			}
		}
		if (f == null) {
			for (Field fi : clazz.getFields()) {
				if (fi.getType().equals(objclass)) {
					f = fi;
					break;
				}
			}
		}
		setFieldAccessible(f);
		return f.get(instance);
	}
	
	public static Method getMethod(Class<?> clazz, String mname)
			throws Exception {
		Method m = null;
		try {
			m = clazz.getDeclaredMethod(mname);
		} catch (Exception e) {
			try {
				m = clazz.getMethod(mname);
			} catch (Exception ex) {
				return m;
			}
		}
		m.setAccessible(true);
		return m;
	}
	
	public static <T> Field getField(Class<?> target, String name, Class<T> fieldType, int index) {
		for (Field field : target.getDeclaredFields()) {
			if (((name == null) || (field.getName().equals(name))) && (fieldType.isAssignableFrom(field.getType())) && (index-- <= 0)) {
				field.setAccessible(true);
				return field;
			}
		}
		if (target.getSuperclass() != null) {
			return getField(target.getSuperclass(), name, fieldType, index);
		}
		throw new IllegalArgumentException("Cannot find field with type " + fieldType);
	}
	
	public static Method getMethod(Class<?> clazz, String mname, Class<?>... args)
			throws Exception {
		Method m = null;
		try {
			m = clazz.getDeclaredMethod(mname, args);
		} catch (Exception e) {
			try {
				m = clazz.getMethod(mname, args);
			} catch (Exception ex) {
				return m;
			}
		}
		m.setAccessible(true);
		return m;
	}
	
	public static Object getObject(Class<?> clazz, Object obj, String fname)
			throws Exception {
		return getField(clazz, fname).get(obj);
	}
	
	public static Object getObject(Object obj, String fname)
			throws Exception {
		return getField(obj.getClass(), fname).get(obj);
	}
	
	public static Object invokeConstructor(Class<?> clazz, Class<?>[] args, Object... initargs)
			throws Exception {
		return getConstructor(clazz, args).newInstance(initargs);
	}
	
	public static Object invokeMethod(Object obj, String method)
			throws Exception {
		return getMethod(obj.getClass(), method).invoke(obj);
	}
	
	public static void setFieldAccessible(Field f)
			throws Exception {
		f.setAccessible(true);
		Field modifiers = Field.class.getDeclaredField("modifiers");
		modifiers.setAccessible(true);
		modifiers.setInt(f, f.getModifiers() & 0xFFFFFFEF);
	}
	
	public static void setObject(Class<?> clazz, Object obj, String fname, Object value)
			throws Exception {
		getField(clazz, fname).set(obj, value);
	}
}
