package ThreadPooled;

import java.io.*;
import java.net.Socket;

public class WorkerRunnable implements Runnable {

    private Socket socket;
    //private BufferedReader in;
    //private PrintWriter out;

    public WorkerRunnable(Socket socket) {
        this.socket = socket;
        //this.in = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
        //this.out = new PrintWriter(new OutputStreamWriter(this.socket.getOutputStream()), true);
    }

    @Override
    public void run() {

        try (BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true)) {

            while (true) {
                String str = in.readLine();
                if (str.equals("Bye."))
                    break;
                System.out.println("Echoing: " + str);
                out.println(str);
            }

        } catch (IOException e) {
            System.out.println("Exception in Reader|Writer");
            e.printStackTrace();
        }finally {
            try {
                socket.close();
            } catch (IOException e) {
                System.out.println("Socket not closed");
            }
        }
    }
}

