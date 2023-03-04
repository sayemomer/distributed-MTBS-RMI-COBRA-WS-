package TCP.sample;

import java.io.*;
import java.net.*;

public class tcpClient {
    public static void main(String[] args) throws IOException {
        // Initialize the hostname and port number to connect to
        String hostName = "localhost";
        int portNumber = 1234;

        try (
            // Create a new socket connection to the specified host and port
            Socket socket = new Socket(hostName, portNumber);
            
            // Create a PrintWriter object to send data to the server
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            
            // Create a BufferedReader object to receive data from the server
            BufferedReader in = new BufferedReader(
                new InputStreamReader(socket.getInputStream()));
            
            // Create a BufferedReader object to read user input from the command line
            BufferedReader stdIn = new BufferedReader(
                new InputStreamReader(System.in))
        ) {
            String userInput;
            
            // Continuously read user input from the command line and send it to the server
            while ((userInput = stdIn.readLine()) != null) {
                out.println(userInput); // Send the user input to the server
                
                // Wait for a response from the server and print it to the console
                System.out.println("echo: " + in.readLine());
                
                // If the user types "Bye", exit the loop
                if (userInput.equals("Bye"))
                    break;
            }
        } catch (UnknownHostException e) {
            // Handle the case where the host name is invalid
            System.err.println("Don't know about host " + hostName);
            System.exit(1);
        } catch (IOException e) {
            // Handle the case where there is an I/O error with the connection
            System.err.println("Couldn't get I/O for the connection to " +
                hostName);
            System.exit(1);
        }
    }
}
