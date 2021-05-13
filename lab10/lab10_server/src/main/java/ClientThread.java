import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

class ClientThread extends Thread {
    private Socket socket = null;
    private final Server server;
    private final SocialNetwork socialNetwork;

    public ClientThread(Socket socket, Server server, SocialNetwork socialNetwork) {
        this.socket = socket;
        this.server = server;
        this.socialNetwork = socialNetwork;
    }

    public void run() {
        try {
            // Get the request from the input stream: client → server
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
            // Send the response to the output stream: server → client
            PrintWriter out = new PrintWriter(socket.getOutputStream());
            while (true) {
                Person person = new Person();
                String request = in.readLine();
                if (request.equals("stop")) {
                    out.println("Server received the request: Stop and server stopped");
                    out.flush();
                    server.setFlag(false);
                    break;
                }
                if (request.equals("exit")) {
                    out.println("Server received the request: Exit");
                    out.flush();
                    break;
                } else {
                    if (request.equals("\n"))
                        continue;
                    String[] parts = request.split(" ");
                    String part1 = parts[0];
                    String part2 = parts[1];
                    if (part1.equals("register")) {
                        out.println("Server received the request: Registered " + part2);
                        person.setName(part2);
                        socialNetwork.register(person);
                    } else if (part1.equals("login")) {
                        out.println("Server received the request: Login " + part2);
                        person = socialNetwork.login(part2);
                    } else if (part1.equals("friend")) {
                        out.println("Server received the request: Friend " + part2);
                        socialNetwork.friend(person, part2);
                    } else if (part1.equals("send")) {
                        out.println("Server received the request: Send " + part2);
                        socialNetwork.send(person, part2);
                    } else if (part1.equals("read")) {
                        out.println("Server received the request: Read " + part2);
                        System.out.println(socialNetwork.read(person));
                    }
                }
                out.flush();
            }
        } catch (IOException e) {
            System.err.println("Communication error... " + e);
        } finally {
            try {
                socket.close(); // or use try-with-resources
            } catch (IOException e) {
                System.err.println(e);
            }
        }
    }
}
