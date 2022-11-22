import java.io.IOException;
import java.io.*;
import java.net.*;
import java.util.*;

/*
 * Eduardo Boanca
 * Calcolatrice Multithread
 */

public class Client {
    private static final String SERVER_IP = "127.0.0.1";
    private static final int SERVER_PORT = 7777;
    public static final String[] opzioni = new String[] { "+", "-", "*", "/", "C", "=", "7" };

    public static void main(String[] args) throws IOException {

        try {
            Socket socket = new Socket(SERVER_IP, SERVER_PORT);
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            Scanner scanner = new Scanner(System.in);

            boolean noExit = true;
            String scelta = "";
            String serverResponse = "";

            while (noExit) {
                String[] responseArr;
                boolean error = true;
                do {

                    error = true;
                    System.out.println();
                    System.out.println("Operazioni Disponibili:");
                    System.out.println("+) +numero");
                    System.out.println("-) -numero");
                    System.out.println("*) *numero");
                    System.out.println("/) /numero");
                    System.out.println("C) Azzera risulato");
                    System.out.println("=) Richiedi Risultato Finale");
                    System.out.println("7) EXIT");
                    System.out.println("Inserisci il numero dell'operazione da eseguire");
                    System.out.println(">");

                    try {
                        String command = input.readLine();
                        if (inputCheck(command)) {
                            error = false;
                        } else {
                            System.out.println("ERROR 500: Valore non valido");
                        }
                    } catch (Exception e) {
                        System.out.println("ERROR 500: Valore non valido");
                    }
                } while (error);

                switch (scelta) {
                    case "+":
                        System.out.println("sono un piu");
                        break;
                    case "-":
                        System.out.println("sono un meno");
                        break;
                    case "*":

                        break;
                    case "/":

                        break;
                    case "C":

                        break;
                    case "=":

                        break;
                    case "7":
                        out.println("EXIT");
                        serverResponse = input.readLine();
                        responseArr = serverResponse.split(";");
                        if (responseArr[0].equals("ERR") && responseArr[1].equals("700")) {
                            System.out.println("Errore nei parametri inseriti: Errore " +
                                    responseArr[1]);
                        } else if (responseArr[0].equals("APPROVE")) {
                            System.out.println("Uscita dal programma");
                            noExit = false;
                            socket.close();
                        }
                        break;
                    default:
                        System.out.println("HAI MESSO IL COMANDO SBAGLIATO");
                        break;
                }
            }
            scanner.close();
        } catch (IOException e) {
            System.out.println("Errore: " + e);
        }
    }

    /*
     * while(true) {
     * System.out.println();
     * System.out.println("Inserisci il numero: ");
     * System.out.println(">");
     * String num = keyboard.readLine();
     * out.println("Risultato: " + num);
     * if (num.equals("quit")) break;
     * String serverResponse = input.readLine();
     * System.out.println("Server sent: " + serverResponse);
     * }
     */
    public static boolean inputCheck(String str) {
        for (String string : opzioni) {
            if (str.equals(string))
                return true;
        }
        return false;
    }
}
