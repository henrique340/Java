// Henrique Yuji Isogai Yoneoka RA: 10418153

// Bibliotecas usadas
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

// Classe nó
class Node{
  private int data;
  private Node next;
  private Node antes;

  // Construtor
  public Node(String data2){
    this.data = data2;
    this.next = next;
    this.antes = antes;
  }

  public int getData(){
    return this.data;
  }

  public Node getNext(){
    return this.next;
  }

  public Node getAnterior(){
    return this.antes;
  }

  public void setNext(Node newNode){
    this.next = newNode;
  }

  public void setAnterior(Node newNode){
    this.antes = newNode;
  }
}


// Classe Lista Duplamente Encadeada
class ListaDuplamenteEncadeada{
  private Node head;
  private Node tail;
  private int count;

  public ListaDuplamenteEncadeada(){
    head = null;
    tail = null;
    count = 0;
  }

  public void insertFront(String data){
    Node newNode = new Node(data);
    if (head == null){
      head = tail = newNode;
    } else {
      newNode.setNext(this.head);
      head.setAnterior(newNode);
      head = newNode;
    }
    count++;
  }

  public void insertBack(String linha){
    Node newNode = new Node(linha);
    if (head == null){
      head = tail = newNode;
    } else {
      tail.setNext(newNode);
      newNode.setAnterior(tail);
      tail = newNode;
    }
    count++;
  }

  public Node getFront(){
    return head;
  }

  public Node getBack(){
    return tail;
  }
}


// Main
public class EditorPrograma {
  public static void main(String[] args){
    ListaDuplamenteEncadeada lista = new ListaDuplamenteEncadeada();
    String input;
    do{
      System.out.print("\nEditor de Programas");
      System.out.println("\n-----------------------\n");
      System.out.println("Digite a opcao escolhida ou digite [:help] para help");
      System.out.print("> ");
      Scanner entrada = new Scanner(System.in);
      input = entrada.nextLine();
      // :s Lin
      if (input.startsWith(":s ")&& input.split(" ").length == 2){
        String lin = input.substring(2);
        int Lin = Integer.parseInt(lin);
        exibirConteudoLinha(Lin, lista);

      // :s LinIni LinFim
      } else if (input.startsWith(":s ") && input.split(" ").length == 3){
        String linini = input.substring(2);
        String linfim = input.substring(3);
        int LinIni = Integer.parseInt(linini);
        int LinFim = Integer.parseInt(linfim);
        exibirConteudoIniFim(LinIni, LinFim, lista);

      // :/ elemento
      } else if (input.startsWith(":/ ") && input.split(" ").length == 2){
        String elemento = input.substring(1);
        localizarElemento(elemento, lista);
      
      // :/ elem elemTroca
      } else if (input.startsWith(":/ ") && input.split(" ").length == 3){
        String elem = input.substring(2);
        String elemTroca = input.substring(3);
        trocarElementos(elem, elemTroca, lista);
      
      // :/ elem elemTroca Linha
      } else if (input.startsWith(":/ ") && input.split(" ").length == 4){
        String ELEM = input.substring(2);
        String ELEMTROCA = input.substring(3);
        String linha = input.substring(4);
        int Lin = Integer.parseInt(linha);
        trocarElementosLinha(Lin, ELEM, ELEMTROCA, lista);

      // :e nomeArquivo.ext
      } else if (input.startsWith(":e ")){
        String nomeArquivo = input.substring(2);
        abrirArquivo(nomeArquivo, lista);
      
      // :w
      } else if (input.startsWith(":w ")){
        String Arquivo = input.substring(2);
        salvarMudancasArquivos(Arquivo, lista);

      // :v LinIni LinFim
      } else if (input.startsWith(":v ")){
        String linini = input.substring(2);
        String linfim = input.substring(3);
        int LinIni = Integer.parseInt(linini);
        int LinFim = Integer.parseInt(linfim);
        marcarTexto(LinIni, LinFim, lista);
      
      // :p LinIniPaste
      } else if (input.startsWith("p ")){
        String lininipaste = input.substring(2);
        int LinIniPaste = Integer.parseInt(lininipaste);
        colarTexto(LinIniPaste, lista);
      
      // :x Lin
      } else if (input.startsWith(":x ")){
        String LIN = input.substring(2);
        int Lin = Integer.parseInt(LIN);
        apagarLinha(Lin, lista);
      
      // :xG Lin
      } else if (input.startsWith(":xG ")){
        String lin = input.substring(2);
        int Linha = Integer.parseInt(lin);
        apagarLinhaAteFin(Linha, lista);
      
      // :XG Lin
      } else if (input.startsWith(":XG ")){
        String lIn = input.substring(2);
        int linha = Integer.parseInt(lIn);
        apagarLinhaAteIni(linha, lista);
      
      // :a posLin
      } else if (input.startsWith(":a ")){
        String poslin = input.substring(2);
        int posLin = Integer.parseInt(poslin);
        editarInserirDepois(posLin, lista);
      
      // :i posLin
      } else if (input.startsWith(":i ")){
        String POSLIN = input.substring(2);
        int PosLin = Integer.parseInt(POSLIN);
        editarInserirAntes(PosLin, lista);

      } else {
        switch (input) {
          case ":help":
            help();
            break;
          case ":w":
            salvarMudancas("arquivo.txt",lista);
            break;
          case ":wq":
            salvarMudancasArquivosFinalizar("arquivo.txt", lista);
            break;
          case ":q!":
            semSalvar(lista);
            break;
          case ":ZZ":
            gravarConteudo("arquivo.txt", lista);
            break;
          case ":y":
            copiarTexto(lista);
            break;
          case ":c":
            cortarTexto(lista);
            break;
          case ":s":
            exibirConteudo(lista);
            break;
          case "o":
            editarLinhas(lista);
            break;
          default:
            System.out.println("Digite uma opcao valida");
            break;
        }
      }
    } while (!input.startsWith(":q"));
  }

