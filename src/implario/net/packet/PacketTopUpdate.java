package implario.net.packet;

import implario.net.Packet;

public class PacketTopUpdate extends Packet {
    private String name;
    private byte update[];

    public PacketTopUpdate(){}

    public PacketTopUpdate(String name, byte update[]){
        this.name = name;
        this.update = update;
    }

    public String getName() {
        return name;
    }

    public byte[] getUpdate() {
        return update;
    }
}
