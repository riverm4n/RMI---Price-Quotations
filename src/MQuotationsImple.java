import java.rmi.RemoteExeption;
import java.rmi.server.UnicastRemoteObject;

public class MQuotationsImple extends UnicastRemoteObject implementes MQuotations{
  protected MQuotationsImple() throws RemoteExeption{
    super();
  }

  public long add(long a, long b) throws RemoteException{
    return a+b;
  }
}
