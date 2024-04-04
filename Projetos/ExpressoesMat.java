
// Importanto biblioteca Scanner
import java.util.Scanner;

// Classe Minha Pilha
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
      case '^':
        return 2; // Para a maior prioridade
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

  // Função que calcula o resultado final a parti da expressao posfixa
  public static int atribuirValores(String expressao, int[] valores) {
    MinhaPilha pilha = new MinhaPilha(expressao.length());
    for (int i = 0; i < expressao.length(); i++) {
      char caractere = expressao.charAt(i);
      // Se for operando empilha
      if (Character.isLetter(caractere)) {
        int indice = Character.toUpperCase(caractere) - 'A'; // Achando o index da variável de acordo com a posição do alfabeto
        int valor = valores[indice]; // Obtendo o valor associado à variável
        pilha.push((char) (valor + '0')); // Convertendo o valor em char e empilhando
        // Se for operador desempilha os dois últimos e empilha o resultado
      } else if (caractere == '+' || caractere == '-' || caractere == '*' || caractere == '/' || caractere == '^') {
        int valor2 = Character.getNumericValue(pilha.pop()); // Desempilhando o segundo operando
        int valor1 = Character.getNumericValue(pilha.pop()); // Desempilhando o primeiro operando
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
            resultado = (int) Math.pow(valor1, valor2); // Converter o dooble em int
            break;
        }
        pilha.push((char) (resultado + '0')); // Convertendo o resultado em char e empilhando
      }
    }
    return Character.getNumericValue(pilha.pop()); // Convertendo o resultado final para int
  }
}