package com.marlo.java;

import java.util.Scanner;

public class DataTypes {

    /**
     * Fuente: https://www.hackerrank.com/challenges/java-datatypes/problem
     */

    public static void main(String []argh) {
        /**
         * DATO CURIOSO:
         * - Sucede lo siquiente:
         */
        System.out.println(((long) (Math.pow(2, 63)-1))); // 9223372036854775807
        System.out.println(((long)(Math.pow(2, 63)) -1)); // 9223372036854775806
        /**
         * ...por la primera anterior se esperaría que hubiese devuelo un FALSE, pero NO!.
         * Es como si el "-1" no tuviese efecto sobre el resultado devuelto por el Math.pow(...)
         */
        System.out.println(9223372036854775807L <= (Math.pow(2, 63)-1)); // TRUE, wtf?!
        /**
         * - The hacker rank espera que el número 9223372036854775807, se considere como "long".
         * Es por esto que la condicional debe ser: x<=(Math.pow(2, 31)-1)
         * Y yo estaba ingresando la condicional: x<Math.pow(2, 31), lo que ocasionaba que no se cumpliese,
         * ya que 9223372036854775807 NO ES MEJOR que si mismo
         * ...Imagino que algo parecido habrá pasado con la condicional del int, ya que la había hecho con la misma
         * lógica
         */

        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();

        for(int i=0;i<t;i++)
        {
            try
            {
                long x=sc.nextLong();
                System.out.println(x+" can be fitted in:");
                if(x>=-128 && x<=127)System.out.println("* byte");
                if(x>=-32768 && x<=32767)System.out.println("* short");
                if(x>=Math.pow(-2, 31) && x<=(Math.pow(2, 31)-1))System.out.println("* int");
                if(x>=Math.pow(-2, 63) && x<=(Math.pow(2, 63)-1))System.out.println("* long");
            }
            catch(Exception e)
            {
                System.out.println(sc.next()+" can't be fitted anywhere.");
            }

        }
    }

}
