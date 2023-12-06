import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientHandler implements Runnable {
    private Socket clientSocket;
    private Scanner in;
    private PrintWriter out;

    public ClientHandler(Socket socket) {
        this.clientSocket = socket;
        try {
            this.in = new Scanner(clientSocket.getInputStream());
            this.out = new PrintWriter(clientSocket.getOutputStream(), true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            String username = in.nextLine();
            System.out.println(username + " has joined the chat.");

            // Notify the client that the connection is successful
            out.println("Welcome to the chat, " + username + "!");
            out.println("Type 'bye' to exit.");

            // Broadcast messages to other clients
            while (true) {
                String message = in.nextLine();
                if (message.equalsIgnoreCase("bye")) {
                    break;
                }
                System.out.println(username + ": " + message);
                broadcast(username + ": " + message);
            }
        } finally {
            try {
                clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void broadcast(String message) {
        // TODO: Implement broadcasting to other clients
    }
}
