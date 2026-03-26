package org.example.PracticaMercadam;

import java.util.HashMap;
import java.util.Map;


public class Pedido {

    private HashMap<Producto,Integer> pedido;
    private double importeTotal;

    /**
     * Pedido de un cliente
     */
    public Pedido() {
        pedido = new HashMap<>();
        importeTotal = 0;
    }

    /**
     * Suma cantidad a el importe total
     * @param importe, Es el valor a sumar
     */
    public void actualizarImporteTotal(double importe){
        this.importeTotal += importe;
    }

    /**
     * Aplica promocion 3x2 por cada 3 productos de cada tipo que haaya
     */
    public void aplicarPromo3x2(){
        double descuento = 0;
        for (Map.Entry<Producto, Integer> des : pedido.entrySet()) {
            int cantidad = des.getValue();
            double precioUnidad = des.getKey().getPrecio();
            int unidadesGratis = cantidad / 3;
            descuento += unidadesGratis * precioUnidad;
        }
        this.importeTotal -= descuento;
    }


    /**
     * Descuenta el 10% del total
     */
    public void aplicarpromo10(){
        this.importeTotal *= 0.90;
    }

    public HashMap<Producto, Integer> getPedido() {
        return pedido;
    }

    public void setPedido(HashMap<Producto, Integer> pedido) {
        this.pedido = pedido;
    }

    public double getImporteTotal() {
        return importeTotal;
    }

    public void setImporteTotal(double importeTotal) {
        this.importeTotal = importeTotal;
    }
}
