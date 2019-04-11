import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.*;

public class MQuotationsImple extends UnicastRemoteObject implements MQuotations{
  public LinkedList<Moeda> moedas = new LinkedList<Moeda>();

  protected MQuotationsImple() throws RemoteException{
    super();
  }

  public long add(long a, long b) throws RemoteException{
    return a+b;
  }

  public boolean invalidInsertions(String nomeDaMoeda) {
    Iterator<Moeda> moedasIterator = moedas.iterator();

    while(moedasIterator.hasNext()){
      if(moedasIterator.next().getName() == nomeDaMoeda) {
    	  System.out.println("Moeda já existente!");
    	  return true; //Se a moeda já está inserida na lista do servidor, invalidInsertions é verdadeiro pois é uma inserção inválida.
      }
    }

    return false;
  }

  public void addMoeda(String nomeDaMoeda) {
	  if(invalidInsertions(nomeDaMoeda) == false){
		  Moeda novaMoeda = new Moeda(nomeDaMoeda);
      //Adiciona ao fim da lista do servidor
      moedas.add(novaMoeda);
      System.out.println(nomeDaMoeda + " inserida com sucesso!");
    }
  }

  public void atualizaAdicionados(String nomeDaMoeda){
    Iterator<Moeda> iterator = moedas.iterator();
    Hashtable<String, Double> hashCotacoes;

    Moeda novaMoeda = moedas.getLast(); //Recupera a última da lista do servidor

    while(iterator.hasNext()){
      Moeda atual = iterator.next();
      if(!atual.equals(novaMoeda)){
        atual.addQuotation(nomeDaMoeda, 0.0); //0 - Valor default
        System.out.println(atual.getName() + " adicionado a lista de cotações de " + novaMoeda.getName() + " com o valor default");
        novaMoeda.addQuotation(atual.getName(), 0.0);
        System.out.println(novaMoeda.getName() + " adicionado a lista de cotações de " + atual.getName() + " com o valor default");
      }
    }
  }

  public void removeMoeda (String nomeDaMoeda){
    Iterator<Moeda> iterator = moedas.iterator();

    while(iterator.hasNext()){
      Moeda aRemover = iterator.next();
      if(aRemover.getName() == nomeDaMoeda){
        moedas.remove(aRemover);
        atualizaRemovidos(aRemover);
      }
    }
  }

  public void atualizaRemovidos(Moeda moeda){
    Iterator<Moeda> iterator = moedas.iterator();
    Hashtable<String, Double> hashCotacoes = new Hashtable<String, Double>();

    while(iterator.hasNext()){
      Moeda atual = iterator.next();
      hashCotacoes = atual.getQuotations();
      hashCotacoes.remove(moeda.getName());

      System.out.println(moeda.getName() + " removido com sucesso das cotações de " + atual.getName());
    }
  }

  public void modificaCotacao(String moeda1, String moeda2, Double novaCotacao){
    Iterator<Moeda> iterator = moedas.iterator();

    while(iterator.hasNext()){
      Moeda atual = iterator.next();
      if(atual.getName() == moeda1){
        atual.changeQuotation(moeda2, novaCotacao);
        System.out.println("O " + moeda2 + " cresceu! Agora 1 " + moeda1 + " custa " + novaCotacao.toString() + " " + moeda2);
      }
      else if(atual.getName() == moeda2){
        double reverse = (1/novaCotacao); //Divisão que representa a cota reversa.
        atual.changeQuotation(moeda1, (1/novaCotacao));
        System.out.println("O " + moeda1 + " desvalorizou! Agora 1 " + moeda2 + " custa " + Double.toString(reverse) + " " + moeda1);
      }
    }
  }

  public double consulta(String moeda1, String moeda2, Double valor){
    Iterator<Moeda> iterator = moedas.iterator();
    double valorCambiado;

    while(iterator.hasNext()){
      Moeda atual = iterator.next();
      if(atual.getName() == moeda1){
        valorCambiado = atual.consulta(moeda2, valor);

        if(valorCambiado > 0){
          System.out.println(Double.toString(valor) + " " + moeda1 + " é equivalente a " + Double.toString(valorCambiado) + " " + moeda2);
          return valorCambiado;
        }
        else{
          System.out.println("Ainda não há uma cotação entre as moedas: " + moeda1 + " e " + moeda2 + " ainda, mas você pode adicionar manualmente!");
        }
      }
    }

    return 0.0;
  }

  public void initList(){
    addMoeda("BRL - Real Brasileiro (R$)");
    addMoeda("USD - Dólar Americano (U$$)");
    addMoeda("EUR - Euro (€)");
    addMoeda("GBP - Libra Esterlina (£)");
    addMoeda("JPY - Iene (¥)");
    addMoeda("AUD - Dólar Australiano ($)");
    addMoeda("CHF - Fraco Suíco (Fr)");
    addMoeda("CAD - Dólar Canadiano ($)");
    addMoeda("SGD - Dólar de Singapura ($)");
    addMoeda("HKD - Dólar de Hong Kong ($)");
    addMoeda("THB - Baht - Tailândia (฿)");
    addMoeda("SEK - Coroa Sueca (kr)");
    addMoeda("NOK - Coroa Norueguesa (kr)");
    addMoeda("CNY - Yuan - China (元)");
    addMoeda("DKK - Coroa Dinamarquesa (kr)");
    addMoeda("RUB - Rublo - Rússia (₽)");
    addMoeda("ZAR - Rand Sul-Africano (R)");
    addMoeda("NZD - Dólar da Nova Zelândia ($)");
    addMoeda("MXN - Peso Mexicano ($)");
    addMoeda("TRY - Lira Turca");
    addMoeda("HUR - Foring - Hungria (Ft)");
    addMoeda("ARS - Peso Argentino ($)");
    addMoeda("BOB - Boliviano (Bs)");
    addMoeda("BGN - Lev Búlgaro (лв)");
    addMoeda("CZK - Coroa Checa (Kč)");
    addMoeda("CLP - Peso Chileno ($)");
    addMoeda("INR - Rupia Indiana");
    addMoeda("ILS - Novo Siclo Isrealita (₪)");
    addMoeda("VES - Bolívar Venezuelano (Bs S)");
    addMoeda("BTC - Bitcoin (₿)");


    //Testes:
    Iterator<Moeda> iterator = moedas.iterator();

    while(iterator.hasNext()){
      Moeda atual = iterator.next();
      atualizaAdicionados(atual.getName());
      System.out.println("Moeda: " + atual.getName());
    }

    removeMoeda("VES - Bolívar Venezuelano (Bs S)");
    modificaCotacao("BRL - Real Brasileiro (R$)", "USD - Dólar Americano (U$$)", 3.83);
    consulta("BRL - Real Brasileiro (R$)", "USD - Dólar Americano (U$$)", 50.0);
  }
}
