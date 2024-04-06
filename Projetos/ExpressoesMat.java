//Nome: Henrique Yuji Isogai Yoneoka      RA: 10418153
//Nome: André Moreira Guimarães           RA: 10416590

// Importanto biblioteca Scanner
import java.util.Scanner;

// Classe Minha Pilha
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

class MinhaPilha {
  private int tamanhoMaximo;
  private char[] listaPilha;
  private int topo;

  // Método contrutor
  public MinhaPilha(int tamanho) {
    tamanhoMaximo = tamanho;
    listaPilha = new char[tamanhoMaximo];
    topo = -1;
  }

  // Funções da pilha
  public void push(char c) {
    listaPilha[++topo] = c;
  }

  public char pop() {
    if (isEmpty()) {
      System.out.println("A pilha está vazia");
    }
    return listaPilha[topo--];
  }

  public boolean isEmpty() {
    return topo == -1;
  }

  public char topo() {
    return listaPilha[topo];
  }

  public char ultimoOperador() {
    for (int i = topo; i >= 0; i--) {
      if (listaPilha[i] == '+' || listaPilha[i] == '-' || listaPilha[i] == '/' || listaPilha[i] == '*'
          || listaPilha[i] == '^') {
        return listaPilha[i];
      }
    }
    return 0;
  }
}

// Função Principal
public class ExpressoesMat {
  public static void main(String[] args) {

    // Inicialização das Strings e listas utilizadas
    String expressaoInfixa = "";
    String expressaoPosfixa = "";
    int[] valores = new int[26];

    // Looping para o Menu
    while (true) {
      // Exibição do menu de opções
      System.out.println("\n------------------------------------------");
      System.out.println("Convertor de expressao infixa para posfixa");
      System.out.println("------------------------------------------");
      System.out.println("[1] - Para digitar a expressao infixa");
      System.out.println("[2] - Para digitar os valores das variaveis");
      System.out.println("[3] - Conversao para posfixa");
      System.out.println("[4] - Avaliacao da expressao");
      System.out.println("[5] - Para sair do programa");
      System.out.print("Digite a sua opcao: ");
      Scanner entrada = new Scanner(System.in);
      int opc = entrada.nextInt();

      if (opc == 1) {
        // Pede um input para a expressao infixa
        System.out.print("Digite a expressao infixa: ");
        Scanner input = new Scanner(System.in);
        expressaoInfixa = input.nextLine();
        int contador = 0;
        int contador2 = 0;
        for (int i = 0; i < expressaoInfixa.length(); i++){
          char caracter = expressaoInfixa.charAt(i);
          if(caracter == '('){
            contador++;
          }
          if(caracter == ')'){
            contador2++;
          }
        }
        if (contador != contador2){
          //throw new RuntimeException("Identação da expressão infixa está errada, tente novamente.");
          System.out.println("ERRO, identação errada.");
        }

      } else if (opc == 2) {
        // Atribui valores para as variáveis
        valores = entradaValores(expressaoInfixa);

      } else if (opc == 3) {
        // Calcula a expressao posfixa
        System.out.print("A expressao posfixa e: ");
        expressaoPosfixa = ConverterPosfixa(expressaoInfixa);
        System.out.print(expressaoPosfixa);

      } else if (opc == 4) {
        // Calcula o resultado da expressão a partir da expressao posfixa
        int resultado = atribuirValores(expressaoPosfixa, valores);
        System.out.print("O resultado da expressao e: ");
        System.out.print(resultado);

      } else if (opc == 5) {
        // Encerra o programa
        System.out.println("Fim do programa");
        break;
      }

      else {
        // Tratamento de erro
        System.out.println("Erro: Digite um valor valido");
      }
    }
  }

