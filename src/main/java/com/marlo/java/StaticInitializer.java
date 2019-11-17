package com.marlo.java;

import java.util.Scanner;

public class StaticInitializer {

    /**
     * FUENTE: https://www.hackerrank.com/challenges/java-static-initializer-block
     */

    private static int B;
    private static int H;

     static final Scanner scanner = new Scanner(System.in);

    private static boolean flag;

    // Este es un bloque de inicialización, llamado después del constructor, al instanciar la clase
    {

    }

    // Este es un bloque de inicialziación estática.. será llamada al momento de cargar la clase.
    // No tiene acceso a las variables y métodos de instancia
    static {
        H = scanner.nextInt();
        B = scanner.nextInt();
        if (B > 0 && H > 0) {
            flag = true;
        } else {
            flag = false;
            System.out.print("java.lang.Exception: Breadth and height must be positive");
        }
    }

    public static void main(String[] args) {
        if (flag) {
            int area = B * H;
            System.out.print(area);
        }

    }//end of main

}
