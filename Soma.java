import java.util.Scanner;

public class Soma {
  public static void main(String[] args){
    Scanner s = new Scanner(System.in);

    System.out.printf("Digite o primeiro número: ");
    int numero1 = s.nextInt();

    System.out.printf("Digite o segundo número: ");
    int numero2 = s.nextInt();

    s.close();

    int soma = numero1 + numero2;

    System.out.println("A soma de " + numero1 + " com " + numero2 + "é igual a: " + soma);

  }
}