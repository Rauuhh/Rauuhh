package org.example.Ecommerce;

/**
 * Clase abstracta que define el comportamiento común
 * de todos los métodos de pago.
 */
abstract class MetodoPago {

    /**
     * Procesa un pago con el importe indicado.
     * @param importe cantidad a pagar
     */
    abstract void procesarPago(double importe);
}
