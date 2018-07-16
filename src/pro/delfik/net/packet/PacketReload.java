package pro.delfik.net.packet;

import pro.delfik.net.Packet;

public class PacketReload extends Packet{

	public PacketReload(String serialize){
		super("reload");
	}


	public PacketReload(){
		super("reload");
	}

	@Override
	protected String encode() {
		return "ignore";
	}
}
