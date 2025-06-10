package prova_pratica;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // Inicializa Scanner
        Scanner input = new Scanner(System.in);

        // Declaração dis arrays
        String[] vetSemana = {"Segunda", "Terça", "Quarta", "Quinta", "Sexta", "Sábado"};
        String[] vetCidadesNomes = new String[4];
        double[][] matTemperaturas = new double[4][7];

        // Entrada de dados
        for (int i = 0; i < vetCidadesNomes.length; i++) {
            System.out.print("(" + (i + 1) + ") Informe o nome da cidade: ");
            vetCidadesNomes[i] = input.nextLine();


            for (int j = 0; j < vetSemana.length; j++) {
                System.out.print("Informe a temperatura de " + vetSemana[j] + ": ");
                matTemperaturas[i][j] = input.nextDouble();
                input.nextLine();
            }
        }

        // Fecha Scanner
        input.close();
    }
}
