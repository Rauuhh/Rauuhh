package org.example;

import java.util.Set;
import java.util.TreeSet;

public class MichaelYPatoDonald {

    static java.util.Scanner entrada;

    public static boolean casoDePrueba() {
        int entradas = entrada.nextInt();
        if (entradas ==0){
            return false;
        } else {
            Set<String> cumples = new TreeSet<>();
            boolean si = false;
            for (int i = 0; i < entradas; i++) {
                String[] fecha = entrada.next().split("/");
                if (cumples.contains(fecha[0] + " " + fecha[1])) {
                    si = true;
                    entrada.nextLine();
                    break;
                }else {
                    cumples.add( fecha[0] + " " + fecha[1] );
                }
            }
            if (si)
            {
                System.out.println("SI");
            }else{
                System.out.println("NO");
            }
            return true;
        }
    }

    public static void main(String[] args) {
        entrada = new java.util.Scanner(System.in);
        while (casoDePrueba()) {
        }
    }
}