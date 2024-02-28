import java.util.Scanner;

public class EncontrarLista{
  public static void main(String[] args){
    
    int[] lista = {32, 87, 3, 689, 12, 1076, 2000, 8, 622, 127};
    
    int i;

    // imprimir lista
    System.out.printf("A lista contem os seguintes itens\n");
    System.out.printf("---------------------\n");
    for (i=0; i<lista.length; i++){
      System.out.println(lista[i]);
    }
    System.out.printf("---------------------\n");

    Scanner s = new Scanner(System.in);
    System.out.printf("Digite o numero a ser encontrado na lista: ");
    int numero = s.nextInt();
    
    for (i=0; i<lista.length; i++){
      if (lista[i] == numero){
        System.out.println("O numero " + numero + " esta na posicao " + i);
      }
    }
    s.close();
  }
}