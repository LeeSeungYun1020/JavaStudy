package networking;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class UdpClient {
    public static void main(String[] args) {
        try {
            new UdpClient().start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void start() throws IOException {
        DatagramSocket datagramSocket = new DatagramSocket();
        InetAddress serverAddress = InetAddress.getByName("127.0.0.1");

        byte[] msg = new byte[100];
        DatagramPacket outPacket = new DatagramPacket(msg, 1, serverAddress, 3000);
        DatagramPacket inPacket = new DatagramPacket(msg, msg.length);
        datagramSocket.send(outPacket);
        datagramSocket.receive(inPacket);
        System.out.println("Current server time: " + new String(inPacket.getData()));
        datagramSocket.close();
    }
}
