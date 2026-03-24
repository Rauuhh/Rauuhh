package org.example.PracticaMercadam;

import java.util.*;

public class Mercadam {

    private Set<Cliente> clientes;

    public Mercadam() {
        this.clientes = new HashSet<>();
        generarClientes();
    }

    public void generarClientes() {

        String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        Random aleatorio = new Random();

        for (int r = aleatorio.nextInt(6); r > 0 ; r--) {


            String usuario = "";
            String contra = "";

            for (int i = 0; i < 8; i++) {
                int pos = aleatorio.nextInt(caracteres.length());
                usuario = usuario + caracteres.charAt(pos);
            }

            for (int i = 0; i < 8; i++) {
                int pos = aleatorio.nextInt(caracteres.length());
                contra = contra + caracteres.charAt(pos);
            }

            this.clientes.add(new Cliente(usuario, contra)) ;
        }
    }

    public Set<Cliente> getClientes() {
        System.out.println(clientes.size()  + " clientes generados:");
        System.out.print(clientes);
        return  Collections.unmodifiableSet(clientes);
    }
}
