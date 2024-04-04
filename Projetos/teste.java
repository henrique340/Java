import java.util.Scanner;

class MinhaPilha {
    private int tamanhoMaximo;
    private char[] listaPilha;
    private int topo;

    public MinhaPilha(int tamanho) {
        tamanhoMaximo = tamanho;
        listaPilha = new char[tamanhoMaximo];
        topo = -1;
    }

    // Função que adiciona um caractere a uma pilha
    public void push(char c) {
        listaPilha[++topo] = c;
    }

    // Função que deleta o último termo
    public char pop() {
        return listaPilha[topo--];
    }

    // Função que verifica se está vazia
    public boolean isEmpty() {
        return topo == -1;
    }

    // Função que retorna o último termo de uma pilha
    public char topo() {
        return listaPilha[topo];
    }

    // Função para verificar o último operador de uma pilha
    public char ultimoOperador() {
        for (int i = topo; i >= 0; i--) {
            if (listaPilha[i] == '+' || listaPilha[i] == '-' || listaPilha[i] == '/' || listaPilha[i] == '*' || listaPilha[i] == '^') {
                return listaPilha[i];
            }
        }
        return 0;
    }
}

public class teste {

    public static void main(String[] args) {
        String expressaoInfixa = "";
        int[] valores = new int[26];
        while (true) {
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
                System.out.print("Digite a expressao infixa: ");
                Scanner input = new Scanner(System.in);
                expressaoInfixa = input.nextLine();

            } else if (opc == 2) {
                entradaValores(valores, expressaoInfixa);
            } else if (opc == 3) {
                System.out.print("A expressao posfixa e: ");
                MinhaPilha posfixa = Conversor(expressaoInfixa);
                while (!posfixa.isEmpty()) {
                    System.out.print(posfixa.pop());
                }
                System.out.println();
            } else if (opc == 4) {
                int resultado = atribuirValores(expressaoPosfixa, valores);
                System.out.print("O resultado da expressao e: ");
                System.out.println(resultado);
            } else if (opc == 5) {
                System.out.println("Fim do programa");
                break;
            } else {
                System.out.println("Erro: Digite um valor valido");
            }
        }
    }

    // Função para calcular e comparar a prioridade dos operadores
    public static int prioridade(char c) {
        switch (c) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
            case '^':
                return 2;
        }
        return -1;
    }

    // Função que converte uma expressão infixa para posfixa
    public static MinhaPilha Conversor(String expressao) {
        MinhaPilha posfixa = new MinhaPilha(expressao.length());
        MinhaPilha pilha = new MinhaPilha(expressao.length());
        for (int i = 0; i < expressao.length(); i++) {
            char caractere = expressao.charAt(i);

            // Se um caractere for uma letra ou número
            if (Character.isLetter(caractere)) {
                posfixa.push(caractere);
            }

            // Se o caractere for um operando
            else if (caractere == '*' || caractere == '/' || caractere == '^' || caractere == '+' || caractere == '-') {
                while (!pilha.isEmpty() && prioridade(caractere) <= prioridade(pilha.ultimoOperador())) {
                    posfixa.push(pilha.pop());
                }
                pilha.push(caractere);
            } else if (caractere == '(') {
                pilha.push(caractere);
            } else if (caractere == ')') {
                while (!pilha.isEmpty() && pilha.topo() != '(') {
                    posfixa.push(pilha.pop());
                }
                pilha.pop(); //Desempilha o )
            }
        }

        while (!pilha.isEmpty()) {
            posfixa.push(pilha.pop());
        }
        return posfixa;
    }

    // Função que recebe os valores para as variáveis
    public static void entradaValores(int[] valores, String expressao) {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < expressao.length(); i++) {
            char caractere = expressao.charAt(i);
            if (Character.isLetter(caractere)) {
                int indice = Character.toUpperCase(caractere) - 'A'; // Convertendo a letra para maiúscula
                if (valores[indice] == 0) { // Verificando se o valor para esta letra ainda não foi inserido
                    System.out.print("Digite o valor da variável " + caractere + ": ");
                    int valor = scanner.nextInt();
                    valores[indice] = valor; // Armazenando o valor no array na posição correspondente ao índice da letra
                }
            }
        }
    }

    // Função que avalia a expressão infixa após a atribuição dos valores às variáveis
    public static int atribuirValores(String expressao, int[] valores) {
        MinhaPilha pilha = new MinhaPilha(expressao.length());
        for (int i = 0; i < expressao.length(); i++) {
            char caractere = expressao.charAt(i);
            if (Character.isLetter(caractere)) {
                int indice = Character.toUpperCase(caractere) - 'A'; // Convertendo a letra para maiúscula
                int valor = valores[indice]; // Obtendo o valor associado à variável
                pilha.push((char) (valor + '0')); // Convertendo o valor em char e empilhando
            } else if (caractere == '+' || caractere == '-' || caractere == '*' || caractere == '/' || caractere == '^') {
                int valor2 = Character.getNumericValue(pilha.pop()); // Desempilhando o segundo operando
                int valor1 = Character.getNumericValue(pilha.pop()); // Desempilhando o primeiro operando
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
                        resultado = (int) Math.pow(valor1, valor2);
                        break;
                }
                pilha.push((char) (resultado + '0')); // Convertendo o resultado em char e empilhando
            }
        }
        return Character.getNumericValue(pilha.pop()); // Convertendo o resultado final para int e retornando
    }
}
