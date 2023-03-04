package RMI.sample;

import java.rmi.Naming;

/*
Create the client program: The client program looks up the remote object in the RMI registry and 
invokes the remote method on it.
 */

public class Client {

    public static void main(String[] args) {
        try {
            MyRemoteInterface obj = (MyRemoteInterface) Naming.lookup("//localhost/MyRemoteObject");
            String result = obj.sayHello();
            System.out.println(result);
        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
