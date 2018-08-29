package implario.net;

public interface Listener {
	void on(P2P p2p);

	void update(Packet packet);

	void off();
}
