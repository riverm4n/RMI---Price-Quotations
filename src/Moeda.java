import java.util.*;

public class Moeda{
  private String nome;
  private Hashtable<String, Double> quotes;

   //Cada tabela hash é utilizada para armazenar a cotação da moeda com as demais. A chave é a moeda e o valor é a sua cotação.
  public Moeda(String nome){
    this.nome   = nome;
    this.quotes = new Hashtable<String, Double>();
  }

  public String getName(){
    return this.nome;
  }

  public Hashtable<String, Double> getQuotations(){
    return this.quotes;
  }

  public boolean doesItHave(String moedaNome){
    if(quotes.contains(moedaNome) == true)
      return true;
    else
      return false;
  }

  //Método que adiciona uma Moeda a lista de cotações de outra moeda.
  public void addQuotation(String moeda, Double quote){
    if(quote < 0) //0 é o valor básico, quer dizer que ainda não há uma cotação associada e deve solicitar ao cliente para que adicione a cotação (através do "modificar cotação").
      System.out.println("Valor inválido! Por favor, insira um valor positivo para a cotação da moeda.");
    else if(!quotes.contains(moeda)){
      quotes.put(moeda, quote);
    }
  }

  public void changeQuotation(String moeda, Double quote){
    //Fazer tratativa do lado do cliete!
    this.quotes.remove(moeda);

    //Jeito aparentemente mais trivial porém nesse horário foi o melhor que pude pensar.
    this.quotes.put(moeda, quote);
  }
}
