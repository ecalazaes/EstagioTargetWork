/**
 *  @Author Erick Calazães
 *  @date 15/10/2024
 * 4) Dado o valor de faturamento mensal de uma distribuidora, detalhado por estado:
 * • SP – R$67.836,43
 * • RJ – R$36.678,66
 * • MG – R$29.229,88
 * • ES – R$27.165,48
 * • Outros – R$19.849,53
 *
 * Escreva um programa na linguagem que desejar onde calcule o percentual de representação que cada estado teve dentro do valor total mensal da distribuidora.  
 */

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        // Mapeamento do faturamento por estado
        Map<String, Double> faturamentoPorEstado = new HashMap<>();
        faturamentoPorEstado.put("SP", 67836.43);
        faturamentoPorEstado.put("RJ", 36678.66);
        faturamentoPorEstado.put("MG", 29229.88);
        faturamentoPorEstado.put("ES", 27165.48);
        faturamentoPorEstado.put("Outros", 19849.53);

        // Calcula o faturamento total
        double faturamentoTotal = faturamentoPorEstado.values()
                .stream()
                .mapToDouble(Double::doubleValue)
                .sum();

        // Exibe o percentual de representação de cada estado
        System.out.println("Percentual de representação por estado:");
        faturamentoPorEstado.forEach((estado, valor) -> {
            double percentual = (valor / faturamentoTotal) * 100;
            System.out.printf("%s: %.2f%%\n", estado, percentual);
        });
    }
}
