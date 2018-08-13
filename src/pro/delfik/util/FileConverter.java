package pro.delfik.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Base64;

public class FileConverter {
	public static void write(File file, byte array[]){
		try{
			BufferedOutputStream writer = new BufferedOutputStream(new FileOutputStream(file));
			for(byte b : array)
				writer.write(b);
			writer.flush();
			writer.close();
		}catch (IOException ex){
			ex.printStackTrace();
		}
	}

	public static byte[] read(File file){
		byte read[] = new byte[(int)file.length()];
		try{
			BufferedInputStream in = new BufferedInputStream(new FileInputStream(file));
			in.read(read);
			in.close();
		}catch (IOException ex){
			return null;
		}
		return read;
	}
}
