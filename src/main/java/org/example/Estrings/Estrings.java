package org.example.Estrings;

public class Estrings {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("Hola ");
        sb.append("que tal");
        sb.insert(5,"soy Raul "); //Hola soy Raul
        sb.replace(5,8,"somos");
        sb.delete(0,5);

        System.out.println(sb.toString());
        System.out.println(sb);
        sb.reverse();
        System.out.println(sb);
    }
}
