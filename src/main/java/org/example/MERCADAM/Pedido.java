package org.example.MERCADAM;

import java.util.*;

public class Pedido {

    static Scanner entrada = new Scanner(System.in);

    private final double DESCUENTO = 10;

    private HashMap<Producto, Integer> pedido;
    private double importe_total;

    public Pedido(){
        this.pedido = new HashMap<>();
        this.importe_total = 0;
    }

    public void insertarProductos(Producto producto){
        this.pedido.put(producto, pedido.getOrDefault(producto, 0) + 1);
        this.importe_total += producto.getPrecio();
    }

    public void quitarProductos(Producto producto){
        System.out.print("Introduce la cantidad de " + producto + " que quieres quitar: ");
        boolean condicion = true;
        while (condicion){

                condicion = false;
                int cantidad = entrada.nextInt();
                if (cantidad > pedido.get(producto)) {
                    condicion = true;
                    System.out.println("No tienes esa cantidad de " + producto);
                    System.out.print("Introduce de nuevo la cantidad que quieres quitar: ");
                } else if(cantidad <= 0) {
                    condicion = true;
                    System.out.println("No puedes quitar esa cantidad de " + producto);
                    System.out.print("Introduce de nuevo la cantidad que quieres quitar: ");
                } else {
                    int nuevo = pedido.get(producto) - cantidad;
                    pedido.replace(producto, nuevo);
                }
        } ;
        System.out.println("=================================================");
    }

    public void comprobar(){
        double cantidad = 0;
        Producto out = null;
        for (Map.Entry<Producto, Integer> mapa : pedido.entrySet()){
            if (mapa.getValue() == 0){
                out = mapa.getKey();
            } else {
                cantidad += mapa.getValue() * mapa.getKey().getPrecio();
            }
        }
        pedido.remove(out);
        this.importe_total = cantidad;
    }

    public void verPedido(){
        System.out.println("=================================================");
        System.out.println("RESUMEN DE TU CARRITO DE LA COMPRA:");
        System.out.println("Productos:");
        for (Map.Entry<Producto, Integer> mapa : pedido.entrySet()){
            System.out.println(mapa.getValue() + " - " + mapa.getKey() + " (" + mapa.getKey().getPrecio() + "€).");
        }
        System.out.println("IMPORTE TOTAL: " + getImporte_total() + "€.");
        System.out.println("=================================================");
    }

    public void verPedidoOrdenado(){
        System.out.println("=================================================");
        System.out.println("RESUMEN DE TU CARRITO DE LA COMPRA:");
        System.out.println("Productos:");
        List<Map.Entry<Producto, Integer>> listaMapa = new ArrayList<>(pedido.entrySet());
        Comparator<Map.Entry<Producto, Integer>> compararPorCantidad = new Comparator<Map.Entry<Producto, Integer>>() {
            @Override
            public int compare(Map.Entry<Producto, Integer> o1, Map.Entry<Producto, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        };
        listaMapa.sort(compararPorCantidad);
        for (Map.Entry<Producto, Integer> mapa : listaMapa) {
            System.out.println(mapa.getValue() + " - " + mapa.getKey() + " (" + mapa.getKey().getPrecio() + "€).");
        }
        System.out.println("IMPORTE TOTAL: " + getImporte_total() + "€.");
        System.out.println("=================================================");
    }

    public void aplicarPromo3x2(){
        double total = 0;
        for (Map.Entry<Producto, Integer> mapa : pedido.entrySet()) {
            int num = mapa.getValue();
            int gratis = num / 3;
            total += (num - gratis) * mapa.getKey().getPrecio();
        }
        this.importe_total = total;
    }

    public void aplicarPromo10(){
        this.importe_total *= ((100 - DESCUENTO) / 100);
    }


    public HashMap<Producto, Integer> getPedido() {
        return pedido;
    }

    public double getImporte_total() {
        return importe_total;
    }
}
