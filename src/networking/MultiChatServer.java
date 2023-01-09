package networking;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collections;
import java.util.HashMap;

public class MultiChatServer {
    private final HashMap<String, DataOutputStream> clients;

    public MultiChatServer() {
        clients = new HashMap<>();
        Collections.synchronizedMap(clients);
    }

    public static void main(String[] args) {
        new MultiChatServer().start();
    }

    public void start() {
        final int port = 3000;
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Server start at " + port);
            Socket socket = null;
            while (true) {
                socket = serverSocket.accept();
                System.out.println("Connected from " + socket.getInetAddress() + ":" + socket.getPort());
                new ServerReceiver(socket).start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void sendToAll(String msg) {
        try {
            for (DataOutputStream out : clients.values()) {
                out.writeUTF(msg);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    class ServerReceiver extends Thread {
        Socket socket;
        DataInputStream in;
        DataOutputStream out;

        public ServerReceiver(Socket socket) {
            this.socket = socket;
            try {
                in = new DataInputStream(socket.getInputStream());
                out = new DataOutputStream(socket.getOutputStream());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void run() {
            String name = "";
            try {
                name = in.readUTF();
                clients.put(name, out);
                sendToAll("[" + name + "] entered this room (now " + clients.size() + ")");
                while (in != null) {
                    sendToAll(in.readUTF());
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                clients.remove(name);
                sendToAll("[" + name + "] exited this room (now " + clients.size() + ")");
                System.out.println("Disconnected from " + socket.getInetAddress() + ":" + socket.getPort());
            }
        }
    }
}