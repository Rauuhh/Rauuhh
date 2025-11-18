package org.example;

public class prub {
    public static void main(String[] args) {
        recursivo(3);
    }

    public static void recursivo(int n) {
        System.out.println(n);
        if (n > 0) {
            recursivo(n - 1);
        }
        System.out.println(n);
    }
}
