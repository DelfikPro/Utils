package implario.crypt;

import javax.crypto.Cipher;
import java.security.Key;
import java.util.Base64;

public abstract class SyncCrypt extends Crypt{
	protected Key key;

	protected SyncCrypt(String algorithm) {
		super(algorithm);
	}

	public Key key(){
		return key;
	}

	public byte[] getByteKey(){
		return key().getEncoded();
	}

	public String getKey(boolean usingBase64){
		return usingBase64 ? Base64.getEncoder().encodeToString(getByteKey()) : new String(getByteKey());
	}

	public String getKey(){
		return getKey(true);
	}

	@Override
	public byte[] encodeByte(byte array[]) {
		return cipher(array, Cipher.ENCRYPT_MODE, key());
	}

	@Override
	public byte[] decodeByte(byte array[]) {
		return cipher(array, Cipher.DECRYPT_MODE, key());
	}
}
