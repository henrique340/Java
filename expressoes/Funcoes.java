package expressoes;

import java.util.Scanner;

public class Funcoes{
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
        while (!pilha.isEmpty() && prioridade(caractere) <= prioridade(pilha.topo())) {
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