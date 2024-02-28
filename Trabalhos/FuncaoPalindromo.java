import java.util.Scanner;
import java.util.Locale;
import java.io.UnsupportedEncodingException;

public class FuncaoPalindromo{
  public static void main(String[] args){
    
    //Linguagem para o Português
    Locale.setDefault(new Locale("pt", "BR"));

    //Input da frase
    Scanner input = new Scanner(System.in, "UTF-8");
    System.out.printf("Digite uma frase: ");
    String frase = input.nextLine();

    //Tirando os espaços em branco
    String fraseSemEspaco = frase.replaceAll("\\s+","");

    //Chamada da função VerificarPalindromo
    VerificarPalindromo palindromo = new VerificarPalindromo();
    palindromo.verificarPalindromo(fraseSemEspaco);
  }
}

class VerificarPalindromo{
  public void verificarPalindromo(String frase){
    String invertida = "";
    
    //Invertendo a frase
    int i;
    for (i = frase.length()-1; i>=0; i--){
      invertida += frase.charAt(i);
    }

    //Verificando se a frase normal é igual a invertida
    if (frase.equalsIgnoreCase(invertida)){
      System.out.println("A frase " + frase + " e um palíndromo");
    }
    else{
      System.out.println("A frase " + frase + " nao e um palíndromo");
    }
  }
}