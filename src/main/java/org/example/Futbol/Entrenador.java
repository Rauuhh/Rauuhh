package org.example.Futbol;

public class Entrenador extends MutxamelFC implements AccionesDeportivas{

    private Equipos equipo;
    private String formacionPreferida;
    public Entrenador(String nombre, int edad, Equipos equipo, String formacionPreferida) {
        super(nombre,edad);
        this.equipo=equipo;
        this.formacionPreferida=formatoFormacion(formacionPreferida);
    }

    /**
     * Método para checkear si el formato introducido de la formación es correcto,
     * en caso de no serlo salta la excepción personalizada
     * @param formacionPreferida
     * @return
     */

    //Metodo que nos dice si nuestra formacion preferida no cumple con el formato(he puesto a 4 porque "de normal" no hay mas de 4 jugadores en la misma linea)
    private String formatoFormacion(String formacionPreferida) {
        if (formacionPreferida.matches("[0-4]-[0-4]-[0-4]")) {
            return formacionPreferida;
        } else {
            throw new Formacion("No puede introducir una formación con otro formato que no sea N-N-N");
        }
    }
//Entrenador planifica
    public void planificarEntrenamiento() {
        System.out.println(getNombre() + " está planificando el entrenamiento...");
    }
//Entrenador cambia jugadores
    public void hacerCambios() {
        System.out.println(getNombre() + " está haciendo cambios en el equipo...");
    }

    @Override
    public void entrenar() {
        System.out.println(getNombre() + " está entrenando a los jugadores");
    }

    @Override
    public void jugarPartido(String rival) {
        System.out.println(getNombre() + " está jugando el partido contra " + rival);
    }

    @Override
    public void concentrarse() {
        System.out.println(getNombre() + " se está concentrando");
    }

    @Override
    public void viajar(String ciudad) {
        System.out.println(getNombre() + " se va de viaje a " + ciudad);
    }

    @Override
    public void celebrarGol() {
        System.out.println("QUE BUENO MI EQUIPO CHE");
    }

    @Override
    public String toString() {
        return "Entrenador(" + getNombre() + " de edad=" + getEdad() + ", equipo=" + equipo.name() + ", formación preferida=" + formacionPreferida + ")";
    }
}
