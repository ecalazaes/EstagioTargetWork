/**
 *  @Author Erick Calazães
 *  @date 15/10/2024
 * 2) Dado a sequência de Fibonacci, onde se inicia por 0 e 1 e o próximo valor sempre será a soma dos 2 valores anteriores (exemplo: 0, 1, 1, 2, 3, 5, 8, 13, 21, 34...), escreva um programa na linguagem que desejar onde, informado um número, ele calcule a sequência de Fibonacci e retorne uma mensagem avisando se o número informado pertence ou não a sequência.
 * IMPORTANTE: Esse número pode ser informado através de qualquer entrada de sua preferência ou pode ser previamente definido no código;
 */


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Informe um número: ");
            int numero = scanner.nextInt();

            String mensagem = isFibonacci(numero) ?
                    "O número " + numero + " pertence à sequência de Fibonacci." :
                    "O número " + numero + " não pertence à sequência de Fibonacci.";

            System.out.println(mensagem);
        }
    }

    private static boolean isFibonacci(int num) {
        if (num < 0) return false;

        int a = 0, b = 1;
        while (a <= num) {
            if (a == num) {
                return true;
            }
            int temp = a + b;
            a = b;
            b = temp;
        }
        return false;
    }
}

