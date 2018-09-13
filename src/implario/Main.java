package implario;

import implario.net.Packet;
import implario.net.packet.PacketUser;
import implario.util.ByteUnzip;
import implario.util.ByteZip;
import implario.util.Converter;
import implario.util.Rank;
import implario.util.UserInfo;

import java.util.Collections;
import java.util.List;

public class Main{

    public static void main(String[] args){
        Packet.init();
        PacketUser p = new PacketUser(new UserInfo("delfik", "123", Rank.DEV, 123123, "123.123.123.123", 345234, false, false,
				Converter.asList("a", "b"), Collections.emptyList(), false), true);
		PacketUser packet = (PacketUser) Packet.getPacket(p.zip());
		UserInfo i = packet.getUserInfo();
		System.out.println(i.name + i.passhash + i.rank + i.online + i.lastIP + i.money + i.ipAttached + i.pmDisabled + Converter.merge(i.ignored, s->s, ", ") + i.darkTheme);
	}
}
