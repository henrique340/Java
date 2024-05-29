
/*------------------------- */
/*       BIBLIOTECAS        */
/*------------------------- */

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileWriter;

/*------------------------- */
/*        CLASSE NO         */
/*------------------------- */

class Node{
  private String data;
  private Node next;
  private Node antes;

  // Construtor
  public Node(String data){
    this.data = data;
    this.next = next;
    this.antes = antes;
  }

  public String getData(){
    return this.data;
  }

  public Node getNext(){
    return this.next;
  }

  public Node getAnterior(){
    return this.antes;
  }

  public void setData(String data){
    this.data = data;
  }

  public void setNext(Node newNode){
    this.next = newNode;
  }

  public void setAnterior(Node newNode){
    this.antes = newNode;
  }
}


/*------------------------- */
/*  CLASSE LISTA ENCADEADA  */
/*------------------------- */

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

  public void encerrarLista() {
    Node current = head;
    while (current != null) {
        Node next = current.getNext();
        current.setNext(null); // Define o próximo nó como null
        current = next; // Avança para o próximo nó
    }
    head = null; // Define o head da lista como null
  }

  public int getTamanho(){
    return count;
  }

  public void setFront(Node head){
    this.head = head;
  }

  public void setBack(Node tail){
    this.tail = tail;
  }
}


/*------------------------- */
/*      MENU PRINCIPAL      */
/*------------------------- */

public class EditorPrograma {
  public static void main(String[] args){
    ListaDuplamenteEncadeada lista = new ListaDuplamenteEncadeada();
    ListaDuplamenteEncadeada copia = new ListaDuplamenteEncadeada();
    String input;
    do{
      System.out.print("\n-----------------------\n");
      System.out.print("Editor de Programas");
      System.out.print("\n-----------------------\n");
      System.out.println("Digite a opcao escolhida ou digite [:help] para help");
      System.out.print("> ");
      Scanner entrada = new Scanner(System.in);
      input = entrada.nextLine();

      // :e nomeArq.ext
      if (input.startsWith(":e ")){
        String nomeArquivo = input.substring(2);
        abrirArquivo(nomeArquivo, lista);
        System.out.println("O arquivo foi armazenado na lista encadeada");

      // :w
      } else if (input.equals(":w")){
        salvarMudancas("arquivo.txt",lista);

      // :w nomeArq.ext
      } else if (input.startsWith(":w ")){
        String Arquivo = input.substring(2);
        salvarMudancasArquivos(Arquivo, lista);

      // :wq
      } else if (input.equals(":wq")){
        salvarMudancasArquivosFinalizar("arquivo.txt", lista);
        System.exit(0);
      
      // :q!
      } else if (input.equals(":q!")){
        semSalvar(lista);

      // :ZZ
      } else if (input.equals(":ZZ")){
        gravarConteudo("arquivo.txt", lista);

      // :v LinIni LinFim
      } else if (input.startsWith(":v ")){
        String[] parts = input.split(" ");
        if (parts.length == 3) {
          int LinIni = Integer.parseInt(parts[1].trim()); // Remove espaços em branco
          int LinFim = Integer.parseInt(parts[2].trim());
          marcarTexto(LinIni, LinFim, lista, copia);
        }

      // :y
      } else if (input.startsWith(":y")){
        copiarTexto(lista, copia);

      // :c
      } else if (input.startsWith(":c")){
        cortarTexto(lista, copia);
      
      // :p LinIniPaste
      } else if (input.startsWith(":p ")){
        String[] partes = input.split(" ");
        if (partes.length == 2){
          int lininipaste = Integer.parseInt(partes[1].trim());
          colarTexto(lininipaste, lista, copia);
        }

      // :s
      } else if (input.equals(":s")){
        exibirConteudo();

      // :s Lin
      } else if (input.startsWith(":s ")){
        String[] separar = input.split(" ");
        if (separar.length == 2){
          int Lin = Integer.parseInt(separar[1].trim());
          exibirConteudoLinha(Lin, lista);

        // :s LinIni LinFim
        } else if (separar.length == 3){
          int LinIni = Integer.parseInt(separar[1].trim());
          int LinFim = Integer.parseInt(separar[2].trim());
          exibirConteudoIniFim(LinIni, LinFim);
        }
      
      // :x Lin
      } else if (input.startsWith(":x ")){
        String[] partes = input.split(" ");
        if (partes.length == 2){
          int LIN = Integer.parseInt(partes[1].trim());
          apagarLinha(LIN, lista);
          System.out.println("Linha " + LIN + " apagada com sucesso");
        }
        
      
      // :xG Lin
      } else if (input.startsWith(":xG ")){
        String[] partes = input.split(" ");
        if (partes.length == 2){
          int Linha = Integer.parseInt(partes[1].trim());
          apagarLinhaAteFin(Linha, lista);
          System.out.println("Linhas deletadas com sucesso");
        }
      
      // :XG Lin
      } else if (input.startsWith(":XG ")){
        String[] partes = input.split(" ");
        if (partes.length == 2){
          int linha = Integer.parseInt(partes[1].trim());
          apagarLinhaAteIni(linha, lista);
          System.out.println("Linhas deletadas com sucesso");
        }

      // :/ elemento
      } else if (input.startsWith(":/ ")){
        String[] partes = input.split(" ");
        if (partes.length == 2){
          String elemento = partes[1];
          localizarElemento(elemento ,lista);
          System.out.println("Leitura realizada");
        // :/ elem elemTroca
        } else if(partes.length == 3){
          String elem = partes[1];
          String elemTroca = partes[2];
          trocarElementos(elem, elemTroca, lista);
        
        // :/ elem elemTroca Linha
        } else if (partes.length == 4){
          String elem = partes[1];
          String elemTroca = partes[2];
          int Linha = Integer.parseInt(partes[3]);
          trocarElementosLinha(Linha, elem, elemTroca, lista);
        }

      // :o
      } else if (input.equals(":o")){
        editarLinhas(lista);

      // :a posLin
      } else if (input.startsWith(":a ")){
        String[] partes = input.split(" ");
        if (partes.length == 2){
          int posLin = Integer.parseInt(partes[1].trim());
          editarInserirDepois(posLin, lista);
        }
      
      // :i posLin
      } else if (input.startsWith(":i ")){
        String[]partes = input.split(" ");
        if (partes.length == 2){
          int PosLin = Integer.parseInt(partes[1].trim());
          editarInserirAntes(PosLin, lista);
        }
      
      // help
      } else if (input.equals(":help")){
        help();

      } else {
        System.out.println("Digite uma opcao valida");
      }
    } while (!input.startsWith(" "));
  }

/*------------------------- */
/*   FUNCOES DO PROGRAMA    */
/*------------------------- */

