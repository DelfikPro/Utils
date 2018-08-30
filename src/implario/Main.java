package implario;

import implario.net.Packet;
import implario.net.packet.PacketInit;
import implario.net.packet.PacketTop;
import implario.net.packet.PacketUser;
import implario.util.ByteUnzip;
import implario.util.Coder;
import implario.util.Rank;

public class Main{

    public static void main(String[] args){
        Packet.init();
        PacketTop user = new PacketTop(new PacketTop.Top[]{new PacketTop.Top("LolKek", 152, 125)});
        user = (PacketTop) Packet.getPacket(user.zip());
        System.out.println(user.getTop()[0].getGames());
    }
}
