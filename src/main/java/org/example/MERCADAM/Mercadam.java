package org.example.MERCADAM;

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
