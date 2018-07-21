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
	public static void write(File file, String str){
		try{
			str = new String(Base64.getDecoder().decode(str));
			BufferedOutputStream writer = new BufferedOutputStream(new FileOutputStream(file));
			for(char c : str.toCharArray())
				writer.write(c);
			writer.flush();
			writer.close();
		}catch (IOException ex){
			ex.printStackTrace();
		}
	}

	public static String read(File file){
		StringBuilder buffer = new StringBuilder();
		try{
			BufferedInputStream in = new BufferedInputStream(new FileInputStream(file));
			while (true){
				int i = in.read();
				if(i == -1)break;
				buffer.append((char)i);
			}
			in.close();
		}catch (IOException ex){
			return null;
		}
		return Base64.getEncoder().encodeToString(buffer.toString().getBytes());
	}
}
