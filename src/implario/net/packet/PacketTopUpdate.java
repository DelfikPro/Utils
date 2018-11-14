package implario.net.packet;

import implario.net.Packet;

public class PacketTopUpdate extends Packet {
    private String name, nick;
    private byte update[];

    public PacketTopUpdate(){}

    public PacketTopUpdate(String name, byte update[], String nick){
        this.name = name;
        this.update = update;
        this.nick = nick;
    }

    public String getName() {
        return name;
    }

    public byte[] getUpdate() {
        return update;
    }

    public String getNick() {
        return nick;
    }
}
