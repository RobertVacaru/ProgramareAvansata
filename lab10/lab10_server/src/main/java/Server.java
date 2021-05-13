import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {
    // Define the port on which the server is listening
    public static final int PORT = 8100;
    public boolean flag;
    public Server() throws IOException {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(PORT);
            setFlag(true);
            ArrayList<Person> personArrayList = new ArrayList<>();
            SocialNetwork socialNetwork = new SocialNetwork(personArrayList);
            while(flag) {
                System.out.println("Waiting for a client ...");
                Socket socket = serverSocket.accept();
                // Execute the client's request in a new thread
                socket.setSoTimeout(300000);
                new ClientThread(socket,this,socialNetwork).start();
            }

        } catch (IOException e) {
            System.err.println("Ooops... " + e);
        } finally {
            serverSocket.close();
        }
    }
    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public static void main(String[] args) throws IOException {
        Server server = new Server();
    }
}