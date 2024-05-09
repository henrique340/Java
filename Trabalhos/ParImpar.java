// Henrique Yuji Isogai Yoneoka RA: 10418153
// Ex6

class Node{
  private int data;
  private Node next;

  // Construtor
  public Node(int data){
    this.data = data;
    this.next = next;
  }

  public int getData(){
    return this.data;
  }

  public Node getNext(){
    return this.next;
  }

  public void setNext(Node newNode){
    
  this.next = newNode;
  }
}

class LinkedList{
  private Node head;
  private Node tail;
  private int count;

  public LinkedList(){
    head = null;
    tail = null;
    count = 0;
  }

  public void insertFront(int data){
    Node newNode = new Node(data);
    if (head == null && tail == null){ // Se estiver vazia
      head = tail = newNode; // head e tail apontam para o novo nó
    } else {
      newNode.setNext(this.head);
      this.head = newNode; // head aponta para o nó atual
    }
    count++;
  }

  public void insertBack(int data){
    Node newNode = new Node(data);
    if (head == null && tail == null){ // Se estiver vazia
      head = tail = newNode; // head e tail apontam para o novo nó
    } else {
      tail.setNext(newNode); // next aponta para
      tail = newNode;
    }
    count++;
  }

  public Node getFront(){
    return head;
  }

  public void removeFront(){
    if (head.getNext() == null){ // Se tiver somente 1 nó
      head = tail = null; // head e tail apontam para o novo nó
    } else {
      head = head.getNext(); // head anterior se torna o head novo
    }
    count--;
  }

  public void removeBack(){
    if (head.getNext() != null){ // Se tiver somente 1 nó
      head = tail = null; // head e tail apontam para o novo nó
      count = 0;
      return;
    }
    Node atual = head;

    // Procura pelo último termo
    while(atual.getNext() != tail){
      atual = atual.getNext();
    }
    atual.setNext(null); // Atual se torna o último nó
    tail = atual;
    count--;
  }

  public void removeData(int data){
    if (head == null){
      System.out.println("Nó vazio");
      return;
    }
    Node anterior = head;
    Node atual = head.getNext();

    // Exceção dado estiver no head
    if (data == anterior.getData()){
      removeFront();
      return;
    }

    // Percorrendo todos os nós
    while (atual != null){
      if (atual.getData() == data){
        anterior.setNext(atual.getNext()); // Nó anterior se torna o nó depois do atual
        if (atual.getNext() == null){ // Se atual == data for o último nó
          tail = anterior; // Tail aponta para o nó anterior (atual último nó)
        }
        count--;
        return;
      }
      anterior = atual;
      atual = atual.getNext();
    }
  }
}

public class ParImpar {
  public static void main(String[] args){
    LinkedList listaEncadeada = new LinkedList();

    // Adicionando números nos nós
    listaEncadeada.insertFront(1);
    listaEncadeada.insertFront(2);
    listaEncadeada.insertFront(3);
    listaEncadeada.insertFront(4);
    listaEncadeada.insertFront(5);
    listaEncadeada.insertFront(6);
    listaEncadeada.insertFront(7);

    // Percorrendo todos os Nós
    Node atual = listaEncadeada.getFront();
    while (atual != null){
      if (atual.getData() % 2 == 0){
        int valor = atual.getData();
        listaEncadeada.removeData(atual.getData());
        listaEncadeada.insertFront(valor); // Insere os pares no início do nó
      }
      atual = atual.getNext();
    }

    // Percorrendo o nó e imprimindo os valores
    atual = listaEncadeada.getFront();
    while (atual != null){
      System.out.println(atual.getData());
      atual = atual.getNext();
    }
  }
}
