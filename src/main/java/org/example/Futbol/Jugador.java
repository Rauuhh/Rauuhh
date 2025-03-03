package org.example.Futbol;

import java.util.ArrayList;

public class Jugador extends MutxamelFC implements AccionesDeportivas{
    private static ArrayList<Jugador> listaJugadores = new ArrayList<>();
    private Equipos categoria;
    private int dorsal;
    private Posiciones posicion;

    public Jugador(String nombre, int edad, Equipos categoria, int dorsal, Posiciones posicion) {
        super(nombre, edad);
        this.categoria=categoria;
        this.dorsal=comprobarDorsal(dorsal);
        this.posicion=posicion;
        listaJugadores.add(this);
    }

    public int getDorsal() {
        return dorsal;
    }

    public int setDorsal(int dorsal) {
        return comprobarDorsal(dorsal);
    }
    //Metodo que nos dice si el dorsal ya existe

    private int comprobarDorsal(int dorsal) {
        for (Jugador jugador : listaJugadores) {
            if (jugador.getDorsal() == dorsal) {
                throw new Dorsal("No pueden haber dos personas con el mismo numero");
            }
        }
        return dorsal;
    }


//Jugador calienta
    public void calentar() {
        System.out.println(getNombre() + " está empezando a calentar.");
    }
//jugador descansa
    public void descansar() {
        System.out.println(getNombre() + " está empezando a descansar.");
    }
//jugador marca
    public void marcarGol() {
        System.out.println("A MAMAR OSTIA");
    }

    @Override
    public void entrenar() {
        System.out.println(getNombre() + " está empezando a entrenar.");
    }

    @Override
    public void jugarPartido(String rival) {
        System.out.println(getNombre() + " está jugando el partido contra " + rival);
    }

    @Override
    public void concentrarse() {
        System.out.println(getNombre() + " comienza a concentrarse en el partido...");
    }

    @Override
    public void viajar(String ciudad) {
        System.out.println(getNombre() + " se va a viajar a " + ciudad);
    }

    @Override
    public void celebrarGol() {
        System.out.println("QUE BUENO ERES OSTIAAAAA");
    }


    @Override
    public String toString() {
        return "Jugador(" + getNombre() + " de edad=" +
                getEdad() + ", categoría=" + categoria.name() + ", dorsal=" + dorsal + ", posición=" + posicion.name() + ")";
    }
}
