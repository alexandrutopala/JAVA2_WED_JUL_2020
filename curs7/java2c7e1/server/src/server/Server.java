package server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) throws IOException {
        // Configuram o instanta de ServerSocket sa astepte conexiuni pe portul 4545
        ServerSocket serverSocket = new ServerSocket(4545);

        System.out.println("Astept conexiuni...");

        // Asteptam ca cineva sa se conecteze
        // Observatie: metoda accept este blocanta
        Socket client = serverSocket.accept();

        System.out.println("Un client s-a conectat");

        // deschid fluxul de intrare de la client in aplicatie
        BufferedReader in = new BufferedReader(
                new InputStreamReader(
                        client.getInputStream()
                )
        );

        // deschid fluxul de iesire de la aplicatie catre client
        PrintWriter out = new PrintWriter(
                client.getOutputStream(),
                true
        );

        System.out.println("Am creat fluxurile");

        String line = in.readLine();

        System.out.println("Am citit: " + line);

        String reversed = new StringBuilder(line).reverse().toString();

        out.println(reversed);

        System.out.println("Am afisat: " + reversed);

        in.close();
        out.close();
        client.close();
        serverSocket.close();

        System.out.println("Server inchis");
    }
}
