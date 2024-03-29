import java.util.Scanner;

// Objeto Minha Pilha
class MinhaPilha {
  private int tamanhoMaximo;
  private char[] arrayPilha;
  private int topo;

  public MinhaPilha(int tamanho) {
    tamanhoMaximo = tamanho;
    arrayPilha = new char[tamanhoMaximo];
    topo = -1;
  }

  // Função push
  public void push(char c) {
    arrayPilha[++topo] = c;
  }

  // Função pop
  public char pop() {
    return arrayPilha[topo--];
  }

  // Função para verificar se a pilha está vazia
  public boolean isEmpty() {
    return (topo == -1);
  }
}

public class InverterFila {
  public static void main(String[] args) {

    // Recebendo um input
    System.out.print("Digite uma frase: ");
    Scanner input = new Scanner(System.in);
    String frase = input.nextLine();

    // Chamando a função inverter
    String fraseNova = inverter(frase);

    // Imprime os caracteres da frase invertida
    for (int i = 0; i<fraseNova.length(); i++){
      System.out.print(fraseNova.charAt(i));
    }
  }

  // Função inverter
  public static String inverter(String frase){
    MinhaPilha pilha = new MinhaPilha(frase.length());
    for (int i=0; i<frase.length(); i++){
      char caractere = frase.charAt(i);         // Adiciona os caracteres na pilha
      pilha.push(caractere);
    }

    StringBuilder fraseInvertida = new StringBuilder();     // Cria uma String Builder

    while (!pilha.isEmpty()){
      fraseInvertida.append(pilha.pop());          // Adiciona os últimos caracteres na fraseInvertida
    }
    return fraseInvertida.toString();              // Transforma StringBuilder em String
  }
}
