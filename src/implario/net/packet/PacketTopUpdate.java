package implario.net.packet;

import implario.net.Packet;
import implario.util.ServerType;

public class PacketTopUpdate extends Packet {
    private String nick;
    private ServerType type;
    private byte update[];

    public PacketTopUpdate(){}

    public PacketTopUpdate(ServerType type, byte update[], String nick){
        this.type = type;
        this.update = update;
        this.nick = nick;
    }

    public ServerType type() {
        return type;
    }

    public byte[] getUpdate() {
        return update;
    }

    public String getNick() {
        return nick;
    }
}
