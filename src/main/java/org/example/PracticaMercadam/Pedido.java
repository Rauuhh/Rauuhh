package org.example.PracticaMercadam;

import java.util.HashMap;
import java.util.Map;

import static org.example.PracticaMercadam.AppZonaClientes.entrada;

public class Pedido {

    private HashMap<Producto,Integer> pedido;
    private double importeTotal;

    public Pedido() {
        pedido = new HashMap<>();
        importeTotal = 0;
    }

    public void actualizarImporteTotal(double importe){
        this.importeTotal += importe;
    }
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
