# MERCADAM - Documentación

## Introducción
MERCADAM es una aplicación que permite a los clientes realizar compras en línea con autenticación, promociones y gestión de pedidos. Este proyecto está compuesto por varias clases en Java.


## Estructura del Proyecto

El proyecto consta de las siguientes clases:

- **AppZonaClientes.java**: Controla el flujo principal del programa.
- **Cliente.java**: Representa a un cliente con sus datos y pedido.
- **Mercadam.java**: Administra la lista de clientes.
- **Pedido.java**: Maneja los pedidos y aplica promociones.
- **Producto.java** 
*(posiblemente un enum no proporcionado en los archivos compartidos).*

  
## Descripción 

### AppZonaClientes

Esta clase contiene el main y gestiona la interacción con el usuario:

- **main()**: Inicia el ciclo de autenticación y compra.
- **autenticacion(Set<Cliente> clientes)**: Verifica credenciales del usuario.
- **iniciarCompra()**: Permite a un cliente seleccionar productos.
- **imprimirProductos()**: Muestra los productos disponibles.
- **menu()**: Proporciona opciones para aplicar promociones, ver pedidos o eliminarlos.
- **imprimirDespedida()**: Muestra un mensaje de despedida.

>package org.example.MERCADAM;
import java.util.Scanner;
import java.util.Set;

public class AppZonaClientes {

    static Scanner entrada = new Scanner(System.in);
    static Cliente cliente;

    public static void main(String[] args) {

        boolean condicion = true;
        new Mercadam();
        while (condicion) {
            condicion = false;
            Mercadam.generarClientes();
            autenticacion(Mercadam.getClientes());
                iniciarCompra();
                cliente.getPedido().verPedido();
                menu();
                System.out.print("¿Quieres volver a iniciar sesión? [S/N]: ");
                switch (entrada.next().toLowerCase()){
                    case "s":
                        condicion = true;
                        break;
                    case "n":
                        System.out.println("POR FAVOR VUELVA PRONTO");
                        break;
                    default:
                        System.out.println("ELECCIÓN NO VALIDA");
                        System.out.println("ABORTANDO PROGRAMA");
                        break;
                }

        }
    }

    static void autenticacion(Set<Cliente> clientes){
        System.out.println("*** COMPRA ONLINE DE MERCADAW ***");
        boolean condicion = false;
        int tres = 1;
        for (int i = 0; i < 3; i++) {
            System.out.print("Usuario: ");
            String usuario = entrada.next();
            System.out.print("Contraseña: ");
            String contrasena = entrada.next();
            for (Cliente cliente :clientes){
                if (cliente.getUsuario().equalsIgnoreCase(usuario) && cliente.getContrasena().equals(contrasena)){
                    AppZonaClientes.cliente = cliente;
                    condicion = true;
                    break;
                }
            }
            if (condicion) {
                break;
            }
            if (tres == 3){
                System.out.println("ERROR DE AUTENTIFICACION");

            }else{
            System.out.println("Algo no coincide o no existe! Vuelve a intentarlo... ERROR DE AUTENTICACIÓN");
                tres++;
            }
        }
    }

    static void iniciarCompra(){
        System.out.println("BIENVENID@ " + cliente.getUsuario() + "!");
        cliente.crearPedido();
        boolean condicion = true;
        while (condicion){
            condicion = false;
            imprimirProductos();
            System.out.println("====================================");
            System.out.print("Elige un producto: ");
                String producto = entrada.next().toUpperCase();
                System.out.println("======================================");
                Producto prod = Producto.valueOf(producto);
                cliente.insertarProducto(prod);
                System.out.print("Has añadido "+ producto +" con un precio de "+ prod.getPrecio() +"€. Importe total del carrito: " + cliente.importePedido() +"€. ¿Quieres añadir más productos a tu carrito de la compra? [S/N]: ");
                boolean repetir = true;
            while (repetir){
                    repetir = false;
                    switch (entrada.next()) {
                        case "S":
                            condicion = true;
                            break;
                        case "N":
                            break;
                        default:
                            System.out.print("Elige una opción válida [S/N]: ");
                            repetir = true;
                            break;
                    }
                }

        }
    }

