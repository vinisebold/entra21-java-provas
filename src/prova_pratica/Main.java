package prova_pratica;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // Inicializa Scanner
        Scanner input = new Scanner(System.in);

        // Declaração dos arrays
        String[] vetSemana = {"Segunda", "Terça", "Quarta", "Quinta", "Sexta", "Sábado", "Domingo"};
        String[] vetCidadesNomes = new String[4];
        double[][] matTemperaturas = new double[4][7];
        double[] vetMaisAlta = new double[3];

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
        System.out.println("===Media Temperatura===");
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

        System.out.println("===Média Geral===");
        System.out.printf("[Média Geral] %.2f°C%n", mediaTemperaturaGeral(matTemperaturas));

        System.out.println("===Dia mais Quente===");
        vetMaisAlta = diaMaisQuente(matTemperaturas);
        double posCidade = 0;
        double posTemperatura = 0;
        double vlrTemperatura = 0.0;
        for (int i = 0; i < vetMaisAlta.length; i++) {
            if (i == 0) {
                posCidade = vetMaisAlta[i];
            } else if (i == 1) {
                posTemperatura = vetMaisAlta[i];
            } else {
                vlrTemperatura = vetMaisAlta[i];
            }
        }
        int idxCidade = (int) posCidade;
        int idxTemp = (int) posTemperatura;
        System.out.println("A Temperatura em ºC em : " + vetCidadesNomes[idxCidade] + " na " + vetSemana[idxTemp] + " foi de " + vetSemana[idxTemp]);

        System.out.println("===Dia mais Frio===");
        System.out.println(diaMaisFrio(matTemperaturas));
        System.out.println(diaMaisFrio(matTemperaturas));
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
        double menor = pMatTemperaturas[pIndiceCidade][0];
        for (int j = 0; j < pMatTemperaturas[pIndiceCidade].length; j++) {
            if (pMatTemperaturas[pIndiceCidade][j] < menor) {
                menor = pMatTemperaturas[pIndiceCidade][j];
            }
        }
        return menor;
    }

    public static double maiorTemperatura(double[][] pMatTemperaturas, int pIndiceCidade) {
        double maior = pMatTemperaturas[pIndiceCidade][0];
        for (int j = 0; j < pMatTemperaturas[pIndiceCidade].length; j++) {
            if (pMatTemperaturas[pIndiceCidade][j] > maior) {
                maior = pMatTemperaturas[pIndiceCidade][j];
            }
        }
        return maior;
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
        double tempMaisQuente = 0;
        double matDiaMaisQuente[][] = new double[1][1];
        int posCidade = 0;
        int postemperatura = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 7; j++) {
                if (pMatTemperaturas[i][j] > tempMaisQuente) {
                    tempMaisQuente = pMatTemperaturas[i][j];
                    posCidade = i;
                    postemperatura = j;
                }
            }
        }
        return new double[]{posCidade, postemperatura, tempMaisQuente};
    }

    public static double diaMaisFrio(double[][] pMatTemperaturas) {
        double diaMaisFrio = pMatTemperaturas[0][0];
        int lin = 0;
        int col = 0;
        for (int i = 0; i < pMatTemperaturas.length; i++) {
            for (int j = 0; j < pMatTemperaturas[0].length; j++) {
                if (pMatTemperaturas[i][j] < diaMaisFrio) {
                    diaMaisFrio = pMatTemperaturas[i][j];
                    lin = i;
                    col = j;
                }
            }
        }
        return pMatTemperaturas[lin][col];
    }
}
