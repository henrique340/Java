class MinhaPilha{
  private int tamanhoMaximo;
  private char[] listaPilha;
  private int topo;

  public MinhaPilha(int tamanho){
    tamanhoMaximo = tamanho;
    listaPilha = new char[tamanhoMaximo];
    topo = -1;
  }

  public void push(char c){
    listaPilha[topo++] = c;
  }

  public char pop(){
    return listaPilha[--topo];
  }

  public boolean isEmpty(){
    return topo == -1;
  }
}

public class Pilha{
  public static void main(String[] args){

  }
}