    static void imprimirProductos(){
        System.out.println("Añade productos a tu lista de la compra...");
        for (Producto producto :Producto.values()) {
            System.out.println(producto.name() +" precio ("+ producto.getPrecio() +"€)");
        }
    }

    static void imprimirDespedida(){
        System.out.println("====================================");
        System.out.println("GRACIAS POR SU PEDIDO. Se lo mandaremos a la dirección "+ cliente.getDireccion());
    }

    static void menu(){
        System.out.println("¿QUÉ DESEA HACER?");
        System.out.println("        [1]. Aplicar promo.");
        System.out.println("        [2]. Mostrar resumen ordenado por unidades.");
        System.out.println("        [3]. Eliminar productos.");
        System.out.println("        [X]. Terminar pedido.");
        System.out.println("=================================================");
        System.out.print("Elige una opción: ");
        boolean condicion = true;
        while (condicion){
            condicion = false;
            switch (entrada.next().toLowerCase()) {
                case "1":
                    System.out.println("=================================================");
                    if (cliente.isPromociones()){
                        System.out.println("YA HAS APLICADO TUS PROMOS.");
                    }else{
                        cliente.setPromociones();
                        cliente.getPedido().aplicarPromo3x2();
                        cliente.getPedido().aplicarPromo10();
                        System.out.println("PROMO 3x2 y 10% APLICADAS.");
                    }
                    cliente.getPedido().verPedido();
                    menu();
                    break;
                case "2":
                    cliente.getPedido().verPedidoOrdenado();
                    menu();
                    break;
                case "3":
                    if (cliente.isPromociones()){
                        System.out.println("=================================================");
                        System.out.println("NO PUEDES QUITAR PRODUCTOS SI YA HAS APLICADO TUS PROMOS.");
                    }else {
                        cliente.getPedido().verPedido();
                        boolean condicion2 = true;
                        while (condicion2){
                            condicion2 = false;
                            System.out.print("        Introduce el producto a quitar: ");
                                String producto = entrada.next().toUpperCase();
                                System.out.println("=================================================");
                                cliente.getPedido().quitarProductos(Producto.valueOf(producto));
                                cliente.getPedido().comprobar();
                                cliente.getPedido().verPedido();
                        }
                    }
                    menu();
                    break;
                case "x":
                    imprimirDespedida();
                    break;
                default:
                    System.out.print("Opcion no correcta, vuelva a elegeir");
                    condicion = true;
                    break;
            }
        }
    }

}

### Cliente

Clase que representa a un cliente.

- **Atributos:**
    - usuario: Nombre del cliente.
    - contrasena: Contraseña generada aleatoriamente.
    - direccion: Dirección del cliente.
    - pedido: Instancia de Pedido.
    - promociones: Indica si se aplicaron promociones.

- **Métodos:**
    - setUsuario(): Solicita el nombre de usuario.
    - setContrasenya(): Genera una contraseña aleatoria.
    - crearPedido(): Crea un nuevo pedido.
    - insertarProducto(Producto producto): Agrega productos al pedido.
    - importePedido(): Retorna el importe total del pedido.
>package org.example.MERCADAM;

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


### Mercadam

Clase que maneja la generación y almacenamiento de clientes.

- **Atributos:**
    - clientes: Conjunto de clientes registrados.
- **Métodos:**
    - generarClientes(): Agrega un nuevo cliente.
    - getClientes(): Devuelve la lista de clientes.

>package org.example.MERCADAM;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
public class Mercadam {

    static Set<Cliente> clientes;

    public Mercadam(){
        clientes = new HashSet<>();
    }

    static void generarClientes(){
        clientes.add(new Cliente());
    }

    static Set<Cliente> getClientes(){
        return Collections.unmodifiableSet(clientes);
    }
}


### Pedido

Clase encargada de gestionar pedidos y aplicar promociones.

- **Atributos:**
    - pedido: HashMap<Producto, Integer> con productos y cantidades.
    - importe_tota: Total acumulado del pedido.
- **Métodos:**
    - insertarProductos(Producto producto): Agrega productos al pedido.
    - quitarProductos(Producto producto): Permite quitar productos
> package org.example.MERCADAM;

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
