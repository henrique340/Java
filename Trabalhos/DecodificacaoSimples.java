import java.util.Scanner;

class TadPilha{
  private int tamanhoMaximo;
  private int topo;
  private char[] arrayPilha;

  // Objeto Pilha
  public TadPilha(int tamanho){
    tamanhoMaximo = tamanho;
    arrayPilha = new char[tamanhoMaximo];
    topo = -1;
  }


  public void push(char c){
    arrayPilha[++topo] = c;
  }

  public char pop(){
    return arrayPilha[topo--];
  }

  public boolean isEmpty(){
    return topo == -1;
  }

  public int get(int index){
    return arrayPilha[index];
  }

  public void set(int index, char c){
    arrayPilha[index] = c;
  }

  public int size(){
    return tamanhoMaximo;
  }
}

// Objeto Fila
class TadFila{
  private int tamanhoMaximo;
  private int topo;
  private char[] arrayFila;
  private int inicio;

  public TadFila(int tamanho){
    tamanhoMaximo = tamanho;
    arrayFila = new char[tamanhoMaximo];
    topo = -1;
    inicio = 0;
  }

public void enfileirar(char c){
  arrayFila[++topo] = c;
}

  public int get(int index){
    return arrayFila[index];
  }

  public void set(int index, char c){
    arrayFila[index] = c;
  }

  public char desenfileirar(){
    char temp = arrayFila[inicio];
    inicio++;
    return temp;
  }

  public int size(){
    return tamanhoMaximo;
  }
}

public class DecodificacaoSimples {
  public static void main(String[] args){
    System.out.print("Digite uma frase: ");
    Scanner scanner = new Scanner(System.in);
    String input = scanner.nextLine();
    System.out.println("Palavra codificada: ");
    codificaPalavra(input);
  }



  public static void codificaPalavra(String palavra){
    TadPilha pilha = new TadPilha(palavra.length());
    TadFila fila = new TadFila(palavra.length());
    TadFila filaCodificada = new TadFila(palavra.length());
    int i;
    for (i=0; i<palavra.length(); i++){
      char letra = palavra.charAt(i);
      fila.enfileirar(letra);
      if (letra=='a' || letra=='e' || letra=='i' || letra=='o' || letra=='u' || letra=='A' ||letra=='E' ||letra=='I' ||letra=='O' ||letra=='U'){
        pilha.push(letra);
      }
    }

    for (i=0; i<pilha.size(); i++){
      if (fila.get(i)=='a' || fila.get(i)=='e' || fila.get(i)=='i' || fila.get(i)=='o' || fila.get(i)=='u' || fila.get(i)=='A' || fila.get(i)=='E' || fila.get(i)=='I' || fila.get(i)=='O' || fila.get(i)=='U'){
        filaCodificada.enfileirar(pilha.pop());
        fila.desenfileirar();
      } else {
        filaCodificada.enfileirar(fila.desenfileirar());
      }
    }

    for (i=0; i<filaCodificada.size(); i++){
      System.out.print(filaCodificada.desenfileirar() + " ");
    }
  }
}
