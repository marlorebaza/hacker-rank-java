package com.marlo.java;

import java.util.Scanner;

public class Eof {

    public static void main(String []argh){
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */

        Scanner in = new Scanner(System.in);
        for (int i = 1; in.hasNextLine(); i++) {
            String line = in.nextLine();
            if (line.isEmpty()) {
                break;
            }
            System.out.println(String.format("%d %s", i, line));
        }
    }

}
