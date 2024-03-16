// Bibliotecas

import java.util.Scanner;

// Objeto
class MinhaPilha{
  private int tamanhoMaximo;
  private char[] listaPilha;
  private int topo;

  // Construtor
  public MinhaPilha(int tamanho){
    tamanhoMaximo = tamanho;
    listaPilha = new char[tamanhoMaximo];
    topo = -1;
  }

  // Funções
  public char pop(){
    return listaPilha[topo--];
  }

  public char push(char c){
    return listaPilha[++topo] = c;
  }

  public boolean isFull(){
    if (topo-1 == tamanhoMaximo){
      return true;
    }else{
      return false;
    }
  }
}

// Main
public class Inverter{
  public static void main(String[] args){
    System.out.println("Digite uma frase: ");
    Scanner input = new Scanner(System.in);
    String frase = input.nextLine();
  }

  public static void InverterExpressao(String frase){
    MilhaPilha pilha = new MinhaPilha(frase.length());
    
    for (int i = frase.length()-1; i >= 0; i--){
      char caractere = frase.charAt(i);
      if (caractere != ' '){
        pilha.push(caractere);
      }

    }

  }
}