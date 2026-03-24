package org.example.StringBuolder;

public class Prueba {
    public static void main(String[] args) {

        StringBuilder sb = new StringBuilder();
        sb.append("Calleu ");
        sb.append("Mantecao ").append(" JOAQUIN!!").append("adios");

        sb.insert(16,"de limon");
        sb.replace(26,35, "JACOBO");
        sb.delete(26,32);
        System.out.println(sb);
        sb.reverse();
        System.out.println(sb);
    }
}
