package org.example.Diccionario;

import java.util.*;

public class Diccionario {

    static Random random = new Random();
    private Map<String,String> diccionario;

    public Diccionario(){
        diccionario = new HashMap<>();
    }

    public void nuevoPar(String espana, String ingles){
        diccionario.put(espana,ingles);
    }

    public String traducir(String palabra){
        return diccionario.get(palabra);
    }

    public String palabraAleatoria(){
        ArrayList<String> vector_diccionario = new ArrayList<>(diccionario.keySet());
        int num = random.nextInt(vector_diccionario.size());
        return vector_diccionario.get(num);
    }

    public char primeraLetraTraduccion(String palabra){
        return diccionario.get(palabra).charAt(0);
    }

}