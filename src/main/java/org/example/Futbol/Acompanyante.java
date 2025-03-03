package org.example.Futbol;

public class Acompanyante extends MutxamelFC{
    private Jugador integrante;
    private String parentesco;

    public Acompanyante(String nombre, int edad, Jugador integrante, String parentesco) {
        super(nombre, edad);
        this.integrante=integrante;
        this.parentesco=parentesco;
    }

    //Acompañante anima
    public void animarEquipo() {
        System.out.println("El acompañante " + getNombre() + " VAMOS OSTIA VAMOOOOOO");
    }

    //Acompañante se concentra
    @Override
    public void concentrarse() {
        System.out.println(getNombre() + " esta concentrándose en el partido");
    }

    //Acompañante viaja
    @Override
    public void viajar(String ciudad) {
        System.out.println("Viajando a la ciudad: " + ciudad);
    }

    //Acompañante celebra gol
    @Override
    public void celebrarGol() {
        System.out.println("GOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOL");
    }

    @Override
    public String toString() {
        return "Acompañante(" + getNombre() + " de edad=" + getEdad() + ", integrante=" + integrante + ", parentesco=" + parentesco + ")";
    }
}
