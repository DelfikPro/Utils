package pro.delfik.util;

import java.util.ArrayList;
import java.util.List;

public class ByteZip {
	private final List<Byte[]> bytes = new ArrayList<>();

	public byte[] build(){
		byte result[] = new byte[size()];
		int i = 0;
		for(Byte[] bytes : bytes){
			result[i++] = (byte)bytes.length;
			for(int write = 0; write < bytes.length; write++)
				result[write + i] = bytes[write];
			i = i + bytes.length;
		}
		return result;
	}

	public void add(List<String> list){
		add(Converter.merge(list, str -> {return str;},(char)0x0b + ""));
	}

	public void add(String str){
		Byte array[] = new Byte[str.length()];
		for(int i = 0; i < array.length; i++)
			array[i] = (byte)str.charAt(i);
		add(array);
	}

	public void add(int i){
		if(((byte)i) == i)add((byte)i);
		else add(new Byte[]{
				(byte)(i >> 24),
				(byte)(i >> 16),
				(byte)(i >> 8),
				(byte)i
		});
	}

	public void add(boolean b){
		add(b ? 0b1 : 0b0);
	}

	public void add(byte b){
		add(new Byte[]{b});
	}

	public void add(Byte b[]){
		bytes.add(b);
	}

	public int size(){
		int size = bytes.size();
		for(Byte[] bytes : bytes)
			size = size + bytes.length;
		return size;
	}
}
