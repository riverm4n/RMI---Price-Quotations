import java.rmi.*;

public class Server{
  public Server(){
    try{
      MQuotations mquotations = new MQuotations();
      Naming.rebind("rmi://localhost/MCotacoes", mquotations);
    }
    catch(Exception e){
      System.out.println("Listen: " + e.getMessage());
    }
  }

  public static void main(String[] args){
    new Server();
  }
}
