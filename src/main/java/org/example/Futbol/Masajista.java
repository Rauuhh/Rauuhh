package org.example.Futbol;

import java.util.ArrayList;

public class Masajista extends MutxamelFC{

    private String titulacion;
    private int anosExperiencia;
    static ArrayList<Masajista> listaMasajistas = new ArrayList<>();

    public Masajista(String nombre, int edad, String titulacion, int anosExperiencia) {
        super(nombre, edad);
        this.titulacion=titulacion;
        this.anosExperiencia=anosExperiencia;
        listaMasajistas.add(this);
    }

    //Masajista da masaje
    public void darMasaje(Jugador jugador) {
        System.out.println(getNombre() + " le está dando un masaje tranquilizante a " + jugador.getNombre());
    }

    @Override
    public void concentrarse() {
        System.out.println(getNombre() + " está empezando a concentrarse...");
    }

    @Override
    public void viajar(String ciudad) {
        System.out.println(getNombre() + " se va de viaje a " + ciudad);
    }

    @Override
    public void celebrarGol() {
        System.out.println("QUE GOLAZO DIOS MIO");
    }


    @Override
    public String toString() {
        return "Masajista(" + getNombre() + " de edad=" + getEdad() + ", titulación=" + titulacion + ", años de experiencia=" + anosExperiencia + ")";
    }
}
