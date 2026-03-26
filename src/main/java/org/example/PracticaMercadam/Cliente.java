package org.example.PracticaMercadam;

public class Cliente {
   //{}
    private String usuario;
    private String contrasena;
    private String direccion;
    private Pedido pedido;
    private boolean promociones;

    /**
     * Constructor que crea a un cliente
     * @param usuario nombre de usuario
     * @param contrasena contraseña
     */
    public Cliente(String usuario, String contrasena) {
        this.usuario = usuario;
        this.contrasena = contrasena; this.pedido = null;
        this.promociones = false;
        this.direccion = "Calle Falsa, 123";
    }

    /**
     * Crea un nuevo pedido
     */
    public void crearPedido(){
        this.pedido = new Pedido();
    }

    /**
     * Añadeproductos al mapa y actualiza el totak
     * @param producto El producto de ka lista que hay q insertar
     */
    public void insertarProducto(Producto producto){
        int nuevaCantidad = pedido.getPedido().getOrDefault(producto,0) + 1;
        pedido.getPedido().put(producto, nuevaCantidad);
        pedido.actualizarImporteTotal(producto.getPrecio());
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public boolean isPromociones() {
        return promociones;
    }

    public void setPromociones(boolean promociones) {
        this.promociones = promociones;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "usuario='" + usuario + '\'' +
                ", contrasena='" + contrasena + '\'' +
                ", direccion='" + direccion + '\'' +
                ", pedido=" + pedido +
                ", promociones=" + promociones +
                '}';
    }
}
