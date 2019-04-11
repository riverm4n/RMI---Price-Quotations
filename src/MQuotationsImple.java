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
      moedas.add(novaMoeda);
      System.out.println(nomeDaMoeda + " inserida com sucesso!");
    }
  }

  public void removeMoeda(String nomeDaMoeda){
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

    Iterator<Moeda> iterator = moedas.iterator();

    while(iterator.hasNext()){
      System.out.println("Moeda: " + iterator.next().getName());
    }

    removeMoeda("VES - Bolívar Venezuelano (Bs S)");
  }
}
