import java.util.Scanner;

// Classe pilha
class MinhaPilha {
  private int tamanhoMaximo;
  private char[] arrayPilha;
  private int topo;
  private int contador;

  // Método construtor
  public MinhaPilha(int tamanho) {
    tamanhoMaximo = tamanho;
    arrayPilha = new char[tamanhoMaximo];
    topo = -1;
    contador = 0;
  }

  // Funções da pilha
  public void push(char c) {
    arrayPilha[++topo] = c;
    contador++;
  }

  public void clear() {
    topo = -1;
    contador = 0;
  }

  public char pop() {
    contador--;
    return arrayPilha[topo--];
  }

  public char top() {
    return arrayPilha[topo];
  }

  public int size() {
    return topo + 1;
  }

  public int count() {
    return contador;
  }

  public boolean isEmpty() {
    return (topo == -1);
  }

  public boolean isFull() {
    return (topo == tamanhoMaximo - 1);
  }
}

// Main
public class TADpilha {
  public static void main(String[] args) {
    // Input do usuário
    System.out.println("Digite a expressão:");
    Scanner entrada = new Scanner(System.in);
    String expressao = entrada.nextLine();

    if (verificarExpressao(expressao)) {
      System.out.println("Expressão OK");
    } else {
      System.out.println("Erro de correspondência");
    }
  }

  // Função para verificar expressão
  public static boolean verificarExpressao(String expressao) {
    MinhaPilha pilha = new MinhaPilha(expressao.length());

    for (int i = 0; i < expressao.length(); i++) {
      char caractere = expressao.charAt(i);

      if (caractere == '(' || caractere == '[' || caractere == '{' || caractere == '<') {
        pilha.push(caractere);
      } else if (caractere == ')' || caractere == ']' || caractere == '}' || caractere == '>') {
        if (pilha.isEmpty()) {
          return false;
        }
        char topo = pilha.pop();
        if ((caractere == ')' && topo != '(') || (caractere == ']' && topo != '[') || (caractere == '}' && topo != '{') || (caractere == '>' && topo != '<')) {
          return false;
        }
      }
    }
    return pilha.isEmpty();
  }
}
