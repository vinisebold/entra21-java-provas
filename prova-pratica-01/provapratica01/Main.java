package provapratica01;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // Declaração dos arrays
        String[] vetSemana = {"Segunda-Feira", "Terça-Feira", "Quarta-Feira", "Quinta-Feira", "Sexta-Feira", "Sábado", "Domingo"};
        String[] vetCidadesNomes = new String[4];
        double[][] matTemperaturas = new double[4][7];

        // Entrada de dados
        for (int i = 0; i < vetCidadesNomes.length; i++) {
            System.out.print("\n[" + (i + 1) + "] Informe o nome da cidade: ");
            vetCidadesNomes[i] = input.nextLine();

            for (int j = 0; j < vetSemana.length; j++) {
                System.out.print("Informe a temperatura de " + vetSemana[j] + ": ");
                matTemperaturas[i][j] = input.nextDouble();
                input.nextLine();
            }
        }

        // Output
        System.out.println("\n===Media Temperatura===");
        for (int indiceCidade = 0; indiceCidade < vetCidadesNomes.length; indiceCidade++) {
            System.out.printf("[" + vetCidadesNomes[indiceCidade] + "] %.2f°C%n", mediaTemperatura(matTemperaturas, indiceCidade));
        }

        System.out.println("===Menor Temperatura===");
        for (int indiceCidade = 0; indiceCidade < vetCidadesNomes.length; indiceCidade++) {
            System.out.printf("[" + vetCidadesNomes[indiceCidade] + "] %.2f°C%n", menorTemperatura(matTemperaturas, indiceCidade));
        }

        System.out.println("===Maior Temperatura===");
        for (int indiceCidade = 0; indiceCidade < vetCidadesNomes.length; indiceCidade++) {
            System.out.printf("[" + vetCidadesNomes[indiceCidade] + "] %.2f°C%n", maiorTemperatura(matTemperaturas, indiceCidade));
        }

        System.out.println("===Dias com temperatura abaixo de 15°C===");
        for (int indiceCidade = 0; indiceCidade < vetCidadesNomes.length; indiceCidade++) {
            System.out.printf("[" + vetCidadesNomes[indiceCidade] + "] %d dias%n", contarDiasFrios(matTemperaturas, indiceCidade));
        }

        System.out.println("===Média Geral===");
        System.out.printf("[Média Geral] %.2f°C%n", mediaTemperaturaGeral(matTemperaturas));

        System.out.println("===Dia mais Quente===");
        double[] vetMaisAlta = diaMaisQuente(matTemperaturas);
        int idxCidade = (int) vetMaisAlta[0];
        int idxTemp = (int) vetMaisAlta[1];
        double vlrTemperatura = vetMaisAlta[2];
        System.out.println("A temperatura mais alta foi de " + vlrTemperatura + "°C em " + vetCidadesNomes[idxCidade] + " na " + vetSemana[idxTemp] + ".");

        System.out.println("===Dia mais Frio===");
        double[] vetMaisBaixa = diaMaisFrio(matTemperaturas);
        idxCidade = (int) vetMaisBaixa[0];
        idxTemp = (int) vetMaisBaixa[1];
        vlrTemperatura = vetMaisBaixa[2];
        System.out.println("A temperatura mais baixa foi de " + vlrTemperatura + "°C em " + vetCidadesNomes[idxCidade] + " na " + vetSemana[idxTemp] + ".");


        // Fecha Scanner
        input.close();
    }

    public static double mediaTemperatura(double[][] pMatTemperaturas, int pIndiceCidade) {
        double somaTemp = 0;
        for (int j = 0; j < pMatTemperaturas[pIndiceCidade].length; j++) {
            somaTemp += pMatTemperaturas[pIndiceCidade][j];
        }
        return somaTemp / pMatTemperaturas[pIndiceCidade].length;
    }

    public static double menorTemperatura(double[][] pMatTemperaturas, int pIndiceCidade) {
        double menor = Double.MAX_VALUE;
        for (int j = 0; j < pMatTemperaturas[pIndiceCidade].length; j++) {
            if (pMatTemperaturas[pIndiceCidade][j] < menor) {
                menor = pMatTemperaturas[pIndiceCidade][j];
            }
        }
        return menor;
    }

    public static double maiorTemperatura(double[][] pMatTemperaturas, int pIndiceCidade) {
        double maior = Double.MIN_VALUE;
        for (int j = 0; j < pMatTemperaturas[pIndiceCidade].length; j++) {
            if (pMatTemperaturas[pIndiceCidade][j] > maior) {
                maior = pMatTemperaturas[pIndiceCidade][j];
            }
        }
        return maior;
    }

    public static int contarDiasFrios(double[][] pMatTemperaturas, int pIndiceCidade) {
        int contadorDias = 0;
        for (int j = 0; j < pMatTemperaturas[pIndiceCidade].length; j++) {
            if (pMatTemperaturas[pIndiceCidade][j] < 15) {
                contadorDias++;
            }
        }
        return contadorDias;
    }

    public static double mediaTemperaturaGeral(double[][] pMatTemperaturas) {
        double somaTemp = 0;
        for (int i = 0; i < pMatTemperaturas.length; i++) {
            for (int j = 0; j < pMatTemperaturas[0].length; j++) {
                somaTemp += pMatTemperaturas[i][j];
            }
        }
        return somaTemp / (pMatTemperaturas.length * pMatTemperaturas[0].length);
    }

    public static double[] diaMaisQuente(double[][] pMatTemperaturas) {
        double tempMaisQuente = Double.MIN_VALUE;
        double[][] matDiaMaisQuente = new double[1][1];
        int posCidade = 0;
        int postemperatura = 0;
        for (int i = 0; i < pMatTemperaturas.length; i++) {
            for (int j = 0; j < pMatTemperaturas[0].length; j++) {
                if (pMatTemperaturas[i][j] > tempMaisQuente) {
                    tempMaisQuente = pMatTemperaturas[i][j];
                    posCidade = i;
                    postemperatura = j;
                }
            }
        }
        return new double[]{posCidade, postemperatura, tempMaisQuente};
    }

    public static double[] diaMaisFrio(double[][] pMatTemperaturas) {
        double tempMaisFrio = Double.MAX_VALUE;
        double[][] matDiaMaisFrio = new double[1][1];
        int posCidade = 0;
        int postemperatura = 0;
        for (int i = 0; i < pMatTemperaturas.length; i++) {
            for (int j = 0; j < pMatTemperaturas[0].length; j++) {
                if (pMatTemperaturas[i][j] < tempMaisFrio) {
                    tempMaisFrio = pMatTemperaturas[i][j];
                    posCidade = i;
                    postemperatura = j;
                }
            }
        }
        return new double[]{posCidade, postemperatura, tempMaisFrio};
    }
}
