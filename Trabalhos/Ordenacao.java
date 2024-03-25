import java.util.Scanner;
import java.util.Random;

public class Ordenacao {
  public static void main(String[] args){
    System.out.printf("a - bubble sort\nb - insertion sort\nc - selection sort\nd - shell sort\n");
    System.out.printf("Digite a opcao: ");
    Scanner input = new Scanner(System.in);
    String letra = input.nextLine();

    // Bubble sort
    if (letra.equals("a")){
      System.out.print("1 - [1000]\n2 - [5000]\n3 - [10000]");
      System.out.print("Digite a opcao: ");
      Scanner entrada = new Scanner(System.in);
      int opcao = entrada.nextInt();

      // Tamanhos
      if (opcao == 1){
        randomNumBubble(1000);
      } else if (opcao == 2){
        randomNumBubble(5000);
      } else if (opcao == 3){
        randomNumBubble(10000);
      } else{
        System.out.println("Opcao nao reconhecida");
      }

    // Insertion sort
    } else if (letra.equals("b")){
      System.out.print("1 - [1000]\n2 - [5000]\n3 - [10000]");
      System.out.print("Digite a opcao: ");
      Scanner entrada = new Scanner(System.in);
      int opcao = entrada.nextInt();

      // Tamanhos
      if (opcao == 1){
        randomNumInsertion(1000);
      } else if (opcao == 2){
        randomNumInsertion(5000);
      } else if (opcao == 3){
        randomNumInsertion(10000);
      } else{
        System.out.println("Opcao nao reconhecida");
      }

    // Selection sort
    } else if (letra.equals("c")){
      System.out.print("1 - [1000]\n2 - [5000]\n3 - [10000]");
      System.out.print("Digite a opcao: ");
      Scanner entrada = new Scanner(System.in);
      int opcao = entrada.nextInt();

      // Tamanhos
      if (opcao == 1){
        randomNumSelection(1000);
      } else if (opcao == 2){
        randomNumSelection(5000);
      } else if (opcao == 3){
        randomNumSelection(10000);
      } else{
        System.out.println("Opcao nao reconhecida");
      }

    // Shell sort
    } else if (letra.equals("d")){
      System.out.print("1 - [1000]\n2 - [5000]\n3 - [10000]");
      System.out.print("Digite a opcao: ");
      Scanner entrada = new Scanner(System.in);
      int opcao = entrada.nextInt();

      // Tamanhos
      if (opcao == 1){
        randomNumShell(1000);
      } else if (opcao == 2){
        randomNumShell(5000);
      } else if (opcao == 3){
        randomNumShell(10000);
      } else{
        System.out.println("Opcao nao reconhecida");
      }
    }
  }

  // Função Bubble Sort
  public static void randomNumBubble(int tam){
    int [] vetor = new int[tam];
    Random random = new Random();

    for (int i = 0; i<tam; i++){
      vetor[i] = random.nextInt(100);
    }
    System.out.println("\nO vetor gerado aleatóriamente fica assim: ");
    imprimirVetor(vetor);

    // Algoritimo do Bubble Sort
    for (int i = 0; i < tam -1; i++){
      for (int j = 0; j < tam -1; j++){
        if (vetor[j] > vetor[j+1]){
          int temp = vetor[j];
          vetor[j] = vetor[j+1];
          vetor[j+1] = temp;
        }
      }
    }
    System.out.println("\nO vetor ordenado por bubble sort fica assim: ");
    imprimirVetor(vetor);
  }

  // Função Insertion Sort
  public static void randomNumInsertion(int tam){
    int [] vetor = new int[tam];
    Random random = new Random();

    for (int i = 0; i<tam; i++){
      vetor[i] = random.nextInt(100);
    }
    System.out.println("\nO vetor gerado aleatóriamente fica assim: ");
    imprimirVetor(vetor);

    // Algoritimo do Insertion Sort
    for (int i = 1; i < tam; i++){
      int chave = vetor[i];
      int j = i-1;
      while(j >= 0 && vetor[j] > chave){
        vetor[j+1] = vetor[j];
        j = j-1;
      }
      vetor[j+1] = chave;
    }
    System.out.println("\nO vetor ordenado por insertion sort fica assim: ");
    imprimirVetor(vetor);
  }

  // Função Selection Sort
  public static void randomNumSelection(int tam){
    int [] vetor = new int[tam];
    Random random = new Random();

    for (int i = 0; i<tam; i++){
      vetor[i] = random.nextInt(100);
    }
    System.out.println("\nO vetor gerado aleatóriamente fica assim: ");
    imprimirVetor(vetor);

    // Algoritimo do Selection Sort
    for (int i = 0; i<tam-1; i++){
      int min = 1;
      for (int j = i+1; j<tam; j++){
        if (vetor[j] < vetor[min]){
          min = j;
        }
      }
      int temp = vetor[min];
      vetor[min] = vetor[i];
      vetor[i] = temp;
    }
    System.out.println("\nO vetor ordenado por selection sort fica assim: ");
    imprimirVetor(vetor);
  }

  // Função Shell Sort
  public static void randomNumShell(int tam){
    int [] vetor = new int[tam];
    Random random = new Random();

    for (int i = 0; i<tam; i++){
      vetor[i] = random.nextInt(100);
    }
    System.out.println("\nO vetor gerado aleatóriamente fica assim: ");
    imprimirVetor(vetor);

    // Algoritimo do Shell Sort
    int gap;
    for (gap = tam/2; gap>0; gap/=2){
      for (int i = gap; i<tam; i++){
        int temp = vetor[i];
        int j;
        for (j = i; j >= gap && vetor[j - gap] > temp; j -= gap){
          vetor[j] = vetor[j-gap];
        }
        vetor[j] = temp;
      }
    }
    System.out.println("\nO vetor ordenado por shell sort fica assim: ");
    imprimirVetor(vetor);
  }

  public static void imprimirVetor(int[] vetor){
    for (int i = 0; i < vetor.length; i++){
      System.out.print(vetor[i] + " ");
    }
  }
}
