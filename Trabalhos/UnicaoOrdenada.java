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

  public int get(int index){
    return arrayPilha[index];
  }

  public void set(int index, int num){
    arrayPilha[index] = num;
  }
}



public class UnicaoOrdenada {
  public static void main(String[] args){

    // Primeiro input
    System.out.print("\nDigite os numeros separados por virgula: ");
    Scanner scanner = new Scanner(System.in);
    String input = scanner.nextLine();        // Recebe a String inteira
    String[] fila1 = input.split(",");  // Separa os numeros por virgula
    System.out.print("\nA fila Q1 ordenada fica assim: ");
    String filaOrdenadaQ1 = ordenarUma(fila1);  // Armazena a String ordenada
    imprimirString(filaOrdenadaQ1);  // imprime a fila ordenada

    // Segundo input
    System.out.print("\nDigite outros numeros separados por virgula: ");
    Scanner scanner2 = new Scanner(System.in);
    String input2 = scanner2.nextLine();       // Recebe a String inteira
    String[] fila2 = input2.split(",");  // Separa os numeros por virgula
    System.out.print("\nA fila Q2 ordenada fica assim: ");
    String filaOrdenadaQ2 = ordenarUma(fila2);  // Armazena a String ordenada
    imprimirString(filaOrdenadaQ2);  // imprime a fila ordenada


    // Resultado novaFilaOrdenada
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
    for (i=pilha.size(); i>0; i--){
      for (j=0; j<i-1; j++){
        int num1 = pilha.get(j);
        int num2 = pilha.get(j+1);

        if (num1 < num2){
          pilha.set(j, num2);
          pilha.set(j+1, num1);
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
    for (i=novaFila.size(); i>0; i--){
      for (j=0; j<i-1; j++){
        int num1 = novaFila.get(j);
        int num2 = novaFila.get(j+1);

        if (num1 < num2){
          novaFila.set(j, num2);
          novaFila.set(j+1, num1);
        }
      }
    }

    // Construindo uma string com os elementos da pilha
    StringBuilder pilhaString2 = new StringBuilder();
    while (!novaFila.isEmpty()){
      pilhaString2.append(novaFila.pop()).append(" ");
    }
    return pilhaString2.toString().trim();
  }



  // Função para imprimir String
  public static void imprimirString(String str){
    for (int i=0; i<str.length(); i++){
      System.out.print(str.charAt(i) + " ");
    }
  }
}