  // Função que recebe as números para variáveis e coloca em uma lista de inteiros
  public static int[] entradaValores(String expressao) {
    int[] valores = new int[26]; // Uma lista para armazenar os valores das letras
    Scanner scanner = new Scanner(System.in);
    for (int i = 0; i < expressao.length(); i++) {
      char caractere = expressao.charAt(i);
      if (Character.isLetter(caractere)) {
        int indice = Character.toUpperCase(caractere) - 'A'; // Achando o index de acordo com a posição no alfabeto
        if (valores[indice] == 0) { // Verificando se o valor para esta letra ainda não foi inserido
          System.out.print("Digite o valor da variável " + caractere + ": ");
          int valor = scanner.nextInt();
          valores[indice] = valor; // Armazenando o valor no array na posição correspondente ao índice da letra
        }
      }
    }
    return valores;
  }

  // Função para calcular e comparar a prioridade dos operadores na função
  public static int prioridade(char c) {
    switch (c) {
      case '+':
      case '-':
        return 1; // Para a menor prioridade
      case '*':
      case '/':
        return 2;
      case '^':
      return 3; // Para a maior prioridade
    }
    return -1;
  }

  // Função que converte uma expressão infixa para posfixa
  public static String ConverterPosfixa(String expressao) {
    StringBuilder expressaoPosfixa = new StringBuilder();
    MinhaPilha pilha = new MinhaPilha(expressao.length());
    for (int i = 0; i < expressao.length(); i++) {
      char caractere = expressao.charAt(i);
      // Se um caractere for uma letra ou número
      if (Character.isLetter(caractere)) {
        expressaoPosfixa.append(caractere);
      }
      // Se o caractere for um operando
      else if (caractere == '*' || caractere == '/' || caractere == '^' || caractere == '+' || caractere == '-') {
        while (!pilha.isEmpty() && prioridade(caractere) <= prioridade(pilha.ultimoOperador())) {
          expressaoPosfixa.append(pilha.pop());
        }
        pilha.push(caractere);
      } else if (caractere == '(') {
        
        pilha.push(caractere);
      } else if (caractere == ')') {
        
        while (!pilha.isEmpty() && pilha.topo() != '(') {
          expressaoPosfixa.append(pilha.pop());
        }
        pilha.pop(); // Desempilha o ')'
      }
    }
    while (!pilha.isEmpty()) {
      expressaoPosfixa.append(pilha.pop());
    }

    return expressaoPosfixa.toString();
  }

  // Função que calcula o resultado final a partir da expressão posfixa
  public static int atribuirValores(String expressao, int[] valores) {
    MinhaPilhaInteiro pilha = new MinhaPilhaInteiro(expressao.length());
    for (int i = 0; i < expressao.length(); i++) {
        char caractere = expressao.charAt(i);
        // Se for operando empilha
        if (Character.isDigit(caractere)) {
            int valor = Character.getNumericValue(caractere); // Convertendo o caractere em número
            pilha.push(valor); // Empilhando o número
        } else if (Character.isLetter(caractere)) {
            // Se for uma variável, busca o valor correspondente no array de valores
            int indice = Character.toUpperCase(caractere) - 'A'; // Convertendo a letra para o índice do array
            pilha.push(valores[indice]); // Empilhando o valor da variável
        } else if (caractere == '+' || caractere == '-' || caractere == '*' || caractere == '/' || caractere == '^') {
            // Se for operador, desempilha os dois últimos, realiza a operação e empilha o resultado
            int valor2 = pilha.pop();
            int valor1 = pilha.pop();
            int resultado = 0;
            switch (caractere) {
                case '+':
                    resultado = valor1 + valor2;
                    break;
                case '-':
                    resultado = valor1 - valor2;
                    break;
                case '*':
                    resultado = valor1 * valor2;
                    break;
                case '/':
                    resultado = valor1 / valor2;
                    break;
                case '^':
                    resultado = (int) Math.pow(valor1, valor2); // Converter o double em int
                    break;
            }
            pilha.push(resultado); // Empilhando o resultado
        }
    }
    return pilha.pop(); // Retorna o resultado final
  }
}