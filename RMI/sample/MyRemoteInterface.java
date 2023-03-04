package RMI.sample;

import java.rmi.Remote;
import java.rmi.RemoteException;


/*
The remote interface declares the methods that can be invoked remotely on a remote object. 
The remote interface must extend the java.rmi.Remote interface, and each method must declare the 
 java.rmi.RemoteException.
*/ 

public interface MyRemoteInterface extends Remote {
    public String sayHello() throws RemoteException;
}

