package org.example.PracticaMercadam;

import java.util.*;

/**
 * Clase principal del programa, hace el login, elegir productos y su gestion
 */
public class AppZonaClientes {
    static Scanner entrada = new Scanner(System.in);
    static Cliente cliente;
    public static void main(String[] args) {


        Mercadam prueba = new Mercadam();
        Set<Cliente> lista = prueba.getClientes();
        System.out.println(lista);
        autentificacion(lista);
        imprimirResumen();
    }

    /**
     * Gestiona el sistema de inicio de sesion
     * @param clientes Conjunto de clientes validos
     */
    public static void autentificacion(Set<Cliente> clientes) {
        System.out.println(" === COMPRA ONLINE EN MERCADAM");
        boolean estado = false;
        for (int i = 2; i >= 0; i--) {
            System.out.print("usuario: ");
            String usuario = entrada.nextLine();
            System.out.print("contraseña: ");
            String contra = entrada.nextLine();
            for (Cliente clienteAux : clientes) {
                if (clienteAux.getUsuario().equals(usuario) && clienteAux.getContrasena().equals(contra)) {
                    cliente = clienteAux;
                    estado = true;
                    break;
                }
            }

            if (estado) {
                System.out.println("Bienvenido, " + cliente.getUsuario());
                iniciarCompra(); //
                break; //
            } else {
                if (i > 0) {
                    System.out.println("Credenciales no validas " + i + " intentos.");
                } else {
                    System.out.println("ERROR DE AUTENTIFICACION");
                }
            }
        }
    }

    /**
     * Bucle que el usuario pone productos hasta que diga que no mas
     * Lanza la excepcion si no existe un producto
     */
    public static void iniciarCompra(){
        cliente.crearPedido();
        System.out.println();


        boolean estado = true;

        while (estado) {
            imprimirProductos();
            System.out.println("Elige un producto de la lista");
            String pro = entrada.nextLine().toUpperCase();

            try {
                boolean existe = false;
                for (Producto p : Producto.values()) {
                    if (p.name().equals(pro)) {
                        existe = true;
                        break;
                    }
                }

                if (existe) {
                    // Si está, que se haga bien
                    Producto p = Producto.valueOf(pro);
                    cliente.insertarProducto(p);

                    System.out.println("Has añadido " + p.name() + " con un precio de " + p.getPrecio() + "€");
                    System.out.println("Importe total del pedido: " + cliente.getPedido().getImporteTotal() + "€");

                } else {

                    throw new ProductoException();
                }

            } catch (ProductoException e) {
                System.out.println(e);
                continue;
            }

            System.out.println("¿Quieres añadir más productos (S/N)?");
            String siono = entrada.nextLine();

            if (siono.equalsIgnoreCase("N")) {
                estado = false;
            }
        }

    }

    /**
     * Muestra los productos disponibles
     */
    public static void imprimirProductos() {
        System.out.println("Elige un producto de la lista...");
        for (Producto p : Producto.values()) {
            System.out.println(p.name() + " " + p.getPrecio()+ "€");
        }
    }

    /**
     * Muestra tus productos elegidos
     */
    public static void imprimirResumen(){
        System.out.println(" === RESUMEN DE TU CARRITO ===");
        System.out.println("Productos");


        HashMap<Producto, Integer> compra = cliente.getPedido().getPedido();
        for (Map.Entry<Producto, Integer> entrada : compra.entrySet()) {
            Producto p = entrada.getKey();
            int cantidad = entrada.getValue();
            double precio = p.getPrecio() * cantidad;

            System.out.println(cantidad + " " + p.name() + " " + precio + "€");
        }

        System.out.println("Importe total: " + cliente.getPedido().getImporteTotal());

        System.out.println("===============");
        System.out.println("¿Que desea hacer?");
        System.out.println("[1] Aplicar promos");
        System.out.println("[2] Mostrar resumen ordenado por uds");
        System.out.println("[3] Terminar pedido");

        int opcion = entrada.nextInt();
        switch (opcion){
            case 1:
                if (!cliente.isPromociones()){
                    Pedido ped = cliente.getPedido();
                    ped.aplicarPromo3x2();
                    ped.aplicarpromo10();

                    cliente.setPromociones(true);

                    System.out.println("=============");
                    System.out.println("Promo 3x2 y 10% aplicadas");
                    System.out.println("=============");
                    imprimirResumen();
                }else{
                    System.out.println("las promociones ya fueron aplicadas");
                }
                break;
            case 2:
                List<Map.Entry<Producto,Integer>> mapaordenado = new ArrayList<>(compra.entrySet());
                Collections.sort(mapaordenado, Map.Entry.comparingByValue());
                Collections.reverse(mapaordenado);

                double total = 0;
                for (Map.Entry<Producto, Integer> entrada : compra.entrySet()) {
                    Producto p = entrada.getKey();
                    int cantidad = entrada.getValue();
                    double precio = p.getPrecio() * cantidad;
                    total += precio;

                    System.out.println(cantidad + " " + p.name() + " " + precio + "€");
                }
        }
    }

    /**
     * Despedida del programa
     */
    public static void imprimirDespedida(){
        System.out.println("=== GRACIAS POR SU PEDIDO ===");
        System.out.println("Lo recibira en unos dias en la direccion " + cliente.getDireccion());
    }
}









