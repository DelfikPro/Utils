package implario;

import implario.crypt.AES;
import implario.crypt.Blowfish;
import implario.crypt.Crypt;
import implario.crypt.Hash;
import implario.crypt.RSA;
import implario.io.FileIO;
import implario.net.Client;
import implario.net.Response;
import implario.util.Packet;
import implario.util.ByteUnzip;
import implario.util.ByteZip;
import implario.net.Server;
import implario.util.Coder;

import java.nio.charset.Charset;
import java.util.function.Consumer;

public class Testing {
    private static final int iterations = 100000;

    public static <T> long test(Consumer<T> consumer, T object, int number){
        long end, start = System.nanoTime();
        for(int i = 0; i < number; i++)
            consumer.accept(object);
        end = System.nanoTime();
        return end - start;
    }

    public static void hash(){
        String line = "LolKek";
        System.out.println(line);
        for(Hash hash : Hash.values())
            System.out.println(hash.name() + ": " + hash.hash(line));
    }

    public static void AES(){
        //Key size only 16 | 24 | 32
        defCrypt(new AES("LolLolLolLolLolL"));
    }

    public static void RSA(){
        //Async crypt
        defCrypt(new RSA());
    }

    public static void Blowfish(){
        //Custom key size
        defCrypt(new Blowfish("LolLolLolLolLolLaff"));
    }

    public static void fastLowerEN(){
        String lineEN = "aAbBcCdDeEfF123456@@%";

        System.out.println(Coder.toLowerEN(lineEN));
        System.out.println("Fast -> " + Testing.test((l) -> Coder.toLowerEN(l), lineEN, iterations));
        System.out.println(lineEN.toLowerCase());
        System.out.println("Default -> " + Testing.test((l) -> l.toLowerCase(), lineEN, iterations));
    }

    public static void fastUpperEN(){
        String lineEN = "aAbBcCdDeEfF123456@@%";

        System.out.println(Coder.toUpperEN(lineEN));
        System.out.println("Fast -> " + Testing.test((l) -> Coder.toUpperEN(l), lineEN, iterations));
        System.out.println(lineEN.toUpperCase());
        System.out.println("Default -> " + Testing.test((l) -> l.toUpperCase(), lineEN, iterations));
    }

    public static void fastLowerRU(){
        String lineRU = "аАбБвВгГдДеЕёЁ123456@@%";

        System.out.println(Coder.toLowerRU(lineRU));
        System.out.println("Fast -> " + Testing.test((l) -> Coder.toLowerRU(l), lineRU, iterations));
        System.out.println(lineRU.toLowerCase());
        System.out.println("Default -> " + Testing.test((l) -> l.toLowerCase(), lineRU, iterations));
    }

    public static void fastUpperRU(){
        String lineRU = "аАбБвВгГдДеЕёЁ123456@@%";

        System.out.println(Coder.toUpperRU(lineRU));
        System.out.println("Fast -> " + Testing.test((l) -> Coder.toUpperRU(l), lineRU, iterations));
        System.out.println(lineRU.toUpperCase());
        System.out.println("Default -> " + Testing.test((l) -> l.toUpperCase(), lineRU, iterations));
    }

    public static void certificate(){
        RSA rsa = new RSA(1536);
        RSA rs = new RSA(rsa.getBytePublicKey(), rsa.getBytePrivateKey());
        String line = "LolKasgasgaqwsgawsgzagwsawsggtawqtqwtqwtqwtqwtqwtqwtqwek";
        System.out.println(rs.encodeByte(line.getBytes(Charset.forName("ASCII"))).length);
        System.out.println(line.getBytes(Charset.forName("ASCII")).length);
        System.out.println(rs.encode(line));
        System.out.println(rsa.decode(rs.encode(line)));
    }

    public static void net(){
        Server server = new Server(4000);
        server.addListener((byte)1, b -> b);
        Client client = new Client("localhost", 4000);
        Response response = client.connect(new Response((byte)1, Coder.toBytes("LolKek")));
        System.out.println(response.getByteType());
        System.out.println(Coder.toString(response.getContent()));
        server.close();
    }

    public static void packet(){
        PacketStr packet = new PacketStr("LolKek");
        System.out.println(packet.str);
        System.out.println(((PacketStr)Packet.getPacket(packet.toBytes())).str);
    }

    public static class PacketStr extends Packet {
        public final String str;

        public PacketStr(String line){
            this.str = line;
        }

        public PacketStr(ByteUnzip line) {
            this.str = line.getString();
        }

        @Override
        public ByteZip toByteZip() {
            return new ByteZip().add(str);
        }
    }

    public static void file(){
        FileIO.write("Lol", "Lol12355");
        System.out.println(FileIO.read("Lol"));
    }

    public static void bytezip(){
        ByteZip zip = new ByteZip();
        zip.add("LolKekддд").add(123).add(12512552512512L);
        ByteUnzip unzip = new ByteUnzip(zip.build());
        System.out.println(unzip.getString());
        System.out.println(unzip.getInt());
        System.out.println(unzip.getLong());
    }

    private static void defCrypt(Crypt crypt){
        String line = "Lol 12355";
        String encoded = crypt.encode(line);

        System.out.println(line);
        System.out.println(encoded);
        System.out.println(crypt.decode(encoded));
    }
}
