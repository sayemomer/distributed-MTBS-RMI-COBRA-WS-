package UDP.sample;

import java.io.*;
import java.net.*;


// UDP (User Datagram Protocol) is a connectionless transport protocol used in computer networking. 
// It provides a simple way to send and receive datagrams, which are independent, self-contained packets 
// of data that may arrive out of order or not at all. UDP is often used for applications such as real-time 
// audio and video streaming, online gaming, and other applications where low latency and fast data transfer
//  are important.

public class udpServer {
    public static void main(String args[]) throws Exception {
        // Create a datagram socket at port 9876
        DatagramSocket serverSocket = new DatagramSocket(9876);

        // Create a byte array to receive incoming data
        byte[] receiveData = new byte[1024];

        while (true) {
            // Create a datagram packet to receive incoming data
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);

            // Receive the packet from the client
            serverSocket.receive(receivePacket);

            // Extract the data from the packet
            String sentence = new String(receivePacket.getData());

            // Print the received data
            System.out.println("RECEIVED: " + sentence);

            // Create a response message
            String response = "Hello from server!";

            // Convert the response message to bytes
            byte[] sendData = response.getBytes();

            // Get the IP address and port number of the client
            InetAddress IPAddress = receivePacket.getAddress();
            int port = receivePacket.getPort();

            // Create a datagram packet to send the response
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, port);

            // Send the packet to the client
            serverSocket.send(sendPacket);
        }
    }
}
