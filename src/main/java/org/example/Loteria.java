package org.example;

import java.util.Random;
import java.util.Scanner;

public class Loteria {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in) ;
        Random aleatorio = new Random();
        System.out.println("Introduce el boleto con el formato N-N-N-N-N-N/R Numeros entre el 1 - 49 y el reintegro entre 0 - 9");
        String boleto = entrada.nextLine();

        if (!boleto.matches("(\\d{1,2}-){5}\\d{1,2}/\\d")) {
            System.out.println("Formato incorrecto.");
            return;
        }

        String partes [] = boleto.split("[-/]");
        int numerosUsuario[] = new int [6];
        int reintegroUsuario = Integer.parseInt(partes[6]);

        for (int i = 0; i < 6; i++) {
            numerosUsuario[i] = Integer.parseInt(partes[i]);
            if (numerosUsuario[i] < 1 || numerosUsuario[i] > 49) {
                System.out.println("Numero fuera de rango");
                return;
            }
        }

        if (reintegroUsuario < 0 || reintegroUsuario > 9) {
            System.out.println("Reintegro fuera del rango 0-9");
            return;
        }

        int numerosGanadores [] = new int[6];
        for (int i = 0;i < 6;i++){
            int num;
            boolean repetido;
            do {
                num = aleatorio.nextInt(49) + 1;
                repetido = false;
                for (int j = 0; j < i; j++) {
                    if (numerosGanadores[j] == num){
                        repetido = true;
                        break;
                    }
                }
            } while (repetido);
            numerosGanadores[i] = num;
        }
        int numeroComplementario = 0;
        boolean repetido = true;
        do {
            numeroComplementario = aleatorio.nextInt(49) + 1;
            repetido = false;
            for (int i = 0; i < 6; i++) {
                if (numerosGanadores[i] == numeroComplementario) {
                    repetido = true;
                    break;
                }
            }
        } while (repetido);
        int reintegroGanador = aleatorio.nextInt(10);
        int contador = 0;
        if (reintegroGanador == reintegroUsuario)
        {
            contador = 1;
        }

        System.out.println("SORTEO: ");
        for (int i = 0;i < 6; i++){
            System.out.print(numerosGanadores[i] + " ");
        }
        System.out.println();
        System.out.println("Numero complementario: " +numeroComplementario);
        System.out.println("Reintegro: "+reintegroGanador);

        int aciertos = 0;
        for (int i = 0;i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if (numerosUsuario[i] == numerosGanadores[j]) {
                    aciertos++;
                }
            }
        }
        System.out.println("RESULTADOS:");
        if (aciertos == 1){
            System.out.println(aciertos + " acierto.");
        }else{
            System.out.println(aciertos + " aciertos.");
        }
        if ( contador == 1)
        {
            System.out.println("Reintegro");
        }
    }
}
