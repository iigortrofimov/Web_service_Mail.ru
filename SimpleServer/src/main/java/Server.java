/*
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private static final int PORT = 8080;

    public static void main(String[] args) throws IOException {
        try (ServerSocket s = new ServerSocket(PORT)) {
            System.out.println("Server Started");
            while (true) {
                Socket socket = s.accept();
                try {
                    new Thread(new ClientThread(socket)).start();
                } catch (IOException e) {
                    socket.close();
                }
            }
        }
    }


    private static class ClientThread implements Runnable {
        private Socket socket;
        private BufferedReader in;
        private PrintWriter out;

        public ClientThread(Socket socket) throws IOException {
            this.socket = socket;
            this.in = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
            this.out = new PrintWriter(new OutputStreamWriter(this.socket.getOutputStream()), true);
        }

        @Override
        public void run() {
            try {
                while (true) {
                    String str = in.readLine();
                    if (str.equals("Bye."))
                        break;
                    System.out.println("Echoing: " + str);
                    out.println(str);
                }
                System.out.println("closing...");
            } catch (IOException e) {
                System.out.println("IO Exception");
            } finally {
                try {
                    socket.close();
                } catch (IOException e) {
                    System.out.println("Socket not closed");
                }
            }
        }
    }
}*/
