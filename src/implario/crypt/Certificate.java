package implario.crypt;

import java.security.Key;
import java.security.KeyPair;

public class Certificate extends AsyncCrypt{
	public Certificate(int size){
		super("RSA");
		KeyPair pair = generate(size);
		publicKey = pair.getPublic();
		privateKey = pair.getPrivate();
	}

	public Certificate(){
		this(2048);
	}

	public Certificate(byte publicKey[], byte privateKey[]){
		super("RSA");
		if(publicKey != null)this.publicKey = decodePublic(publicKey);
		if(privateKey != null)this.privateKey = decodePrivate(privateKey);
	}

	public Certificate(byte publicKey[]){
		this(publicKey, null);
	}

	@Override
	public Key publicKey() {
		return privateKey;
	}

	@Override
	public Key privateKey() {
		return publicKey;
	}
}
