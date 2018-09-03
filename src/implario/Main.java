package implario;

import implario.net.Packet;
import implario.net.packet.PacketTop;

public class Main{

    public static void main(String[] args){
        Packet.init();
        PacketTop user = new PacketTop(new PacketTop.Top[]{new PacketTop.Top("LolKek", 152, 125)});
        user = (PacketTop) Packet.getPacket(user.zip());
        System.out.println(user.getTop()[0].getGames());
    }
}
