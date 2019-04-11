import java.rmi.*;
import java.util.*;

public class Client{
  public static void main(String[] args){
    try{
      MQuotations cotacao = (MQuotations) Naming.lookup("//localhost:2019/MCotacoes");

      System.out.println("Digite dois números: ");

      //Comentar a seguinte parte abaixo e substituir as variáveis logo abaixo.
      int num1, num2;
      Scanner scanner = new Scanner(System.in);
      num1 = scanner.nextInt();
      num2 = scanner.nextInt();

      System.out.println("Adição: " + cotacao.add(num1, num2));
    }
    catch(Exception e){
      System.out.println("Listen: " + e.getMessage());
    }
  }
}
