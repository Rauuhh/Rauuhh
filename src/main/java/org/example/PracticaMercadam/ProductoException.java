package org.example.PracticaMercadam;

public class ProductoException extends RuntimeException {
    public ProductoException() {
        super("Ese producto no se encuentra en la lista");
    }
}
