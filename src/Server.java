import java.rmi.Naming;
import java.rmi.registry.*;

public class Server{
  public Server(){
    try{
      MQuotations mquotations = new MQuotationsImple();
      //O alvo do método rebind() é o registro RMI que deve ser atualizado com a porta que queremos acessar no servidor.
      LocateRegistry.createRegistry(2019);
      Naming.rebind("rmi://localhost:2019/MCotacoes", mquotations);
      System.out.println("Server running on port 2019");
    }
    catch(Exception e){
      System.out.println("Listen: " + e.getMessage());
    }
  }

  public static void main(String[] args){
    new Server();
  }
}
