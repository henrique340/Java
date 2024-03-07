public class Casting{
  public static void main(String[] args){
    int num = 22;
    double numero = num;  //int dentre de double tudo bem

    num = (int)numero;  //double virar int

    char letra = 'a';
    String frase = String.valueOf(letra);  //frase recebendo um char

    letra = frase.charAt(0);  //letra recebe a primeira letra da frase

    String numeric = String.valueOf(num);

    num = Integer.parseInt(numeric); //String em inteiro
  }
}