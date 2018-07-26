package pro.delfik.util;

import java.util.List;

public class ByteUnzip {
	private final byte array[];
	private int i = 0;

	public ByteUnzip(byte array[]){
		this.array = array;
	}

	public List<String> getList(){
		return Converter.toList(getString(), (char)0x0b + "");
	}

	public boolean getBoolean(){
		return getBytes()[0] == 0b1;
	}

	public String getString(){
		return new String(getBytes());
	}

	public int getInt(){
		byte bytes[] = getBytes();
		if(bytes.length == 1)return (byte)(bytes[0] & 0xff);
		return bytes[0] << 24 & 0xff000000
				| bytes[1] << 16 & 0xff0000
				| bytes[2] << 8 & 0xff00
				| bytes[3] & 0xff;
	}

	public byte getByte(){
		return getBytes()[0];
	}

	public byte[] getBytes(){
		byte bytes[] = new byte[array[i++]];
		for(int write = 0; write < bytes.length; write++, i++)
			bytes[write] = array[i];
		return bytes;
	}

	public boolean next(){
		return i < array.length;
	}
}
