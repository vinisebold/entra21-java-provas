package desafiofinal;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Declaração de vetor
        Double[] vetorValores = new Double[12];
        String[] vetorMeses = {"Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"};

        // Entrada de dados
        System.out.println("Informe o consumo mensal (kWh):");

        for (int i = 0; i < vetorMeses.length; i++) {
            System.out.print(vetorMeses[i] + ": ");
            vetorValores[i] = sc.nextDouble();
        }

        //Output
        System.out.println("Consumo total: " + calcularConsumoTotal(vetorValores));


        // Fecha Scanner
        sc.close();
    }

    public static double calcularConsumoTotal(Double[] pVetorValores) {

        double consumoTotal = 0;

        for (Double pVetorValore : pVetorValores) {
            consumoTotal += pVetorValore;
        }

        return consumoTotal;
    }

    public static double calcularMediaTotal(Double[] pVetorValores) {

        double somaTotal = 0;

        for (int i = 0; i < pVetorValores.length; i++) {
            
        }

        return somaTotal;
    }
}
