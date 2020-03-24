import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class Client {

    public static void main(String[] args) throws IOException {
        InetAddress address = InetAddress.getByName("localhost");
        System.out.println("local IP-address is " + address);

        try (Socket socket = new Socket(address, 8080)) {
            System.out.println("Socket is " + socket);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
            for (int i = 0; i < 10; i++) {
                out.println("howdy " + i);
                String str = in.readLine();
                System.out.println(str);
            }
            out.println("Bye.");

        }
    }
}
