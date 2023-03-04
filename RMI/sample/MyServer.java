package RMI.sample;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;


/*
     The server program creates an instance of the remote object, registers it with the RMI registry, 
     and waits for incoming client requests.
 */

public class MyServer {

    public static void main(String[] args) {
        try {
            MyRemoteObject obj = new MyRemoteObject();
            Registry registry = LocateRegistry.getRegistry();
            Naming.rebind("MyRemoteObject", obj);
            System.out.println("Server ready");
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
