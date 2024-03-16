import java.util.Scanner;

// Objeto
class MinhaPilha {
  private int tamanhoMaximo;
  private int[] listaPilha;
  private int topo;

  // Construtor
  public MinhaPilha(int tamanho) {
    tamanhoMaximo = tamanho;
    listaPilha = new int[tamanhoMaximo];
    topo = -1;
  }

  // Funções
  public int pop() {
    return listaPilha[topo--];
  }

  public void push(int c) {
    listaPilha[++topo] = c;
  }
  

  public boolean isEmpty() {
    return topo == -1;
  }
}

public class Fatoracao {
  public static void main(String[] args){
    System.out.println("Digite um número inteiro: ");
    Scanner input = new Scanner(System.in);
    int num = input.nextInt();
    fatorial(num);
    input.close();
  }

  // Função para fazer o fatorial
  public static void fatorial(int num){
    MinhaPilha pilha = new MinhaPilha(100);
    int divisor = 2;

    // Loop até o número não ter mais divisor
    while (num != 1){
      if (num % divisor == 0){
        // Adiciona para a pilha
        pilha.push(divisor);
        num = num/divisor;
      } else {

        // Adiciona um para o divisor até achar todos os divisores
        divisor++;
      }
    }

    // Tratamento de excessão do asterisco
    boolean excessaoAsterisco = true;

    // Loop até a pilha ficar vazia
    while (!pilha.isEmpty()){
      if (excessaoAsterisco == false){  // Coloca * na frente
        System.out.print(" * ");
      } else {
        excessaoAsterisco = false;
      }
      System.out.print(pilha.pop());  // A primeira chamada da fatorial não coloca * na frente
    }
  }
}