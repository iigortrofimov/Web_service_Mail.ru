package ThreadPooled;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadsPooledServer implements Runnable{
private static final int SERVER_PORT = 5050;
protected ServerSocket serverSocket = null;
protected boolean isStopped = false;
//protected Thread runningThread = null;
protected ExecutorService threadPool = Executors.newFixedThreadPool(10);


    @Override
    public void run() {
        synchronized (this){
//            runningThread = Thread.currentThread();
        }
        System.out.println("Server starts!");
        openServerSocket();
        while (!isStopped){
            Socket socket = null;
            try {
                socket = this.serverSocket.accept();
            } catch (IOException e){
                if (isStopped){
                    System.out.println("Server Stopped.");
                    break;
                }
                throw new RuntimeException("Error accepting client connection", e);
            }
            this.threadPool.execute(new WorkerRunnable(socket));
        }
        this.threadPool.shutdown();
        System.out.println("Server Stopped.");


    }

    private synchronized boolean isStopped(){
        return this.isStopped;
    }

    public synchronized void stop(){
        this.isStopped = true;
        try{
            this.serverSocket.close();
        } catch (IOException e){
            throw new RuntimeException("Error closing server", e);
        }
    }

    private void openServerSocket(){
        try {
            this.serverSocket = new ServerSocket(SERVER_PORT);
        } catch (IOException e){
            throw new RuntimeException("Cann't open port 5050", e);
        }
    }
}
