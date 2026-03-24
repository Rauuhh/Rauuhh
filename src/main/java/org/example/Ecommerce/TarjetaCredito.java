package org.example.Ecommerce;

/**
 * Pagar con tarjeta de credito
 */
public class TarjetaCredito extends MetodoPago {

    private String nro_tarjeta;
    private String tipo;

    /**
     * Constructor que crea una tarjeta y valida sus datos.
     * @param nro_tarjeta número de tarjeta (16 dígitos)
     * @param tipo tipo de tarjeta (VISA, MASTERCARD o MAESTRO)
     */
    public TarjetaCredito(String nro_tarjeta, String tipo) {
        this.nro_tarjeta = nro_tarjeta;
        this.tipo = tipo;
        validarTarjeta(nro_tarjeta, tipo);
    }

    /**
     * Validar el número y tipo de tarjeta.
     * @param nro_tarjeta número de tarjeta
     * @param tipo tipo de tarjeta
     */
    private void validarTarjeta(String nro_tarjeta, String tipo) {
        System.out.println("Validando tarjeta:");
        if (nro_tarjeta.matches("\\d{16}") &&
                (tipo.equalsIgnoreCase("VISA") ||
                        tipo.equalsIgnoreCase("MASTERCARD") ||
                        tipo.equalsIgnoreCase("MAESTRO"))) {
            return;
        }
        System.out.println("Los datos de tu tarjeta no son correctos.");

    }

    @Override
    void procesarPago(double importe) {
        System.out.println("Procesando pago de " + importe + "€ con tarjeta de crédito " + tipo);
    }

    @Override
    public String toString() {
        return "TarjetaCredito{" +
                "nro_tarjeta='" + nro_tarjeta + '\'' +
                ", tipo='" + tipo + '\'' +
                '}';
    }
}
