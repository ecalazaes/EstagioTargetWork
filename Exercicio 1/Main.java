/**
 *  @Author Erick Calazães
 *  @date 15/10/2024
 * 1) Observe o trecho de código abaixo: int INDICE = 13, SOMA = 0, K = 0;
 * Enquanto K < INDICE faça { K = K + 1; SOMA = SOMA + K; }
 * Imprimir(SOMA);
 * Ao final do processamento, qual será o valor da variável SOMA?
 */

public class Main {
    public static void main(String[] args) {
        final int INDICE = 13;
        int soma = calcularSoma(INDICE);

        System.out.println("Valor da SOMA: " + soma);
    }

    private static int calcularSoma(int indice) {
        int soma = 0;

        for (int k = 1; k <= indice; k++) {
            soma += k;
        }

        return soma;
    }
}

