package expressoes;

import java.util.Scanner;



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
}