  // :e
  public static void abrirArquivo(String arquivo, ListaDuplamenteEncadeada lista){
    // Limpa a lista
    lista.encerrarLista();

    try {
      File file = new File(arquivo);

      // Verifica se arquivo existe
      if (!file.exists()){
        file.createNewFile();
        System.out.println("Arquivo criado: " + arquivo);
      }

      // Lê o conteúdo do arquivo e insere na lista
      Scanner scanner = new Scanner(file);
      while (scanner.hasNextLine()) {
        String linha = scanner.nextLine();
        lista.insertBack(linha);
      }

    } catch (FileNotFoundException e) {
      System.out.println("Arquivo não encontrado: " + arquivo);
      e.printStackTrace();
    } catch (Exception e) { e.printStackTrace(); }
  }


  // :w
  public static void salvarMudancas(String arquivo,ListaDuplamenteEncadeada lista){

    // Cria os arquivos file e temp_file
    File file = new File(arquivo);
    File temp_file = new File("temporario.ext");

    // Escreve o conteudo das listas no arquivo temporario
    try (PrintWriter writer = new PrintWriter(new FileWriter(temp_file))) {
      Node atual = lista.getFront();
      while (atual != null) {
        writer.println(atual.getData());
        atual = atual.getNext();
      }
    System.out.println("Conteudo da lista salvo em: " + arquivo);
    } catch (IOException e) {
      System.out.println("Erro ao salvar o arquivo: " + arquivo);
      e.printStackTrace();
    }

    // Deleta file e renomeia file_temp para file
    file.delete();
    temp_file.renameTo(file);

    lista.encerrarLista(); // limpa a lista
  }


