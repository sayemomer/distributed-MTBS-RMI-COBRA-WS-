package UDP.sample;

import java.io.*;
import java.net.*;

public class udpClient {
    public static void main(String args[]) throws Exception {
        // Get the IP address of the server
        InetAddress IPAddress = InetAddress.getByName("localhost");

        // Create a datagram socket
        DatagramSocket clientSocket = new DatagramSocket();

        // Create a byte array to send data
        byte[] sendData = new byte[1024];

        // Create a message to send to the server
        String message = "Hello from client!";

        // Convert the message to bytes
        sendData = message.getBytes();

        // Create a datagram packet to send the message
        DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 9876);

        // Send the packet to the server
        clientSocket.send(sendPacket);

        // Create a byte array to receive data from the server
        byte[] receiveData = new byte[1024];

        // Create a datagram packet to receive data from the server
        DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);

        // Receive the packet from the server
        clientSocket.receive(receivePacket);

        // Extract the data from the packet
        String response = new String(receivePacket.getData());

        // Print the response from the server
        System.out.println("RESPONSE: " + response);

        // Close the socket
        clientSocket.close();
    }
}

