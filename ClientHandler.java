import java.io.*;
import java.net.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * Eduardo Boanca
 * Calcolatrice Multithread
 */

public class ClientHandler implements Runnable {

    private Socket client;
    private BufferedReader in;
    private PrintWriter out;
    private ArrayList<ClientHandler> clients;

    public ClientHandler(Socket clientSocket, ArrayList<ClientHandler> clients) throws IOException {
        this.client = clientSocket;
        this.clients = clients;
        in = new BufferedReader(new InputStreamReader(client.getInputStream()));
        out = new PrintWriter(client.getOutputStream());
    }

    @Override
    public void run() {
        try {
            
        } catch (Exception e) {
            System.err.println("Error from ClientHandler");
            e.printStackTrace();
        } finally {
            out.close();
        }
        try {
            in.close();
        } catch (IOException e) {
            System.err.println("Error from ClientHandler");
            e.printStackTrace();
        }
    }

}
