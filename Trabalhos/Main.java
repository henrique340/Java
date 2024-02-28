import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    System.out.printf("Digite uma frase: ");
    String frase = s.nextLine();

    String fraseSemEspaco = frase.replaceAll("\\s+", "");

    FuncaoPalindromo palindromo = new FuncaoPalindromo();
    palindromo.verificarPalindromo(fraseSemEspaco);
  }
}

class FuncaoPalindromo{
  public void verificarPalindromo(String frase){
    System.out.println("A frase e: "+ frase);
  }
}