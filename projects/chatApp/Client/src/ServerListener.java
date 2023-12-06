import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class ServerListener implements Runnable {
    private Socket socket;
    private Scanner in;

    public ServerListener(Socket socket) {
        this.socket = socket;
        try {
            this.in = new Scanner(socket.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while (in.hasNextLine()) {
            String message = in.nextLine();
            System.out.println(message);
        }
    }
}
