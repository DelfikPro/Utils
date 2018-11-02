package implario.net;

import __google_.crypt.Crypt;
import __google_.net.CSSystem;
import __google_.net.Response;
import __google_.net.server.NetServer;
import __google_.util.Coder;
import __google_.util.Exceptions;

import java.io.IOException;
import java.net.Socket;

public class Connector extends CSSystem implements NetServer {
    private final NetListener consumer;

    public Connector(Socket socket, NetListener consumer) throws IOException {
        super(socket);
        this.consumer = consumer;
        if(!socket().getInetAddress().getHostName().equals("localhost"))return;
        (new Thread(this)).start();
    }

    @Override
    public void run() {
        Exceptions.runThrowsEx(this::execute);
        closeOutException();
        consumer.closed();
    }

    @Override
    public void execute() throws IOException {
        while(true) {
            byte read[] = read(Coder.toInt(read(4)));
            consumer.accept(Coder.toObject(read, Response.class), this);
        }
    }

    @Override
    public Crypt crypt() {
        return null;
    }

    @Override
    public void setCrypt(Crypt crypt) {}

    public void write(Response response) {
        try {
            byte[] write = Coder.toBytes(response);
            write(Coder.toAbsoluteBytes(write.length));
            write(write);
            flush();
        }catch (IOException ex){
            throw new IllegalArgumentException(ex);
        }
    }
}
