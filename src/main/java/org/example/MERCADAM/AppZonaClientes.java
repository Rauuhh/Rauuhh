package org.example.MERCADAM;
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
