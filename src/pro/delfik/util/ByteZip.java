package pro.delfik.util;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class ByteZip {
	private final List<byte[]> bytes = new ArrayList<>();

	public byte[] build(){
		byte result[] = new byte[size()];
		int i = 0;
		for(byte[] bytes : bytes){
			if(bytes.length > 126){
				result[i++] = 127;
				result[i++] = (byte)(bytes.length >> 24);
				result[i++] = (byte)(bytes.length >> 16);
				result[i++] = (byte)(bytes.length >> 8);
				result[i++] = (byte)bytes.length;
			}else
				result[i++] = (byte)bytes.length;
			for(int write = 0; write < bytes.length; write++)
				result[write + i] = bytes[write];
			i = i + bytes.length;
		}
		return result;
	}

	public ByteZip add(List<String> list){
		add(Converter.merge(list, str -> str,(char)0x0b + ""));
		return this;
	}

	public ByteZip addASCII(String str){
		byte result[] = new byte[str.length()];
		for(int i = 0; i < str.length(); i++)
			result[i] = (byte)str.charAt(i);
		add(result);
		return this;
	}

	public ByteZip add(String str){
		add(str.getBytes(Charset.forName("UTF-8")));
		return this;
	}

	public ByteZip add(long l){
		if(((int)l) == l)add((byte)l);
		else add(new byte[]{
				(byte)(l >> 56),
				(byte)(l >> 48),
				(byte)(l >> 40),
				(byte)(l >> 32),
				(byte)(l >> 24),
				(byte)(l >> 16),
				(byte)(l >> 8),
				(byte)l
		});
		return this;
	}

	public ByteZip add(int i){
		if(((byte)i) == i)add((byte)i);
		else add(new byte[]{
				(byte)(i >> 24),
				(byte)(i >> 16),
				(byte)(i >> 8),
				(byte)i
		});
		return this;
	}

	public ByteZip add(boolean b){
		add(b ? 0b1 : 0b0);
		return this;
	}

	public ByteZip add(byte b){
		add(new byte[]{b});
		return this;
	}

	public ByteZip add(byte b[]){
		bytes.add(b);
		return this;
	}

	public ByteZip addStart(byte b[]){
		bytes.add(0, b);
		return this;
	}

	public int size(){
		int size = bytes.size();
		for(byte bytes[] : bytes){
			size = size + bytes.length;
			if(bytes.length > 126)
				size = size + 4;
		}
		return size;
	}
}
