package org.example.Diccionario;

import java.util.Scanner;

public class AppDiccionario {

    static Scanner entrada = new Scanner(System.in);

    public static void main(String[] args) {

        Diccionario diccionario = new Diccionario();

        diccionario.nuevoPar("Perro","Dog");
        diccionario.nuevoPar("Cielo","Sky");
        diccionario.nuevoPar("Tierra","Dirt");
        diccionario.nuevoPar("Hola","Hello");
        diccionario.nuevoPar("Puerta","Door");

        double contador = 0;
        double contador2 = 0;
        double contador3 = 0;

        while(true){
            System.out.println();
            String palabra = diccionario.palabraAleatoria();
            System.out.println(palabra + ": " + diccionario.primeraLetraTraduccion(palabra) + "...");
            System.out.print("Di la respuesta: ");
            String respuesta = entrada.next();
            if (respuesta.equalsIgnoreCase(diccionario.traducir(palabra))){
                System.out.println("CORRECTO");
                contador2++;
            }
            else if (respuesta.equalsIgnoreCase("fin")) {
                break;
            } else{
                System.out.println("NO, La respuesta  es " + diccionario.traducir(palabra));
                contador3++;
            }
            contador++;
        }

        System.out.println("FIN DEL PROGRAMA");
        System.out.println("Total preguntas: " + contador);
        System.out.println("Total aciertos: " + contador2);
        System.out.println("Total errores: " + contador3);
        System.out.println("Aciertos: " + (contador2 / contador)*100 + "%");

    }

}