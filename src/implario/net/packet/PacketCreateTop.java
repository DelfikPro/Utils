package implario.net.packet;

import implario.net.Packet;
import implario.util.ByteUnzip;
import implario.util.ByteZip;

public class PacketCreateTop extends Packet {
    private final String top[];

    public PacketCreateTop(ByteUnzip unzip){
        this.top = new String[unzip.getInt()];
        for(int i = 0; i < top.length; i++)
            top[i] = unzip.getString();
    }

    public PacketCreateTop(String top[]){
        this.top = top;
    }

    @Override
    protected ByteZip encode() {
        ByteZip zip = new ByteZip().add(top.length);
        for(String line : top)
            zip.add(line);
        return zip;
    }

    public String[] getTop() {
        return top;
    }
}

