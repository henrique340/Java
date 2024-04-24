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

public class Clone {
  public static void main(String[] args){
    LinkedList clone = new LinkedList();
    
    int[] lista = {1,3,5,7,11,13,17,19,23,29,31,37,41};

    System.out.print("Lista: ");
    for(int i = 0; i<lista.length; i++){
      System.out.print(lista[i] + " "); //Imprimindo Lista
      clone.insertBack(lista[i]); //Adicionando elemento na lista encadeada
    }

    System.out.print("\nLista encadeada: ");
    // Percorrendo todos os nós
    Node atual = clone.getFront();
    while (atual != null){
      System.out.print(atual.getData() + " ");
      atual = atual.getNext();
    }
  }
}
