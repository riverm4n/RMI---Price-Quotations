import java.rmi.*;
import java.util.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.text.DecimalFormat;

public class Client{
  //Construtor, responsável sobretudo pela interface gráfica.
  /*public Client(){
    Container panel = getContentPane();
    final JLabel lbQ0 = new JLabel("Consultar cotações");
    final JLabel lbQf = new JLabel("Cadastrar Moeda");
    final JLabel lbT = new JLabel("Remover Moeda");
    final JTextField valorConsulta = new JTextField(7);
    final JTextField patrimonioDesejado = new JTextField(7);
    final JTextField tempo =  new JTextField(7);
    JButton ok = new JButton("REVELAR");
    final JTextArea area = new JTextArea(50, 50);
  }*/

  public static void main(String[] args){
    try{
      MQuotations cotacao = (MQuotations) Naming.lookup("//localhost:2019/MCotacoes");

      //Comentar a seguinte parte abaixo e substituir as variáveis logo abaixo.
      /*
      System.out.println("Digite dois números: ");
      int num1, num2;
      Scanner scanner = new Scanner(System.in);
      num1 = scanner.nextInt();
      num2 = scanner.nextInt();

      System.out.println("Adição: " + cotacao.add(num1, num2));*/
      cotacao.initList();
    }
    catch(Exception e){
      System.out.println("Listen: " + e.getMessage());
    }
  }
}
