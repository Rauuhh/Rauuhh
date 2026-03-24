package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Spectrum {
    static void main() {
        Scanner entrada = new Scanner(System.in);
        System.out.println("******* VALIDADOR DE COMPATIBILIDAD ZX SPECTRUM *******");
        System.out.println("Introduce la resolucion de tu pantalla (ancho x alto)");
        System.out.println("Ancho:");
        int ancho = 0;
        try{
            ancho = entrada.nextInt();
        }catch (InputMismatchException e ){
            System.out.println("Valor incorrecto");
            return;
        }
        //El ancho tiene que ser divisible entre 8 y menor de 48
        if (ancho % 8 != 0 || ancho > 48 ){
            System.out.println("Numero no compatible");
            return;
        }
        System.out.println("Alto:");
        int alto =  0;
        try {
            alto =entrada.nextInt();
        }catch (InputMismatchException e ){
            System.out.println("Formato incorrecto");
            return;
        }
        //El alto tiene que ser divisible entre 8 y menor de 48
        if (alto % 8 != 0 || alto > 48 ){
            System.out.println("Numero no compatible");
            return;
        }
        String[][] spectrum = new String[alto][ancho];
        System.out.println("Introduce (linea a linea los colores de tu imagen para cada pixel:)");
        hola:
        //Bucle para meter los valores a la matriz, si no es una letra entre la a y la o, vuelve a pedir la linea
        for (int i = 0; i < spectrum.length; i++) {
            String linea = entrada.next();
            for (int j = 0; j < spectrum[0].length; j++) {
                if (!linea.substring(j,j+1).matches("[a-oA-O]")){
                    System.out.println("Has introducido un valor de pixel incorrecto");
                    i--;
                    continue hola;
                }else{
                    spectrum[i][j] = linea.substring(j,j+1);
                }
            }
        }
        int vecesI = 0;
        int vecesJ = 0;
        int contador =0;
        for (int i = 0; i < spectrum.length; i++) {
            for (int j = 0; j < spectrum[0].length; j++) {
                System.out.print(spectrum[i][j] + " ");
            }
            System.out.println();
        }
        //Booleano para saber si es compatible o no
        boolean estado = true;
        int conta = 1;
        int conta2 = 1;
        String letra1 = "";
        String letra2 = "";
        //Doble for para ver cada letra, recorreremos cada 8x8 por el X = x +8
        hola:
        for (int i = 0; i < 8 * conta; i++) {
            for (int j = 0; j < 8 * conta2; j++) {
                if (letra1.equals("")){
                    letra1 = spectrum[i][j];
                } else if (!letra1.equals(spectrum[i][j]) && letra2.equals("")) {
                    letra2 = spectrum[i][j];
                } else if (!letra1.equals(spectrum[i][j]) && !letra2.equals(spectrum[i][j])) {
                    estado = false;
                    break hola;
                }

                if (j * conta2 == 7 * conta2 && j < spectrum.length && i * conta == 7){

                    j = 8 * conta2;
                    conta2++;
                    letra1 = "";
                    letra2 = "";
                }
                if (i * conta == 7 * conta && i < spectrum[0].length){
                    i = 8 * conta;
                    conta++;
                    letra1 = "";
                    letra2 = "";

                }
            }

        }
        //Usamos el booleano para ver si es compatible o no
        if (estado) {
            System.out.println("Es compatible con un ZX Spectrum");
        } else {
            System.out.println("No es compatible con un ZX Spectrum");
        }
    }
}