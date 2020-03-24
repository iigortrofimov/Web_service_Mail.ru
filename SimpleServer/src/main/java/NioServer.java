/*import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;

public class NioServer {
    private static final int CLIENT_PORT = 1111;
    private static final int SERVER_PORT = 8080;


    public static void main(String[] args) throws IOException {
        SocketChannel channel = SocketChannel.open();
        Selector selector = Selector.open();

        channel.socket().bind(new InetSocketAddress(CLIENT_PORT));
        channel.configureBlocking(false);
        channel.register(selector, SelectionKey.OP_READ | SelectionKey.OP_WRITE
                | SelectionKey.OP_CONNECT);
        selector.select();




    }
}*/
