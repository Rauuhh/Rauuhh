package org.example.Futbol;

public abstract class MutxamelFC implements FuncionesIntegrantes{

    private String nombre;
    private int edad;
    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public MutxamelFC(String nombre, int edad) {
        this.nombre=nombre;
        this.edad=edad;
    }

    @Override
    public String toString() {
        return "MutxamelFC{" + "nombre='" + nombre + '\'' + ", edad=" + edad + '}';
    }

}
