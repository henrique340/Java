import java.util.Scanner;

public class encontrar_matriz{
  public static void main(String[] args){
    
    int[][] matriz = {
      {32, 87, 3},
      {12, 1076, 589},
      {2, 127, 955}
    };
    
    int i, j;

    // imprimir matriz
    System.out.printf("A matriz contem os seguintes itens\n");
    System.out.printf("---------------------\n");
    for (i=0; i<matriz.length; i++){
      for (j=0; j<matriz.length; j++){
        System.out.println(matriz[i][j]);
      }
    }
    System.out.printf("---------------------\n");

    Scanner s = new Scanner(System.in);
    System.out.printf("Digite o numero a ser encontrado na matriz: ");
    int numero = s.nextInt();
    
    for (i=0; i<matriz.length; i++){
      for (j=0; j<matriz.length; j++){
        if (matriz[i][j] == numero){
          System.out.println("O numero " + numero + " esta na posicao [" + i + "][" + j + "]");
        }
      }
    }
    s.close();
  }
}