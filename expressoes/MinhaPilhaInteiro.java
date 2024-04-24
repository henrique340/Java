package expressoes;

class MinhaPilhaInteiro {
  private int tamanhoMaximo;
  private int[] listaPilha;
  private int topo;

  public MinhaPilhaInteiro(int tamanho) {
    tamanhoMaximo = tamanho;
    listaPilha = new int[tamanhoMaximo];
    topo = -1;
  }

  public void push(int valor) {
    listaPilha[++topo] = valor;
  }

  public int pop() {
    if (isEmpty()) {
      System.out.println("A pilha está vazia");
      return 0; // Retorna 0 ou outro valor padrão se a pilha estiver vazia
    }
    return listaPilha[topo--];
  }

  public boolean isEmpty() {
    return topo == -1;
  }
}
