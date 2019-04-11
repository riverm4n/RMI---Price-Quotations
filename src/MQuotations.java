import java.util.*;
import java.rmi.*;

/*Implementação feita baseada nos Slides da Discipina e na implementação existente no DevMedia (https://www.devmedia.com.br/uma-introducao-ao-rmi-em-java/28681)
  A geração de stubs e skeletons a partir da versão 5.0 do Java ficou mais transparente para o desenvolvedor, não requerindo mais o uso do rmic, segundo
  suspeitas (https://coderanch.com/t/659402/java/Remote-Deployment-RMI) e afirmações (https://stackoverflow.com/questions/4702882/is-rmic-still-needed) */

public interface MQuotations extends Remote {
  /*
  Lançar uma RemoteExeption em cada método declarado na interface, por se tratar de uma aplicação distribuída
  é natural que eventuais problemas relacionados a queda na rede possam vir a ocorrer.
  */
  //public double consultar(Moeda moeda1, Moeda moeda2, double value) throws RemoteException;
  public void addMoeda(String moeda) throws RemoteException;
  //public void remover(Moeda moeda) throws RemoteException;
  //public void modificar(Moeda moeda, double newPrice) throws RemoteException;

  public long add(long a, long b) throws RemoteException;
  public void initList() throws RemoteException;
}
