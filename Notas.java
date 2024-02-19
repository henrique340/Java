import java.util.Scanner;
public class Notas{
  public static void main(String[] args){
    
    Scanner s = new Scanner(System.in);

    System.out.printf("Digite a sua nota: ");
    int nota = s.nextInt();

    char letra;
    if (nota >= 90){
      letra = 'A';
    }
    else if (nota >= 80) {
      letra = 'B';
    }
    else if (nota >= 70) {
      letra = 'C';
    }
    else if (nota >= 60) {
      letra = 'D';
    }
    else if (nota >= 50){
      letra = 'E';
    }
    else{
      letra = 'F';
    }
    System.out.println("Você tirou " + letra);
  }
}