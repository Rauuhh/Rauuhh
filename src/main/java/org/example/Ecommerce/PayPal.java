package org.example.Ecommerce;

import java.util.Scanner;

/**
 * Pagar con Paypal.
 */
public class PayPal extends MetodoPago {

    static Scanner entrada = new Scanner(System.in);

    final double saldoPre = 23;
    private String cuenta;
    private double saldo;

    /**
     * Constructor que permite indicar cuenta y saldo.
     * @param cuenta correo asociado a la cuenta
     * @param saldo saldo disponible
     */
    public PayPal(String cuenta, double saldo) {
        this.saldo = saldo;
        this.cuenta = cuenta;
    }

    /**
     * Constructor que asigna un saldo predeterminado.
     * @param cuenta correo asociado a la cuenta
     */
    public PayPal(String cuenta) {
        this.cuenta = cuenta;
        this.saldo = saldoPre;
    }

    /**
     * Valida el formato del correo y el saldo disponible.
     * @param cuenta correo electrónico
     * @param importe importe a pagar
     * @return true si la validación es correcta
     */
    private boolean validarPayPal(String cuenta, double importe) {
        System.out.println("Validando cuenta:");
        if (cuenta.matches(".*@*.com") && importe <= saldo) {
            return true;
        }
        System.out.println("Datos incorrectos o saldo insuficiente.");
        return false;
    }

    @Override
    void procesarPago(double importe) {
        System.out.println("Procesando pago de " + importe + "€ con PayPal");
        if (validarPayPal(this.cuenta, importe)) {
            System.out.println("Pago aceptado.");
        }
    }

    @Override
    public String toString() {
        return "PayPal: cuenta: " + cuenta + ", saldo: " + saldo;
    }
}
