import java.rmi.*;

public interface MQuotations extends Remote {
  /*
  Lançar uma RemoteExeption em cada método declarado na interface, por se tratar de uma aplicação distribuída
  é natural que eventuais problemas relacionados a queda na rede possam vir a ocorrer.
  */
  public void consultar(Moeda moeda) throws RemoteExeption;
  public void cadastrar(String moeda, double price) throws RemoteExeption;
  public void remover(Moeda moeda) throws RemoteExeption;
  public void modificar(Moeda moeda) throws RemoteExeption;
}
