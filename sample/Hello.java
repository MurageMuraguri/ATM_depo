package sample;

import java.rmi.Remote;
import java.rmi.RemoteException;

// Creating Remote interface for our application
public interface Hello extends Remote {
  /**
  *<h1>Interface Hello</h1>
  *Remote interface for our distributed app.
  */
    void animation() throws RemoteException;
}