  // :w nomeArq.ext
  public static void salvarMudancasArquivos(String arquivo, ListaDuplamenteEncadeada lista){

    // Cria os arquivos file e temp_file
    File file = new File(arquivo);
    File temp_file = new File("temporario.ext");

    // Escreve o conteudo da lista em temp_file
    try (PrintWriter writer = new PrintWriter(new FileWriter(temp_file))) {
      Node atual = lista.getFront();
      while (atual != null) {
        writer.println(atual.getData());
        atual = atual.getNext();
      }
    System.out.println("Conteudo da lista salvo em: " + arquivo);
    } catch (IOException e) {
      System.out.println("Erro ao salvar o arquivo: " + arquivo);
      e.printStackTrace();
    }

    // Deleta file e renomeia temp_file para file
    file.delete();
    temp_file.renameTo(file);

    lista.encerrarLista(); // Limpa a lista
  }


  //:wq
  public static void salvarMudancasArquivosFinalizar(String arquivo, ListaDuplamenteEncadeada lista){
    // Cria um arquivo
    File file = new File(arquivo);

    // Escreve o conteudo da lista no arquivo
    try (PrintWriter writer = new PrintWriter(new FileWriter(arquivo, file.exists()))) {
      Node atual = lista.getFront();
      while (atual != null) {
        writer.println(atual.getData());
        atual = atual.getNext();
      }
      System.out.println("Conteudo da lista salvo em: " + arquivo);
      System.out.println("Saindo do editor ...");
    } catch (IOException e) {
      System.out.println("Erro ao salvar o arquivo: " + arquivo);
      e.printStackTrace();
    }
  }


  //:q!
  public static void semSalvar(ListaDuplamenteEncadeada lista){

    // Imprime mensagem na tela
    System.out.println("Digite [0] para sair");
    System.out.println("Digite [1] para continuar");
    System.out.print("> ");

    // Leitura da resposta
    Scanner scanner = new Scanner(System.in);
    int opc = scanner.nextInt();
    if (opc == 0) {
      System.out.println("Saindo do editor ...");
      System.exit(0);
    } else {
      System.out.println("Voltando para o menu principal");
    }
  }


  //:ZZ
  public static void gravarConteudo(String arquivo, ListaDuplamenteEncadeada lista){

    // Criando arquivos
    File file = new File(arquivo);
    File temp_file = new File("temporario.ext");

    // Escrevendo o conteudo da lista no arquivo temporario
    try (PrintWriter writer = new PrintWriter(new FileWriter(temp_file))) {
      Node atual = lista.getFront();
      while (atual != null) {
        writer.println(atual.getData());
        atual = atual.getNext();
      }
    System.out.println("Conteudo da lista salvo em: " + arquivo);
    } catch (IOException e) {
      System.out.println("Erro ao salvar o arquivo: " + arquivo);
      e.printStackTrace();
    }

    // Deleta file e renomeia o arquivo temporario para file
    file.delete();
    temp_file.renameTo(file);

    // Limpa a lista
    lista.encerrarLista();
  }


  // :v LinIni LinFim
  public static void marcarTexto(int LinIni, int LinFim, ListaDuplamenteEncadeada lista, ListaDuplamenteEncadeada copia){

    int tamanhoLista = lista.getTamanho();  // Inicializa o tamanho da lista

    // Verificar se o intervalo [LinIni, LinFim] é válido
    if (LinIni < 1 || LinFim > tamanhoLista || LinIni > LinFim) {
      System.out.println("Intervalo de linhas inválido. Verifique e tente novamente.");
      return;
    }

    // Percorre a lista ate LinIni
    Node atual = lista.getFront();
    for (int i = 1; i < LinIni; i++) {
      atual = atual.getNext();
    }

    // A partir de LinIni percorre a lista ate LinFim
    for (int i = LinIni; i <= LinFim; i++) {
      System.out.println(atual.getData());
      // Adiciona as linhas para a lista copia
      copia.insertBack(atual.getData());
      atual = atual.getNext();
    }
    System.out.println("texto marcado da linha " + LinIni + " ate a linha " + LinFim);
  }


