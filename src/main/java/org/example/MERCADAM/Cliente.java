package org.example.MERCADAM;

import java.util.Objects;
import java.util.Random;
import java.util.Scanner;


public class Cliente {

    static Scanner entrada = new Scanner(System.in);

    static final String CARACTERES = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    static Random random = new Random();

    private final String DIRECCION = "Calle falsa, 123";

    private String usuario;
    private String contrasena;
    private String direccion;
    private Pedido pedido;
    boolean promociones;

    public Cliente(){
        setUsuario();
        setContrasenya();
        this.pedido = null;
        this.promociones = false;
        this.direccion = DIRECCION;
    }
    public String getContrasena() {
        return contrasena;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getDireccion() {
        return direccion;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public boolean isPromociones() {
        return promociones;
    }

    private void setUsuario() {
        System.out.print("Dame tu usuario: ");
        this.usuario = entrada.next();
    }

    private void setContrasenya() {
        String contra = "";
        for (int i = 0; i < 8; i++) {
            contra += CARACTERES.charAt(random.nextInt(CARACTERES.length()));
        }
        this.contrasena = contra;
        System.out.println(contra);
    }


    public void setPromociones(){
        this.promociones = true;
    }

    public void crearPedido(){
        this.pedido = new Pedido();
    }

    public void insertarProducto(Producto producto){
        this.pedido.insertarProductos(producto);
    }

    public double importePedido(){
        return pedido.getImporte_total();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return Objects.equals(usuario, cliente.usuario);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(usuario);
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "usuario=" + usuario +
                " contrasenya=" + contrasena +
                " direccion=" + direccion +
                "pedido=" + pedido +
                "promociones=" + promociones +
                '}';
    }
}
