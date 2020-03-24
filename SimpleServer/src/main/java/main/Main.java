package main;

import ThreadPooled.ThreadsPooledServer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {

    static final Logger logger = LogManager.getLogger(Main.class.getName());

    public static void main(String[] args) throws InterruptedException {

        ThreadsPooledServer threadsPooledServer = new ThreadsPooledServer();
        Thread server = new Thread(threadsPooledServer);
        server.start();
        logger.info("Server started");
        server.join();
    }
}
