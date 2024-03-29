import java.util.Scanner;

class MinhaPilha{
  private int tamanhoMaximo;
  private int topo;
  private int[] arrayPilha;

  public MinhaPilha(int tamanho){
    tamanhoMaximo = tamanho;
    arrayPilha = new int[tamanhoMaximo];
    topo = -1;
  }

  // Função size
  public int size(){
    return tamanhoMaximo;
  }

  // Função push
  public void push(int num){
    arrayPilha[++topo] = num;
  }

  // Função pop
  public int pop(){
    return arrayPilha[topo--];
  }

  // Função para verificar se a pilha está vazia
  public boolean isEmpty(){
    return topo == -1;
  }
}



public class UnicaoOrdenada {
  public static void main(String[] args){

    // Primeiro input
    System.out.print("Digite os numeros separados por virgula: ");
    Scanner scanner = new Scanner(System.in);
    String input = scanner.nextLine();        // Recebe a String inteira
    String[] fila1 = input.split(",");  // Separa os numeros por virgula
    System.out.println("A fila Q1 ordenada fica assim: ");
    String filaOrdenadaQ1 = ordenarUma(fila1);  // Armazena a String ordenada
    imprimirString(filaOrdenadaQ1);

    // Segundo input
    System.out.println("\nDigite outros números separados por virgula: ");
    Scanner scanner2 = new Scanner(System.in);
    String input2 = scanner2.nextLine();       // Recebe a String inteira
    String[] fila2 = input2.split(",");  // Separa os numeros por virgula
    System.out.println("A fila Q2 ordenada fica assim: ");
    String filaOrdenadaQ2 = ordenarUma(fila2);  // Armazena a String ordenada
    imprimirString(filaOrdenadaQ2);

    System.out.println("\nA nova fila fica assim: ");
    String novaFilaOrdenada = ordenarDuas(fila1, fila2);
    imprimirString(novaFilaOrdenada);
  }



  // Função para ordenar uma String
  public static String ordenarUma(String[] fila){
    MinhaPilha pilha = new MinhaPilha(fila.length);
    int i, j;

    for (i = 0; i<fila.length; i++){
      int numero = Integer.parseInt(fila[i].trim());  // Transforma char em int
      pilha.push(numero);
    }

    // Ordenação em si (Bubble Sort)
    for (i=0; i<pilha.size() -1; i++){
      for (j=0; j<pilha.size() -i; j++){
        int num1 = pilha.pop();   // Armazena o último termo
        int num2 = pilha.pop();   // Armazena o penúltimo termo
        if (num1 > num2){
          pilha.push(num1);
          pilha.push(num2);
        } else {
          pilha.push(num2);
          pilha.push(num1);
        }
      }
    }

    // Construindo uma string com os elementos da pilha
    StringBuilder pilhaString = new StringBuilder();
    while (!pilha.isEmpty()){
      pilhaString.append(pilha.pop()).append(" ");
    }
    return pilhaString.toString().trim();
  }



  //Função para ordenar duas Strings
  public static String ordenarDuas(String[] fila1, String[] fila2){
    MinhaPilha novaFila = new MinhaPilha(fila1.length+fila2.length);
    int i, j;

    // Primeira String
    for (i = 0; i<fila1.length; i++){
      int numero = Integer.parseInt(fila1[i].trim());  // Transforma char em int
      novaFila.push(numero);
    }

    // Segunda String
    for (i = 0; i<fila2.length; i++){
      int num = Integer.parseInt(fila2[i].trim());   // Transforma char em int
      novaFila.push(num);
    }

    // Ordenação em si (Bubble Sort)
    for (i=0; i<novaFila.size(); i++){
      for (j=0; j<novaFila.size(); j++){
        int num1 = novaFila.pop();   // Armazena o último termo
        int num2 = novaFila.pop();   // Armazena o penúltimo termo
        if (num1 > num2){
          novaFila.push(num1);
        } else {
          novaFila.push(num2);
        }
      }
    }

    // Construindo uma string com os elementos da pilha
    StringBuilder pilhaString = new StringBuilder();
    while (!novaFila.isEmpty()){
      pilhaString.append(novaFila.pop()).append(" ");
    }
    return pilhaString.toString().trim();
  }



  // Função para imprimir String
  public static void imprimirString(String str){
    for (int i=0; i<str.length(); i++){
      System.out.print(str.charAt(i) + " ");
    }
  }
}