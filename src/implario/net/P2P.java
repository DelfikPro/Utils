package implario.net;

import implario.util.Coder;
import implario.util.CryptoUtils;
import implario.util.Scheduler;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.SocketException;
import java.util.Base64;

public class P2P implements Runnable{

	private BufferedReader reader;
	private BufferedWriter writer;
	private Socket socket;
	private CryptoUtils crypt;
	private Listener listener;

	public P2P(Socket socket, CryptoUtils crypt, Listener listener) {
		this.crypt = crypt;
		this.listener = listener;
		try{
			reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			this.socket = socket;
			listener.on(this);
			Scheduler.runThr(this);
		}catch (IOException ignored){}
	}

	@Override
	public void run() {
		try{
			while (true){
				byte[] read = Base64.getDecoder().decode(reader.readLine());
				if(read == null)break;
				if(crypt != null)read = crypt.decrypt(read);
				listener.update(Packet.getPacket(read));
			}
		} catch (SocketException ex) {
			System.out.println("Соединение с прокси разорвано.");
		}
		catch (Throwable ex){
			ex.printStackTrace();
		}
		close();
		listener.off();
	}

	public void send(Packet packet){
		try{
			byte write[] = packet.zip();
			if(crypt != null)write = crypt.encrypt(write);
			writer.write(Base64.getEncoder().encodeToString(write));
			writer.newLine();
			writer.flush();
		}catch (IOException ex){
			ex.printStackTrace();
		}
	}

	public void close(){
		try {socket.close();} catch (IOException ignored) {}
	}
}
