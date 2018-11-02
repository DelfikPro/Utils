package implario.net;

import __google_.net.Response;

public interface NetListener {
    void accept(Response response, Connector connector);

    void closed();
}
