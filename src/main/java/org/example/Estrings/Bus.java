package org.example.Estrings;

import java.util.Random;

public class Bus {

    public static final int TAM = 97;

    public static void main(String[] args) throws InterruptedException {

        int a = 0; // POSICIÓN INICIAL DEL AUTOBÚS
        int b = 0;
        int c = 0;
        int d = 0;
        int e = 0;

        System.out.println("\n<<<<<<<<<< CARRERA DE BUSES WOWOWOWOWOWOWOWOWOWOWOOWOWWOWOWO >>>>>>>>>>");
        System.out.println("\n<<<<<<<<<<                   ITALIAN BRAINROT                >>>>>>>>>>");
        System.out.println("\n<<<<<<<<<<                        FIGHT!                     >>>>>>>>>>");
        Thread.sleep(3000);

        while (a < TAM && b < TAM && c < TAM && d < TAM && e<TAM) {
            Random ran = new Random();
            int aleatorio = ran.nextInt(5)+1;

            limpiarPantalla();

            if (aleatorio == 1)
            {
                a++;
            } else if (aleatorio == 2) {
                b++;
            } else if (aleatorio == 3) {
                c++;
            } else if (aleatorio == 4) {
                d++;
            }else
            {
                e++;
            }


            if (a<TAM && b<TAM && c < TAM && d < TAM && e<TAM) {
                System.out.println(dibujarCarrera(a,b,c,d,e));
                Thread.sleep(70);
            }


        }

        if (a >= TAM)
        {
            System.out.println("\033[32m"+ "EL AUTOBUSITO BOMBARDIRO CROCODILO HA LLEGADO A SU DESTINO!!" + "\033[0m");
        } else if (b >= TAM) {
            System.out.println("\033[32m"+ "EL AUTOBUSITO  LIRILI LARILA HA LLEGADO A SU DESTINO!!" + "\033[0m");
        }else if (c >= TAM) {
            System.out.println("\033[32m"+ "EL AUTOBUSITO  TUNG TUNG SAHUR HA LLEGADO A SU DESTINO!!" + "\033[0m");
        }else if (d >= TAM) {
            System.out.println("\033[32m"+ "EL AUTOBUSITO  TRALARELO TRALALA HA LLEGADO A SU DESTINO!!" + "\033[0m");
        }else{
            System.out.println("\033[32m"+ "EL AUTOBUSITO  BRR BRR PATAPIN HA LLEGADO A SU DESTINO!!" + "\033[0m");
        }
    }


    public static String dibujarCarrera(int n1, int n2, int n3, int n4, int n5) {

        StringBuilder sb = new StringBuilder();

        sb.append("-".repeat(117)).append("\n");
        sb.append(" ".repeat(n1)).append("__________________     ").append(" ".repeat(97 - n1)).append("|\n");
        sb.append(" ".repeat(n1)).append("|__|__|__|__|__|__|___ ").append(" ".repeat(TAM - n1)).append("|\n");
        sb.append(" ".repeat(n1)).append("|BOMBARDIRO CROCODILO|)").append(" ".repeat(TAM - n1)).append("|\n");
        sb.append(" ".repeat(n1)).append("|~~~~@~~~~~~~~~~@~~~~|)").append(" ".repeat(TAM - n1)).append("|\n");

        sb.append(" ".repeat(n2)).append("__________________     ").append(" ".repeat(97 - n2)).append("|\n");
        sb.append(" ".repeat(n2)).append("|__|__|__|__|__|__|___ ").append(" ".repeat(TAM - n2)).append("|\n");
        sb.append(" ".repeat(n2)).append("|     LIRILI LARILA  |)").append(" ".repeat(TAM - n2)).append("|\n");
        sb.append(" ".repeat(n2)).append("|~~~~@~~~~~~~~~~@~~~~|)").append(" ".repeat(TAM - n2)).append("|\n");

        sb.append(" ".repeat(n3)).append("__________________     ").append(" ".repeat(97 - n3)).append("|\n");
        sb.append(" ".repeat(n3)).append("|__|__|__|__|__|__|___ ").append(" ".repeat(TAM - n3)).append("|\n");
        sb.append(" ".repeat(n3)).append("|   TUNG TUNG SAHUR  |)").append(" ".repeat(TAM - n3)).append("|\n");
        sb.append(" ".repeat(n3)).append("|~~~~@~~~~~~~~~~@~~~~|)").append(" ".repeat(TAM - n3)).append("|\n");

        sb.append(" ".repeat(n4)).append("__________________     ").append(" ".repeat(97 - n4)).append("|\n");
        sb.append(" ".repeat(n4)).append("|__|__|__|__|__|__|___ ").append(" ".repeat(TAM - n4)).append("|\n");
        sb.append(" ".repeat(n4)).append("| TRALARELO TRALALA  |)").append(" ".repeat(TAM - n4)).append("|\n");
        sb.append(" ".repeat(n4)).append("|~~~~@~~~~~~~~~~@~~~~|)").append(" ".repeat(TAM - n4)).append("|\n");

        sb.append(" ".repeat(n5)).append("__________________     ").append(" ".repeat(97 - n5)).append("|\n");
        sb.append(" ".repeat(n5)).append("|__|__|__|__|__|__|___ ").append(" ".repeat(TAM - n5)).append("|\n");
        sb.append(" ".repeat(n5)).append("|  BRR BRR PATAPIN   |)").append(" ".repeat(TAM - n5)).append("|\n");
        sb.append(" ".repeat(n5)).append("|~~~~@~~~~~~~~~~@~~~~|)").append(" ".repeat(TAM - n5)).append("|\n");
        sb.append("-".repeat(117)).append("\n");

        return sb.toString();

    }

    public static void limpiarPantalla() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception e) {
            System.out.print("\033[H\033[2J");
            System.out.flush();
        }
    }

}
