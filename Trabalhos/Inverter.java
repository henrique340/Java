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

// Main
public class Inverter {
  public static void main(String[] args) {
    System.out.println("Digite uma frase: ");
    Scanner input = new Scanner(System.in);
    String frase = input.nextLine();

    // Dividir a frase em palavras
    String[] palavras = frase.split(" ");

    for (String palavra : palavras) {
      String palavraInvertida = InverterPalavra(palavra);
      System.out.print(palavraInvertida + " ");
    }
  }


  // Função Inverter Palavra
  public static String InverterPalavra(String palavra) {
    MinhaPilha pilha = new MinhaPilha(palavra.length());

    // Preenche a pilha com os caracteres da palavra
    for (int i = 0; i < palavra.length(); i++) {
      char caractere = palavra.charAt(i);
      pilha.push(caractere);
    }

    //StringBuilder é uma String mutável
    StringBuilder palavraInvertida = new StringBuilder();

    // Desempilha os caracteres e constrói a palavra invertida
    while (!pilha.isEmpty()) {
      palavraInvertida.append(pilha.pop());
    }

    // StringBuilder -> String
    return palavraInvertida.toString();
  }
}
