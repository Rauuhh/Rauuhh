package org.example.PracticaMercadam;

public enum Producto {
    MANZANAS(2.3),PAN(1),ARROZ(3.5),POLLO(4.3),LECHE(1.3),ACEITE(8.3),HUEVOS(3.3),TOMATES(4),PASTA(0.89);

    private double precio;

    Producto(double precio) {
        this.precio = precio;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}
