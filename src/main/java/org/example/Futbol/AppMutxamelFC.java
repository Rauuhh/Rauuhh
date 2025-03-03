package org.example.Futbol;

import java.util.ArrayList;

public class AppMutxamelFC {
//Raúl Garcia Delgado
    public static void main(String[] args) {

        //Creación de jugadores
        Jugador[] jugadores = {
                new Jugador("Messi", 30, Equipos.SENIOR, 10, Posiciones.DELANTERO),
                new Jugador("Xavi", 30, Equipos.SENIOR, 8, Posiciones.CENTRO),
                new Jugador("Puyol", 30, Equipos.SENIOR, 2, Posiciones.DEFENSA),
                new Jugador("Ter Stegen", 30, Equipos.SENIOR, 1, Posiciones.PORTERO),
        };


        ArrayList<MutxamelFC> gente = new ArrayList<>();
        gente.add(new Acompanyante("Antonela", 45, jugadores[0], "Novia"));
        gente.add(new Acompanyante("Thiago", 67, jugadores[0], "Hijo"));
        gente.add(new Entrenador("Luis Enrique", 40, Equipos.SENIOR, "4-3-3"));
        gente.add(new  Masajista("Laura", 45, "operador de masaje", 15));
        gente.add(new  Masajista("Paula", 23, "operador de masaje", 2));


        for (Jugador jugador : jugadores) {
            jugador.concentrarse();
        }
        System.out.println("----------------------------------");
        for (MutxamelFC mutxamel : gente) {
            mutxamel.concentrarse();
        }
        System.out.println("----------------------------------");
        //Entrenar
        for (Jugador juguador : jugadores) {
            juguador.entrenar();
        }
        System.out.println("----------------------------------");
        for (MutxamelFC mutxamel : gente) {
            if (mutxamel instanceof AccionesDeportivas) {
                ((AccionesDeportivas) mutxamel).entrenar();
            }
        }
        System.out.println("----------------------------------");
        //Dar masajes
        for (MutxamelFC mutxamel : gente) {
            if (mutxamel instanceof Masajista) {
                ((Masajista) mutxamel).darMasaje(jugadores[0]);
            }
        }
        System.out.println("----------------------------------");
        //Viajar
        for (Jugador jugador : jugadores) {
            jugador.viajar("Barcelona");
        }
        System.out.println("----------------------------------");
        for (MutxamelFC mutxamel : gente) {
            mutxamel.viajar("Barcelona");
        }
        System.out.println("----------------------------------");
        //Planificar entrenamiento
        for (MutxamelFC mutxamel : gente) {
            if (mutxamel instanceof Entrenador) {
                ((Entrenador) mutxamel).planificarEntrenamiento();
            }
        }
        System.out.println("----------------------------------");
        //Entrenar
        for (Jugador jugador : jugadores) {
            jugador.entrenar();
        }
        System.out.println("----------------------------------");
        for (MutxamelFC mutxamel : gente) {
            if (mutxamel instanceof AccionesDeportivas) {
                ((AccionesDeportivas) mutxamel).entrenar();
            }
        }
        System.out.println("----------------------------------");
        //calientan y descansan
        for (Jugador jugador : jugadores) {
            jugador.calentar();
            jugador.descansar();
        }
        System.out.println("----------------------------------");
        //Jugegan
        for (Jugador jugador : jugadores) {
            jugador.jugarPartido("MutxamelFC");
        }
        System.out.println("----------------------------------");
        for (MutxamelFC mutxamel : gente) {
            if (mutxamel instanceof AccionesDeportivas) {
                ((AccionesDeportivas) mutxamel).jugarPartido("MutxamelFC");
            }
        }
        System.out.println("----------------------------------");
        //Animar mutxamel
        for (MutxamelFC mutxamel : gente) {
            if (mutxamel instanceof Acompanyante) {
                ((Acompanyante) mutxamel).animarEquipo();
            }
        }
        System.out.println("----------------------------------");
        //Cambios
        for (MutxamelFC mutxamel : gente) {
            if (mutxamel instanceof Entrenador) {
                ((Entrenador) mutxamel).hacerCambios();
            }
        }
        System.out.println("----------------------------------");
        //Gol
        for (Jugador jugador : jugadores) {
            jugador.marcarGol();
        }
        System.out.println("----------------------------------");
        //Celebrar
        for (Jugador jugador : jugadores) {
            jugador.celebrarGol();
        }
        System.out.println("----------------------------------");
        for (MutxamelFC mutxamel : gente) {
            mutxamel.celebrarGol();
        }
        System.out.println("----------------------------------");
        //Dar masaje
        for (MutxamelFC mutxamel : gente) {
            if (mutxamel instanceof Masajista) {
                for (int i = 0; i < jugadores.length; i++) {
                    ((Masajista) mutxamel).darMasaje(jugadores[i]);
                }
            }
        }
        System.out.println("----------------------------------");
        //Viajar a Mutxamel
        for (Jugador jugador : jugadores) {
            jugador.viajar("Mutxamel");
        }
        System.out.println("----------------------------------");
        for (MutxamelFC mutxamel : gente) {
            mutxamel.viajar("Mutxamel");
        }
        System.out.println("----------------------------------");
        //Descansar
        for (Jugador jugador : jugadores) {
            jugador.descansar();
        }










    }

}
