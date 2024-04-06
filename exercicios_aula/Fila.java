class MinhaFila{
  private int tamanhoMaximo;
  private char[] listaFila;
  private int topo;
  private int inicio;

  public MinhaFila(int tamanho){
    tamanhoMaximo = tamanho;
    listaFila = new char[tamanhoMaximo];
    topo = -1;
    inicio = 0;
  }

  public void enqueue(char c){
    inicio = inicio-1;
    listaFila[inicio] = c;
  }

  public char dequeue(){
    return listaFila[--inicio];
  }
}

public class Fila{
  public static void main(String[] args){
    
  }
}