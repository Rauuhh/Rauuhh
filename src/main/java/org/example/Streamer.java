package org.example;

import java.util.Scanner;

public class Streamer {
    static void main() {
        Scanner entrada = new Scanner(System.in);
        System.out.println("*** ESTADISTICAS PREMIOS ESLAND ***");
        System.out.println("------------------------------------");
        System.out.println("Inserta streamer a analizar: ");
        String streamer = entrada.nextLine();
        System.out.println("Inserta los espectadores medidos");
        String espectadores = entrada.nextLine();
        String[] medidos = espectadores.split(" ");
        float[] especInts = new float[medidos.length];
        for (int i = 0; i < medidos.length; i++) {
            try {
                especInts[i] = Integer.parseInt(medidos[i]);
            } catch (NumberFormatException e) {
                System.out.println("Hay algun valor no valido");
                return;
            }
        }
        System.out.println("Inserta el numero de comentarios");
        String comentarios = entrada.nextLine();
        String[] comments = comentarios.split(" ");
        float[] commentsInts = new float[comments.length];
        for (int i = 0; i < comments.length; i++) {
            try {
                commentsInts[i] = Integer.parseInt(comments[i]);
            } catch (NumberFormatException e) {
                System.out.println("Hay algun valor no valido");
                return;
            }
        }
        float max = 0;
        float min = especInts[0];
        float hype = 0;
        int contador = 0;
        for (int i = 0; i < especInts.length; i++) {
            if (especInts[i] > max){
                max = especInts[i];
            }
        }
        for (int i = 0; i < especInts.length; i++) {
            if (commentsInts[i]/especInts[i] > hype){
                hype = commentsInts[i]/especInts[i];
                contador = i+1;
            }
        }
        for (int i = 0; i < especInts.length; i++) {
            if (especInts[i] < min){
                min = especInts[i];
            }
        }

        float racha =((max - min) * 100) / max;
        System.out.println("@" + streamer);
        System.out.println("MAX=" + max);
        System.out.println("HYPE=" +contador + " (" +  hype + ")");
        System.out.println("RACHA=" + racha);
    }
}