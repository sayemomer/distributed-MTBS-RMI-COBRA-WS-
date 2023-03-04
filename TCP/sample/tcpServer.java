package TCP.sample;

// These are the necessary Java libraries to perform input/output operations and networking operations.
import java.io.*;
import java.net.*;

// This defines a new Java class named "TCPServer".
public class tcpServer {
    // This is the main method of the class, which is executed when the program starts.
    public static void main(String[] args) throws IOException {
        // This variable stores the port number that the server will listen on.
        int portNumber = 1234;
        
        // This code sets up the server socket to listen on the specified port number, and waits for a client
        //  to connect. When a client connects, it creates a new socket for that client and sets up 
        //  input/output streams for communication with the client. The "try-with-resources" statement is used here 
        //  to automatically close the sockets and streams when they are no longer needed.
        try (
            ServerSocket serverSocket = new ServerSocket(portNumber);
            Socket clientSocket = serverSocket.accept();
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(
                new InputStreamReader(clientSocket.getInputStream()));
        ) {

            // These variables will be used to store the messages sent between the client and server.
            String inputLine, outputLine;
            // Echo the message back to the client

            // This code sets up a loop to read messages from the client and echo them back to the client with the
            //  "Server: " prefix. The loop continues until the client sends the message "Bye", at which point the 
            //  loop is exited and the connection is closed.
            while ((inputLine = in.readLine()) != null) {
                outputLine = "Server: " + inputLine;
                out.println(outputLine);
                if (outputLine.equals("Server: Bye"))
                    break;
            }
        } catch (IOException e) {
            // This code catches any exceptions that may occur during socket setup or communication and
            //  prints an error message to the console.
            System.out.println("Exception caught when trying to listen on port "
                + portNumber + " or listening for a connection");
            System.out.println(e.getMessage());
        }
    }
}
