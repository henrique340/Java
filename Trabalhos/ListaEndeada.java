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

public class ListaEndeada {
  public static void main(String[] args){
    LinkedList copiaLista = new LinkedList();

    int[] v = {1, 3, 5, 7, 11, 13, 17, 23, 29, 31, 41, 43};
    int n = v.length;

    // Colocando elemento no final da lista
    if (n != 0){
      for (int i=0; i<n; i++){
        copiaLista.insertBack(v[i]);
      }
    }

    // Percorrendo todos os nós
    Node atual = copiaLista.getFront();
    while (atual != null){
      System.out.println(atual.getData());
      atual = atual.getNext();
    }
  }
}
