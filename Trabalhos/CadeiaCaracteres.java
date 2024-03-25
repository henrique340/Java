import java.util.Scanner;

// Objeto
class MinhaPilha {
  private int tamanhoMaximo;
  private char[] listaPilha;
  private int topo;

  // Construtor
  public MinhaPilha(int tamanho) {
    tamanhoMaximo = tamanho;
    listaPilha = new char[tamanhoMaximo];
    topo = -1;
  }

  // Funções
  public char pop() {
    return listaPilha[topo--];
  }

  public void push(char c) {
    listaPilha[++topo] = c;
  }
  

  public boolean isEmpty() {
    return topo == -1;
  }
}

public class CadeiaCaracteres{
  public static void main(String[] args){
    System.out.println("Digite a palavra desejada: ");
    Scanner input = new Scanner(System.in);
    String frase = input.nextLine();
    if (formaWcM(frase)){
      System.out.print("Pertence");
    } else {
      System.out.print("Falso");
    }
  }

  public static boolean formaWcM(String c){
    MinhaPilha pilha = new MinhaPilha(c.length());
    if (c.length() == 0 || c.length() % 2 == 0){
      return false;
    }

    int meio = c.length()/2;
    
    for (int i = meio; i < c.length(); i++){
      char caractere = c.charAt(i);
      pilha.push(caractere);
    }

    StringBuilder meioAnterior = new StringBuilder();
    StringBuilder meioPosterior = new StringBuilder();

    while (!pilha.isEmpty()){
      meioPosterior.append(pilha.pop());
    }

    for (int i = 0; i < meio; i++){
      char caractere2 = c.charAt(i);
      meioAnterior.append(caractere2);
    }

    for (int i = 0; i < meio; i++){
      if (meioAnterior.charAt(i) != meioPosterior.charAt(i)){
        return false;
      }
    }
    return true;
  }
}