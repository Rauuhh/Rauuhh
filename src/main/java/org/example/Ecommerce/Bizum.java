package org.example.Ecommerce;

import java.util.Random;
import java.util.Scanner;

/**
 * Pagar con bizum
 */
public class Bizum extends MetodoPago {

    static Random random = new Random();
    static Scanner entrada = new Scanner(System.in);

    private String telefono;
    private int pin;

    /**
     * Constructor que genera un PIN y valida el pago.
     * @param telefono número de teléfono asociado
     */
    public Bizum(String telefono) {
        this.telefono = telefono;
        this.pin = generarPin();
        validarBizum(entrada.nextInt());
    }

    /**
     * Genera un PIN aleatorio de 6 cifras.
     * @return PIN generado
     */
    public static int generarPin() {
        int pin = random.nextInt(100000, 999999);
        System.out.println(pin);
        return pin;
    }

    /**
     * Valida el número de teléfono y el PIN introducido.
     * @param pin PIN introducido por el usuario
     */
    public void validarBizum(int pin) {
        System.out.println("Validando bizum:");
        if (telefono.matches("[0-9]{9}") && this.pin == pin) {
            System.out.println("Pin correcto");
        } else {
            System.out.println("Error");

        }
    }

    @Override
    void procesarPago(double importe) {
        System.out.println("Procesando pago de " + importe + "€ con Bizum.");
    }

    @Override
    public String toString() {
        return "Bizum{" +
                "telefono='" + telefono + '\'' +
                ", pin=" + pin +
                '}';
    }
}
