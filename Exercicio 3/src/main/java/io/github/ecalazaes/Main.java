/**
 *  @Author Erick Calazães
 *  @date 15/10/2024
 * 3) Dado um vetor que guarda o valor de faturamento diário de uma distribuidora, faça um programa, na linguagem que desejar, que calcule e retorne:
 * • O menor valor de faturamento ocorrido em um dia do mês;
 * • O maior valor de faturamento ocorrido em um dia do mês;
 * • Número de dias no mês em que o valor de faturamento diário foi superior à média mensal.
 *
 * IMPORTANTE:
 * a) Usar o json ou xml disponível como fonte dos dados do faturamento mensal;
 * b) Podem existir dias sem faturamento, como nos finais de semana e feriados. Estes dias devem ser ignorados no cálculo da média;
 */

package io.github.ecalazaes;

import org.json.JSONArray;
import org.json.JSONObject;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        try {
            // Carregar o conteúdo do JSON a partir do arquivo
            String content = new String(Files.readAllBytes(Paths.get("dados.json")));
            JSONArray faturamentos = new JSONArray(content);

            // Lista para armazenar apenas os dias com faturamento positivo
            List<Double> valores = new ArrayList<>();

            // Iterar pelos dados para extrair os valores de faturamento
            for (int i = 0; i < faturamentos.length(); i++) {
                JSONObject obj = faturamentos.getJSONObject(i);
                double valor = obj.getDouble("valor");

                // Considerar apenas dias com faturamento positivo
                if (valor > 0) {
                    valores.add(valor);
                }
            }

            // Calcular o menor e o maior valor de faturamento
            double menorValor = valores.stream().min(Double::compare).orElse(0.0);
            double maiorValor = valores.stream().max(Double::compare).orElse(0.0);

            // Calcular a média mensal (considerando apenas dias com faturamento)
            double soma = valores.stream().mapToDouble(Double::doubleValue).sum();
            double media = soma / valores.size();

            // Contar os dias com faturamento superior à média mensal
            long diasAcimaDaMedia = valores.stream().filter(valor -> valor > media).count();

            // Exibir os resultados
            System.out.printf("Menor valor de faturamento: R$ %.2f%n", menorValor);
            System.out.printf("Maior valor de faturamento: R$ %.2f%n", maiorValor);
            System.out.println("Número de dias com faturamento acima da média: " + diasAcimaDaMedia);

        } catch (Exception e) {
            System.out.println("Ocorreu um erro ao processar os dados: " + e.getMessage());
        }
    }
}
