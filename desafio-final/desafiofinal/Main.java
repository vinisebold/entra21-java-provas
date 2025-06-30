package desafiofinal;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Declaração de vetor
        double[] vetorValores = new double[12];
        String[] vetorMeses = {"Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"};

        // Entrada de dados
        System.out.println("=== Registro de Consumo Mensal (kWh) ===");

        for (int i = 0; i < vetorMeses.length; i++) {
            System.out.printf("→ %s: ", vetorMeses[i]);
            vetorValores[i] = sc.nextDouble();
        }

        // Chamada de funções e Atribuições de valores
        double total = calcularConsumoTotal(vetorValores);
        double media = calcularMediaTotal(vetorValores, total);
        int indiceMaior = verificarMaior(vetorValores);
        int indiceMenor = verificarMenor(vetorValores);
        String perfilConsumo = classificarConsumo(media);

        // Output
        imprimirRelatorio(vetorValores, vetorMeses, total, media, indiceMaior, indiceMenor, perfilConsumo);


        // Fecha Scanner
        sc.close();
    }

    public static void imprimirRelatorio(Double[] pVetorValores, String[] pVetorMeses, double pTotal, double pMedia, int pIndiceMaior, int pIndiceMenor, String pPerfilConsumo) {
        System.out.println("\n======== RELATÓRIO ========");
        System.out.printf("🔌 Consumo Total: %.1f kWh%n", pTotal);
        System.out.printf("📊 Média Mensal de Consumo: %.1f kWh/mês%n", pMedia);
        System.out.printf("🔋 Mês de Maior Consumo: %s (%.1f kWh)%n", pVetorMeses[pIndiceMaior], pVetorValores[pIndiceMaior]);
        System.out.printf("🪫 Mês de Menor Consumo: %s (%.1f kWh)%n", pVetorMeses[pIndiceMenor], pVetorValores[pIndiceMenor]);
        System.out.printf("👤 Perfil de Consumo: %s%n", pPerfilConsumo);
        System.out.println("============================");
    }


    public static double calcularConsumoTotal(Double[] pVetorValores) {

        double consumoTotal = 0;

        for (Double pVetorValore : pVetorValores) {
            consumoTotal += pVetorValore;
        }

        return consumoTotal;
    }

    public static double calcularMediaTotal(Double[] pVetorValores, Double pTotal) {
        return pTotal / pVetorValores.length;
    }

    public static int verificarMaior(Double[] pVetorValor) {

        double maiorValor = Double.MIN_VALUE;
        int indice = 0;

        for (int i = 0; i < pVetorValor.length; i++) {
            if (pVetorValor[i] > maiorValor) {
                maiorValor = pVetorValor[i];
                indice = i;
            }
        }

        return indice;
    }

    public static int verificarMenor(Double[] pVetorValor) {

        double menorValor = Double.MAX_VALUE;
        int indice = 0;

        for (int i = 0; i < pVetorValor.length; i++) {
            if (pVetorValor[i] < menorValor) {
                menorValor = pVetorValor[i];
                indice = i;
            }
        }

        return indice;
    }

    public static String classificarConsumo(Double pMediaConsumo) {
        if (pMediaConsumo <= 150) {
            return "Baixo";
        } else if (pMediaConsumo > 300) {
            return "Elevado";
        } else {
            return "Moderado";
        }
    }
}