  /*Funções aceitas pelo programa */
  
  // :help
  public static void help()
  {
    System.out.println("\n[:e nomeArq.ext ] - Abrir o arquivo de nome [nomeArq.ext], armazenar cada linha em um Node da lista encadeada circular.");
    System.out.println("[:w ] - Salvar as modificacoes da lista encadeada circular em arquivo.");
    System.out.println("[:w nomeArq.ext] - Salvar as modificacoes da lista encadeada circular  em arquivo de nome [nomeArq.ext].");
    System.out.println("[:wq ] - Salvar as modificacoes da lista encadeada circular em arquivo e finalizar o editor");
    System.out.println("[:q!] - Sair do editor sem salvar");
    
    System.out.println(); // Separar os comandos de 5 em 5
    
    System.out.println("[:ZZ ] - Gravar conteudo em arquivo, se alterado.");
    System.out.println("[:v LinIni LinFim] - Marcar um texto da lista da LinIni até LinFim. ");
    System.out.println("[:y] - Copiar o texto marcado para uma lista de Copia ");
    System.out.println("[:c] - Colar o texto marcado a partir da linha inicial.");
    System.out.println("[:p LinIniPaste] - Colar o texto marcado a partir da linha inicial.");
    
    System.out.println(); // Separar os comandos de 5 em 5
    
    System.out.println("[:s] - Exibir na tela o conteudo completo do programa fonte com o numero de cada linha que consta na lista.");
    System.out.println("[:s Lin] - Exibir o conteudo da linha que consta na lista na posicao [Lin]");
    System.out.println("[:s LinIni LinFim] - Exibir na tela o conteudo do programa fonte que consta na lista da linha inicial [LimIni] ate a linha final [LinFim].");
    System.out.println("[:x Lin ] - Apagar a linha de posicao [Lin] da lista.");
    System.out.println("[:xG Lin] - Apagar a partir da linha [Lin] até o final da lista.");
    
    System.out.println(); // Separar os comandos de 5 em 5
    
    System.out.println("[:XG Lin] - Apagar da linha [Lin] ate o inicio da lista.");
    System.out.println("[:/ elemento] - Percorrer a lista, localizar a(s) linha(s) na(s) qual(is) o(s) elemento(s) encontra(m)-se e exibi-las por completo.");
    System.out.println("[:/ elem elemTroca ] - Percorrer a lista, localizar o [elem] e realizar a troca por [elemTroca] em todas as linhas do codigo fonte.");
    System.out.println("[:/ elem elemTroca Linha] - Realizar a troca do [elem] por [elemTroca] na linha [Linha] do codigo fonte.");
    System.out.println("[:o] - Realizar a edicao de várias linhas, zera a lista e as insere.");
    
    System.out.println(); // Separar os comandos de 5 em 5
    
    System.out.println("[:a posLin ] - Permitir a edicao de uma ou mais linhas e inserir na lista depois da posicao posLin.");
    System.out.println("[:i posLin] - Permitir a edicao de uma ou mais linhas e inserir na lista antes da posicao posLin. ");
    System.out.println("[:help] - Apresentar na tela todas as operacoes permitidas no editor de 5 em 5 linhas.");
  }

