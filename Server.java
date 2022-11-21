
import java.io.*;
import java.net.*;
import java.util.*;
import java.util.concurrent.*;

/*
 * Eduardo Boanca
 * Calcolatrice Multithread
 */

public class Server {

    private final static int PORT = 7777;
    private static ArrayList<ClientHandler> clients = new ArrayList<ClientHandler>();
    private static ExecutorService pool = Executors.newFixedThreadPool(3);

    public static void main(String[] args) throws IOException {
        ServerSocket listener = new ServerSocket(PORT);
        
        while(true) {
            System.out.println("[SERVER] Waiting for client connection...");
            Socket client = listener.accept();
            System.out.println("[SERVER] Client Connected");
            ClientHandler clientThread = new ClientHandler(client, clients);
            clients.add(clientThread);

            pool.execute(clientThread);
        }
    }
}