  //:y
  public static void copiarTexto(ListaDuplamenteEncadeada lista, ListaDuplamenteEncadeada copia){
    int tamanhoLista = copia.getTamanho();  // Inicializa o tamanho da lista
    
    // Copia da lista
    Node atual = copia.getFront();
    for (int i =0; i<tamanhoLista; i++){
      System.out.println(atual.getData());
      atual = atual.getNext();
    }
    System.out.println("\nTexto copiado com sucesso!");
  }


  //:c
  public static void cortarTexto(ListaDuplamenteEncadeada lista, ListaDuplamenteEncadeada copia){
    Node atual = lista.getFront();
    Node atualCopia = copia.getFront();

    while (atual != null) {
      // Verifica se o nó atual está na lista de cópia
      if (atualCopia != null && atual.getData().equals(atualCopia.getData())) {
        // Se estiver, avança para o próximo nó da lista de cópia
        atualCopia = atualCopia.getNext();
      } else {
        // Se não estiver, imprime a linha e avança para o próximo nó da lista principal
        System.out.println(atual.getData());
      }
      atual = atual.getNext();
    }
    System.out.println("Operação realizada com sucesso.");
  }


  //:p LinIniPaste
  public static void colarTexto(int LinIniPaste, ListaDuplamenteEncadeada lista, ListaDuplamenteEncadeada copia){
    // Linha fora do limite
    if (LinIniPaste < 1 || LinIniPaste > lista.getTamanho()) {
      System.out.println("Linha inválida.");
      return;
    }
    
    // Se a copia estiver vazia
    if (copia.getTamanho() == 0){
      System.out.println("Nao ha texto para colar!");
      return;
    }
    Node atualCopia = copia.getFront();
    int contador = 1;

    while(atualCopia != null){
      // Percorre ate a LinIniPaste
      if (contador >= LinIniPaste){
        System.out.println(atualCopia.getData());
      }
      contador++;
      atualCopia = atualCopia.getNext();
    }
  }


