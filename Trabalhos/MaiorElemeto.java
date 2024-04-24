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

public class MaiorElemeto {
  public static void main(String[] args){
    LinkedList listaEncadeada = new LinkedList();

    listaEncadeada.insertFront(0);
    listaEncadeada.insertFront(1);
    listaEncadeada.insertFront(2);
    listaEncadeada.insertFront(3);
    listaEncadeada.insertFront(4);
    listaEncadeada.insertFront(5);

    // Percorrendo todos os nós da lista
    Node atual = listaEncadeada.getFront();
    int maior = atual.getData();
    while (atual != null){
      if (atual.getData() > maior){
        maior = atual.getData();
      }
      atual = atual.getNext();
    }
    System.out.println("O maior elemento é: " + maior);
  }
}
