package org.example.Ecommerce;

import java.util.Scanner;

/**
 * Clase que gestiona el proceso de pago en la tienda.
 */
public class Tienda {

    static Scanner entrada = new Scanner(System.in);

    /**
     * Ejecuta el pago usando el método seleccionado.
     * @param metodo método de pago
     * @param importe importe a pagar
     */
    static void realizarPago(MetodoPago metodo, double importe) {
        metodo.procesarPago(importe);
    }

    /**
     * Inicia el proceso de selección del método de pago.
     */
    static void iniciarPago() {
        System.out.println("¿Qué método de pago quieres usar? [Bizum, PayPal, Tarjeta]:");
        volver:
        while (true) {
            String metodo = entrada.nextLine().toLowerCase();
            switch (metodo) {
                case "tarjeta":
                    procesoTarjeta();
                    break volver;
                case "paypal":
                    procesoPayPal();
                    break volver;
                case "bizum":
                    procesoBizum();
                    break volver;
                default:
                    System.out.println("Introduce de nuevo el tipo de pago:");
            }
        }
    }

    /**
     * Gestiona el proceso de pago con tarjeta.
     */
    private static void procesoTarjeta() {
        System.out.println("Introduce los datos de tu tarjeta:");
        System.out.println("Número (16 dígitos):");
        String nro_tarjeta = entrada.next();
        System.out.println("tipo (VISA , MASTERCARD o MAESTRO):");
        String tipo = entrada.next().toUpperCase();
        MetodoPago tarjeta = new TarjetaCredito(nro_tarjeta, tipo);
        System.out.println("Introduce el importe a pagar:");
        realizarPago(tarjeta, entrada.nextDouble());
    }

    /**
     * Gestiona el proceso de pago con Bizum.
     */
    private static void procesoBizum() {
        System.out.println("Introduzca su número de teléfono:");
        String telefono = entrada.next();
        System.out.println("Introduzca el pin:");
        MetodoPago bizum = new Bizum(telefono);
        System.out.println("Introduce el importe a pagar:");
        realizarPago(bizum, entrada.nextDouble());
    }

    /**
     * Gestiona el proceso de pago con PayPal.
     */
    private static void procesoPayPal() {
        System.out.println("Introduzca el mail asociado a la cuenta:");
        String cuenta = entrada.next();
        MetodoPago paypal = new PayPal(cuenta);
        System.out.println("Introduzca el importe a pagar:");
        realizarPago(paypal, entrada.nextDouble());
    }
}
