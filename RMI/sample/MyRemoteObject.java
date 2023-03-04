package RMI.sample;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;


/*
 The implementation of the remote interface is the actual remote object that provides the implementation 
 of the methods declared in the remote interface.
 */

public class MyRemoteObject extends UnicastRemoteObject implements MyRemoteInterface {

    public MyRemoteObject() throws RemoteException {
        super();
    }

    public String sayHello() throws RemoteException {
        return "Hello, world!";
    }
}
