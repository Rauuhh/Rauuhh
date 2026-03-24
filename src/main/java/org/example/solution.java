package org.example;

public class solution { // Asume fichero llamado solution.java

    static java.util.Scanner in;

    public static void casoDePrueba() {

        String [][] matriz = new String[8][8];

        String lineaEntera = in.nextLine();
        int contador = -1;
        externo:
        for (int i = 0; i < matriz.length; i++) {

            for (int j = 0; j < matriz[0].length; j++) {
                contador++;
                if (lineaEntera.charAt(contador) == '/')
                {
                    i--;
                    continue externo;
                } else if (lineaEntera.charAt(contador) >= '1' && lineaEntera.charAt(contador) <= '8') {
                    j += Integer.parseInt(String.valueOf(lineaEntera.charAt(contador))) -1;
                }else{
                    matriz[i][j] = String.valueOf(lineaEntera.charAt(contador));
                }
            }
        }

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {

                if (matriz[i][j] == null){
                    matriz[i][j] = String.valueOf(0);
                }
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }

        String [][] copia = new String[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (matriz[i][j].equals("0")) {
                    copia[i][j] = "0";
                } else {
                    copia[i][j] = "X";
                }
            }
        }
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {

                switch (matriz[i][j]) {

                    case "r": case "R": // Torre
                        torre(matriz,copia,i,j);
                        break;

                    case "b": case "B": // Alfil
                        alfil(matriz,copia,i,j);

                        break;

                    case "q": case "Q": // Reina
                        reina(matriz,copia,i,j);

                        break;

                    case "n": case "N": // Caballo
                        int[] ejeX = {-2,-2,-1,-1,1,1,2,2};
                        int[] ejeY = {-1,1,-2,2,-2,2,-1,1};
                        for (int k = 0; k < 8; k++) {
                            int x = i + ejeX[k];
                            int y = j + ejeY[k];
                            if (x >= 0 && x < 8 && y >= 0 && y < 8) {
                                copia[x][y] = "X";
                            }
                        }
                        break;

                    case "k": case "K": // Rey
                        for (int altura = -1; altura <= 1; altura++) {
                            for (int anchura = -1; anchura <= 1; anchura++) {
                                int x = i + altura;
                                int y = j + anchura;
                                if (x >= 0 && x < 8 && y >= 0 && y < 8) {
                                    copia[x][y] = "X";
                                }
                            }
                        }
                        break;

                    case "p": // Peón negro
                        if (i + 1 < 8 && j - 1 >= 0){
                            copia[i + 1][j - 1] = "X";
                        }
                        if (i + 1 < 8 && j + 1 < 8){
                            copia[i + 1][j + 1] = "X";
                        }
                        break;

                    case "P": // Peón blanco
                        if (i - 1 >= 0 && j - 1 >= 0){
                            copia[i - 1][j - 1] = "X";
                        }
                        if (i - 1 >= 0 && j + 1 < 8){
                            copia[i - 1][j + 1] = "X";
                        }
                        break;
                }
            }
        }

        System.out.println("========================");
        for (int i = 0; i < copia.length; i++) {
            for (int j = 0; j < copia[0].length; j++) {
                System.out.print(copia[i][j] + " ");
            }
            System.out.println();
        }
        contador = 0;
        for (int i = 0; i < copia.length; i++) {
            for (int j = 0; j < copia[0].length; j++) {
                if (copia[i][j] == "0"){
                    contador++;
                }
            }
        }
        System.out.println();
        System.out.println(contador);



    } // casoDePrueba

    public static void main(String[] args) {
        in = new java.util.Scanner(System.in);
        int numCasos = in.nextInt();
        in.nextLine();
        for (int i = 0; i < numCasos; i++)
            casoDePrueba();
    }// main

    //Metodo Torre
    static void torre(String[][] matriz, String[][] copia, int i, int j) {
        // Arriba
        for (int arriba = i - 1; arriba >= 0; arriba--) {
            copia[arriba][j] = "X";
            if (!matriz[arriba][j].equals("0")){
                break;
            }
        }
        // Abajo
        for (int abajo = i + 1; abajo < 8; abajo++) {
            copia[abajo][j] = "X";
            if (!matriz[abajo][j].equals("0")){
                break;
            }
        }
        // Izquierda
        for (int izquiera = j - 1; izquiera >= 0; izquiera--) {
            copia[i][izquiera] = "X";
            if (!matriz[i][izquiera].equals("0")){
                break;
            }
        }
        // Derecha
        for (int derecha = j + 1; derecha < 8; derecha++) {
            copia[i][derecha] = "X";
            if (!matriz[i][derecha].equals("0")){
                break;
            }
        }
    }

    //Metodo Alfil
    static void alfil(String[][] matriz, String[][] copia, int i, int j) {
        // Arriba-izquierda
        for (int altura = i - 1, anchura = j - 1; altura >= 0 && anchura >= 0; altura--, anchura--) {
            copia[altura][anchura] = "X";
            if (!matriz[altura][anchura].equals("0")){
                break;
            }
        }
        // Arriba-derecha
        for (int altura = i - 1, anchura = j + 1; altura >= 0 && anchura < 8; altura--, anchura++) {
            copia[altura][anchura] = "X";
            if (!matriz[altura][anchura].equals("0")) {
                break;
            }
        }
        // Abajo-izquierda
        for (int altura = i + 1, anchura = j - 1; altura < 8 && anchura >= 0; altura++, anchura--) {
            copia[altura][anchura] = "X";
            if (!matriz[altura][anchura].equals("0")){
                break;
            }
        }
        // Abajo-derecha
        for (int altura = i + 1, anchura = j + 1; altura < 8 && anchura < 8; altura++, anchura++) {
            copia[altura][anchura] = "X";
            if (!matriz[altura][anchura].equals("0")){
                break;
            }
        }
    }

    //Metodo Reina
    static void reina(String[][] matriz, String[][] copia, int i, int j) {
        torre(matriz, copia, i, j);
        alfil(matriz, copia, i, j);
    }

}