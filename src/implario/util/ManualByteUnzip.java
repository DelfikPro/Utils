package implario.util;

import implario.util.Converter;

import java.nio.charset.Charset;
import java.util.List;

public class ManualByteUnzip {
	private final byte array[];
	private int i = 0;

	public ManualByteUnzip(byte array[]){
		this.array = array;
	}

	public List<String> getList(){
		return Converter.toList(getString(), (char)0x0b + "");
	}

	public boolean getBoolean(){
		return getBytes()[0] == 0b1;
	}

	public String getASCII(){
		return new String(getBytes());
	}

	public String getString(){
		return new String(getBytes(), Charset.forName("UTF-8"));
	}

	public long getLong(){
		byte bytes[] = getBytes();
		if(bytes.length < 8)return getInt(bytes);
		return
				(long)bytes[0] << 56 & 0xff00000000000000L
				| (long)bytes[1] << 48 & 0xff000000000000L
				| (long)bytes[2] << 40 & 0xff0000000000L
				| (long)bytes[3] << 32 & 0xff00000000L
				| (long)bytes[4] << 24 & 0xff000000L
				| (long)bytes[5] << 16 & 0xff0000L
				| (long)bytes[6] << 8 & 0xff00L
				| (long)bytes[7] & 0xffL;
	}

	public int getInt(){
		return getInt(getBytes());
	}

	public byte getByte(){
		return getBytes()[0];
	}

	public byte[] getBytes(){
		int size = array[i++];
		if(size == 127){
			size = array[i++] << 24 & 0xff000000
					| array[i++] << 16 & 0xff0000
					| array[i++] << 8 & 0xff00
					| array[i++] & 0xff;
		}else size = size & 0xff;
		return getBytes(size);
	}

	public byte[] getBytes(int size){
		byte bytes[] = new byte[size];
		for (int write = 0; write < bytes.length; write++, i++)
			bytes[write] = array[i];
		return bytes;
	}

	public boolean next(){
		return i < array.length;
	}

	private int getInt(byte bytes[]){
		if(bytes.length == 1)return (byte)(bytes[0] & 0xff);
		return bytes[0] << 24 & 0xff000000
				| bytes[1] << 16 & 0xff0000
				| bytes[2] << 8 & 0xff00
				| bytes[3] & 0xff;
	}
}
