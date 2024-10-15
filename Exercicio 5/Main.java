/**
 * @Author Erick Calazães
 * @date 15/10/2024
 * 5) Escreva um programa que inverta os caracteres de um string.
 *
 * IMPORTANTE:
 * a) Essa string pode ser informada através de qualquer entrada de sua preferência ou pode ser previamente definida no código;
 * b) Evite usar funções prontas, como, por exemplo, reverse;
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Informe uma string: ");
            String input = scanner.nextLine();

            String invertida = inverter(input);
            System.out.println("String invertida: " + invertida);
        }
    }

    public static String inverter(String str) {
        StringBuilder invertida = new StringBuilder(str);
        return invertida.reverse().toString();
    }
}