  // :e
  public static void abrirArquivo(String arquivo, ListaDuplamenteEncadeada lista){
    try {
      // Cria um objeto File com o caminho do arquivo
      File file = new File(arquivo);
      
      // Cria um Scanner associado ao arquivo
      Scanner scanner = new Scanner(file);

      // Lê o conteúdo do arquivo linha por linha e insere na lista
      while (scanner.hasNextLine()) {
          String linha = scanner.nextLine();
          lista.insertBack(linha);
      }

      // Fecha o scanner após a leitura do arquivo
      scanner.close();
    } catch (FileNotFoundException e) {
      // Se o arquivo não for encontrado, imprime uma mensagem de erro
      System.out.println("Arquivo não encontrado: " + arquivo);
      e.printStackTrace();
    }
  }
  // :w
  public static void salvarMudancas(String arquivo,ListaDuplamenteEncadeada lista){}
  // :w nomeArq.ext
  public static void salvarMudancasArquivos(String arquivo, ListaDuplamenteEncadeada lista){}
  //:wq
  public static void salvarMudancasArquivosFinalizar(String arquivo, ListaDuplamenteEncadeada lista){}
  //:q!
  public static void semSalvar(ListaDuplamenteEncadeada lista){}
  //:ZZ
  public static void gravarConteudo(String arquivo, ListaDuplamenteEncadeada lista){}
  // :v LinIni LinFim
  public static void marcarTexto(int LinIni, int LinFim, ListaDuplamenteEncadeada lista){}
  //:y
  public static void copiarTexto(ListaDuplamenteEncadeada lista){}
  //:c
  public static void cortarTexto(ListaDuplamenteEncadeada lista){}
  //:p LinIniPaste
  public static void colarTexto(int LinIniPaste, ListaDuplamenteEncadeada lista){}
  //:S
  public static void exibirConteudo(ListaDuplamenteEncadeada lista){}
  //:s Lin
  public static void exibirConteudoLinha(int Lin, ListaDuplamenteEncadeada lista){}
  //:s LinIni LinFim
  public static void exibirConteudoIniFim(int LinIni, int LinFim, ListaDuplamenteEncadeada lista){}
  //:x Lin
  public static void apagarLinha(int Lin, ListaDuplamenteEncadeada lista){}
  //:xG Lin
  public static void apagarLinhaAteFin(int Lin, ListaDuplamenteEncadeada lista){}
  //:XG Lin
  public static void apagarLinhaAteIni(int Lin, ListaDuplamenteEncadeada lista){}
  //:elemento
  public static void localizarElemento(String elemento, ListaDuplamenteEncadeada lista){}
  //:elem elemTroca
  public static void trocarElementos(String elemento, String elementoTroca, ListaDuplamenteEncadeada lista){}
  //:elem elemTrocaLinha
  public static void trocarElementosLinha(int Lin, String elemento, String elementoTroca, ListaDuplamenteEncadeada lista){}
  //:o
  public static void editarLinhas(ListaDuplamenteEncadeada lista){}
  //:a posLin
  public static void editarInserirDepois(int posLin, ListaDuplamenteEncadeada lista){}
  // :i
  public static void editarInserirAntes(int posLin, ListaDuplamenteEncadeada lista){}
}

