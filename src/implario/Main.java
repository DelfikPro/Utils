package implario;

import implario.net.Packet;
import implario.net.packet.PacketInit;

public class Main{

    public static void main(String[] args){
        Packet.init();
        PacketInit init = new PacketInit("125");
        byte array[] = init.zip();
        PacketInit init1 = (PacketInit)Packet.getPacket(array);
        System.out.println("rwqqrwqrwqrwqrwqr " + init1.getServer());
    }
}