  //:s
  public static void exibirConteudo(){
    File file = new File("EditorPrograma.java");  // Inicializa arquivo
    int contador = 1;

    // Imprime as linhas de 10 em 10
    try (Scanner scanner = new Scanner(file)) {
      while (scanner.hasNextLine()) {
        if (contador % 10 == 1){
          System.out.println("\n");
        }
        String linha = scanner.nextLine();
        System.out.println("Linha " + contador + ":" + linha);
        contador++;
      }
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
  }


  //:s Lin
  public static void exibirConteudoLinha(int Lin, ListaDuplamenteEncadeada lista){
    lista.encerrarLista();
    File file = new File("EditorPrograma.java");  // Inicializa arquivo
    int contador = 1;

    // Imprime o conteudo da linha Lin
    try (Scanner scanner = new Scanner(file)) {
      while (scanner.hasNextLine()) {
        String linha = scanner.nextLine();
        if (contador == Lin){
          System.out.println(linha);
          break;
        }
        contador++;
      }
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
  }


  //:s LinIni LinFim
  public static void exibirConteudoIniFim(int LinIni, int LinFim){
    File file = new File("EditorPrograma.java"); // Inicializa arquivo
    int contador = 1;

    // Imprime o conteudo de LinIni ate LinFim
    try (Scanner scanner = new Scanner(file)) {
      while (scanner.hasNextLine()) {
        String linha = scanner.nextLine();
        if (contador >= LinIni && contador < LinFim){
          System.out.println(linha);
        } else if (contador > LinFim){
          break;
        }
        contador++;
      }
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
  }


  //:x Lin
  public static void apagarLinha(int Lin, ListaDuplamenteEncadeada lista){
    // Linha fora do limite
    if (Lin < 1 || Lin > lista.getTamanho()) {
      System.out.println("Linha inválida.");
      return;
    }

    // Percorre ate a linha Lin
    Node atual = lista.getFront();
    for (int i = 1; i < Lin; i++) {
      if (atual != null) {
        atual = atual.getNext();
      }
    }

    // apaga a linha correspondente na lista
    if (atual != null) {
      if (atual.getAnterior() != null) {
        atual.getAnterior().setNext(atual.getNext());
      } else {
        lista.setFront(atual.getNext());
      }
      if (atual.getNext() != null) {
        atual.getNext().setAnterior(atual.getAnterior());
      } else {
        lista.setBack(atual.getAnterior());
      }
    }
  }


  //:xG Lin
  public static void apagarLinhaAteFin(int Lin, ListaDuplamenteEncadeada lista){
    // Linha fora do limite
    if (Lin < 1 || Lin > lista.getTamanho()) {
      System.out.println("Linha inválida.");
      return;
    }

    // Percorre a lista ate a linha Lin
    Node atual = lista.getFront();
    for (int i = 1; i < Lin; i++) {
      if (atual != null) {
        atual = atual.getNext();
      }
    }

    // Apaga as linhas
    if (atual != null) {
      if (atual.getAnterior() != null) {
        atual.getAnterior().setNext(null);
        lista.setBack(atual.getAnterior());
      } else {
        lista.setFront(null);
        lista.setBack(null);
      }
    }
  }


  //:XG Lin
  public static void apagarLinhaAteIni(int Lin, ListaDuplamenteEncadeada lista){
    // Linha fora do limite
    if (Lin < 1 || Lin > lista.getTamanho()) {
      System.out.println("Linha inválida.");
      return;
    }
    // Percorre a lista ate a linha Lin
    Node atual = lista.getFront();
    for (int i = 1; i < Lin; i++) {
      if (atual != null) {
        atual = atual.getNext();
      }
    }

    // Apaga as linhas
    if (atual != null) {
      if (atual.getNext() != null) {
        atual.getNext().setAnterior(null);
        lista.setFront(atual.getNext());
      } else {
        lista.setFront(null);
        lista.setBack(null);
      }
    }
  }
  
  //:/ elemento
  public static void localizarElemento(String elemento, ListaDuplamenteEncadeada lista){
    Node atual = lista.getFront();
    int linha = 1;

    while (atual != null) {
      // Verificar se a linha atual contém o elemento
      if (atual.getData().contains(elemento)) {
        // Imprimir o número da linha e o conteúdo da linha
        System.out.println("Linha " + linha + ": " + atual.getData());
      }
      // Ir para o próximo no
      atual = atual.getNext();
      linha++;
    }
  }


  //:elem elemTroca
  public static void trocarElementos(String elemento, String elementoTroca, ListaDuplamenteEncadeada lista){
    Node atual = lista.getFront();
    while (atual != null) {
      // verifica se a linha atual contem o elemento
      if (atual.getData().contains(elemento)) {
        // Imprimir o número da linha e o conteúdo da linha
        System.out.println("elemento: " + elemento + "trocado por: "+ elementoTroca);
        atual.setData(atual.getData().replace(elemento, elementoTroca));
      }
      atual = atual.getNext();
    }
  }


  //:elem elemTroca Linha
  public static void trocarElementosLinha(int Lin, String elemento, String elementoTroca, ListaDuplamenteEncadeada lista){
    // Linha fora do limite
    if (Lin < 1 || Lin > lista.getTamanho()) {
      System.out.println("Linha inválida.");
      return;
    }

    Node atual = lista.getFront();
    int contador = 1;
    while (atual != null) {
      // verifica se a linha atual e igual a Lin
      if (contador == Lin){
        if (atual.getData().contains(elemento)) {
          // Imprimir o número da linha e o conteúdo da linha
          System.out.println("elemento: " + elemento + " trocado por: "+ elementoTroca);
          atual.setData(atual.getData().replace(elemento, elementoTroca));
          return;
        } else {
          return;
        }
      }
      atual = atual.getNext();
      contador++;
    }
    System.out.println("Linha nao encontrada!");
  }


  //:o
  public static void editarLinhas(ListaDuplamenteEncadeada lista){
    Scanner scanner = new Scanner(System.in);
    ListaDuplamenteEncadeada novaLista = new ListaDuplamenteEncadeada();
    System.out.println("Iniciando edição. Digite ':o' em uma linha vazia para terminar.");
    while (true) {
      // Verifica se a linha contem :o
      String linha = scanner.nextLine();
      if (linha.contains(":o")) {
        // Adiciona a linha na lista
        novaLista.insertBack(linha);
        break;
      }
      novaLista.insertBack(linha);
    }
    lista.encerrarLista();

    // Atualiza as listas
    Node atual = novaLista.getFront();
    while (atual != null) {
      lista.insertBack(atual.getData());
      atual = atual.getNext();
    }
    System.out.println("Edição concluída e lista atualizada.");
  }


  //:a posLin
  public static void editarInserirDepois(int posLin, ListaDuplamenteEncadeada lista){
    Scanner scanner = new Scanner(System.in);
    ListaDuplamenteEncadeada novaLista = new ListaDuplamenteEncadeada();
    System.out.println("Iniciando edição. Digite ':a' em uma linha vazia para terminar.");
    while (true) {
      String linha = scanner.nextLine();
      // Verifica se a linha contem :a
      if (linha.contains(":a")) {
        // Adiciona a linha na lista
        novaLista.insertBack(linha);
        break;
      }
      novaLista.insertBack(linha);
    }

    Node atual = lista.getFront();
    int contador = 1;
    while (atual != null && contador <= posLin) {
      atual = atual.getNext();
      contador++;
    }

    // Atualiza as listas
    if (atual != null) {
      Node temp = atual.getNext();
      Node novaAtual = novaLista.getFront();
      while (novaAtual != null) {
        Node novoNode = new Node(novaAtual.getData());
        novoNode.setAnterior(atual);
        atual.setNext(novoNode);
        atual = novoNode;
        novaAtual = novaAtual.getNext();
      }
      atual.setNext(temp);
      if (temp != null) {
        temp.setAnterior(novaAtual);
      }
    } else {
      // Caso a posição seja além do final da lista, insere no final
      atual = lista.getFront();
      while (atual != null && atual.getNext() != null) {
        atual = atual.getNext();
      }
      Node novaAtual = novaLista.getFront();
      while (novaAtual != null) {
        Node novoNode = new Node(novaAtual.getData());
        novoNode.setAnterior(atual);
        if (atual != null) {
          atual.setNext(novoNode);
        } else {
          lista.setFront(novoNode);
        }
        atual = novoNode;
        novaAtual = novaAtual.getNext();
      }
    }
    System.out.println("Edição concluída e lista atualizada.");
  }


  // :i
  public static void editarInserirAntes(int posLin, ListaDuplamenteEncadeada lista){
    Scanner scanner = new Scanner(System.in);
    ListaDuplamenteEncadeada novaLista = new ListaDuplamenteEncadeada();
    System.out.println("Iniciando edição. Digite ':i' em uma linha vazia para terminar.");
    while (true) {
      String linha = scanner.nextLine();
      // Verifica se a lista contem :i
      if (linha.contains(":i")) {
        // Adiciona a linha na lista
        novaLista.insertBack(linha);
        break;
      }
      novaLista.insertBack(linha);
    }
    Node atual = lista.getFront();
    int contador = 1;
    while (atual != null && contador < posLin) {
      atual = atual.getNext();
      contador++;
    }
    if (atual == null) {
      System.out.println("Posição para inserir é inválida.");
      return;
    }

    // Atualiza as listas
    Node anterior = atual.getAnterior();
    Node novoNode = novaLista.getFront();
    while (novoNode != null) {
      Node novo = new Node(novoNode.getData());
      if (anterior != null) {
        anterior.setNext(novo);
        novo.setAnterior(anterior);
      } else {
        lista.setFront(novo);
      }
      anterior = novo;
      novoNode = novoNode.getNext();
    }
    anterior.setNext(atual);
    atual.setAnterior(anterior);
    System.out.println("Linhas inseridas antes da posição " + posLin + ".");
  }


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
}
