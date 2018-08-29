package implario;

import implario.net.Packet;
import implario.net.packet.PacketInit;
import implario.net.packet.PacketUser;
import implario.util.Coder;
import implario.util.Rank;

public class Main{

    public static void main(String[] args){
        Packet.init();
        PacketUser user = new PacketUser("afs", Rank.DEV, true, 125, 125);
        user = (PacketUser)Packet.getPacket(user.zip());
        System.out.println(user.isAuthorized());
    }
}
