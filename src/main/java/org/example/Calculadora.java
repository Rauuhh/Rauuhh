package org.example;

import java.util.Scanner;

public class Calculadora {
    static void main() {
        Scanner entrada = new Scanner(System.in);

        double num1 = 0;
        double num2 = 0;
        double resultado = 0;
        String operando;

        System.out.println("**** BIENVENIDO A LA CALCULADORA RÁPIDA ****");
        System.out.println("Introduce operando");
        if (!entrada.hasNextDouble()){
            System.out.println("No es un numero");
        }else{
            num1 = entrada.nextDouble();
            System.out.println("-----------------------");
            System.out.println("[+] -> Sumar");
            System.out.println("[-] -> Restar");
            System.out.println("[x] -> Multiplicar");
            System.out.println("[/] -> Dividir");
            System.out.println("[R] -> Raiz cuadrada");
            System.out.println("-----------------------");
            System.out.println("Elige una opcion");
            operando = entrada.next().toUpperCase();
            if (operando.equals("X") || operando.equals("-") || operando.equals("+") || operando.equals("/"))
            {
                System.out.println("Escribe el segundo numero");
            }
            switch (operando){
                case "+":
                    if (!entrada.hasNextDouble()){
                        System.out.println("No es un numero");
                    }else{
                        num2 = entrada.nextDouble();
                        resultado = num1 + num2;
                        System.out.println("El resultado de " + num1 + " " + operando + " " + num2 + " es " + resultado);
                    }
                    break;
                case "-":
                    if (!entrada.hasNextDouble()){
                        System.out.println("No es un numero");
                    }else {
                        num2 = entrada.nextDouble();
                        resultado = num1 - num2;
                        System.out.println("El resultado de " + num1 + " " + operando + " " + num2 + " es " + resultado);
                    }
                    break;
                case "X":
                    if (!entrada.hasNextDouble()){
                        System.out.println("No es un numero");
                    }else {
                        num2 = entrada.nextDouble();
                        resultado = num1 * num2;
                        System.out.println("El resultado de " + num1 + " " + operando + " " + num2 + " es " + resultado);
                    }
                    break;
                case "/":
                    if (!entrada.hasNextDouble()){
                        System.out.println("No es un numero");
                    }
                    else {
                        num2 = entrada.nextDouble();
                        if(num2 == 0 || num1 == 0){
                            System.out.println("No puedes dividir entre 0");
                        }else {
                            resultado = num1 / num2;
                            System.out.println("El resultado de " + num1 + " " + operando + " " + num2 + " es " + resultado);
                        }
                    }
                    break;
                case "R":
                    if (num1 >= 0) {
                        resultado = Math.sqrt(num1);
                        System.out.println("La raiz cuadrada de " + num1 + " es " + resultado);
                    }else{
                        System.out.println("No hay raices negativa");
                    }
                    break;
                default:
                    System.out.println("No es un operando correcto");
                    break;
            }
        }
    }
}