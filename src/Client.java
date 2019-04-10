import java.rmi.naming;

public class Client{
  public static void main(String[] args){
    try{
      MQuotations cotacao = (MQuotations) Naming.lookup("//localhost/MCotacoes");
      System.out.println("Adição: " + cotacao.add(20, 15));
    }
    catch(Exception e){
      System.out.println("Listen: " + e.getMessage());
    }
  }
}
