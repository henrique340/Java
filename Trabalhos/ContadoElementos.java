// Henrique Yuji Isogai Yoneoka RA: 10418153
// Ex1

class Node{
  private int data;
  private Node next;

  // Construtor
  public Node(int data){
    this.data = data;
    this.next = null;
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
    if (head == null){
      head = tail = newNode;
    } else {
      newNode.setNext(this.head);
      this.head = newNode;
    }
    count++;
  }

  public void insertBack(int data){
    Node newNode = new Node(data);
    if (head == null){
      head = tail = newNode;
    } else {
      tail.setNext(newNode);
      tail = newNode;
    }
    count++;
  }

  public Node getFront(){
    return head;
  }
}

public class ContadoElementos{
  public static void main(String[] args){
    LinkedList listaEncadeada = new LinkedList();

    // Inserindo elementos
    listaEncadeada.insertFront(0);
    listaEncadeada.insertFront(1);
    listaEncadeada.insertFront(2);
    listaEncadeada.insertFront(3);
    listaEncadeada.insertFront(4);
    listaEncadeada.insertFront(5);

    int contador = 0;

    // Percorrendo todos os nós
    Node atual = listaEncadeada.getFront();
    while (atual != null){
      if (atual.getData() %2 == 0){ // Contador para números pares
        contador += 1;
      }
      atual = atual.getNext();
    }
    System.out.println("Os nós pares são: " + contador);
  }
}