import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Date;

public class MultiClient {
    static final int MAX_THREADS = 10;

    public static void main(String[] args) throws IOException, InterruptedException {

        InetAddress address = InetAddress.getByName("localhost");
        for (int  i = 0; i < MAX_THREADS ; i++){
            new Thread(new MultiClientThread(address, 5050)).start();
            //Thread.sleep(100);
        }
    }


    public static class MultiClientThread implements Runnable {
        private Socket socket;
        private BufferedReader in;
        private PrintWriter out;


        public MultiClientThread(InetAddress address, int port) {
            try {
                socket = new Socket(address, port);
            } catch (IOException e) {
                System.err.println("Socket failed");
            }

            try {
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
            } catch (IOException e) {
                try {
                    socket.close();
                } catch (IOException ex) {
                    System.err.println("Socket not closed");
                }
            }
        }

        @Override
        public void run() {
            try {
                long mills = new Date().getTime();
                while (true){
                    for (int i =0; i< Integer.MAX_VALUE; i++){

                        out.println(Thread.currentThread().getName() + " Text : " + i);

                        String str = in.readLine();
                        if (str != null) {
                            System.out.println(str);
                        }
                        Thread.sleep(1);
                        long time = new Date().getTime();
                        //System.out.println(time - mills);
                        if (time - mills > 5000) return;
                    }
                }
/*
                for (int i = 0; i < 999; i++) {
                    out.println("Client " + id + ": " + i);
                    String str = in.readLine();
                    System.out.println(str);
                }*/
            } catch (Exception e) {
                System.err.println("IO Exception");
            } finally {
                // Всегда закрывает:
                try {
                    socket.close();
                } catch (IOException e) {
                    System.err.println("Socket not closed");
                }
            }
        }

    }
}
