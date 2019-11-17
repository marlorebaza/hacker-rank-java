package com.marlo.java;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Array1D {

    private static boolean marlo(int position, int leap, int[] game, List<Integer> coveredPositions) {
        if (position >= game.length) {
            return true;
        }
        if (game[position] != 0 || coveredPositions.contains(position)) {
            return false;
        }
        coveredPositions.add(position);
        // al hacer uso de "||" a la priemra que una invocación del metodo
        // recursivo retorne "true" se interrumpirá la condicional y ya no se
        // ejecutarán las demás llamadas
        return marlo(position + leap, leap, game, coveredPositions)
                || marlo(position + 1, leap, game, coveredPositions)
                || (position > 0 && marlo(position - 1, leap, game, coveredPositions));
    }

    public static boolean canWin(int leap, int[] game) {
        return marlo(0, leap, game, new ArrayList());
    }

    public static void main(String[] args) {
        boolean a = true;
        a |= false;
        Scanner scan = new Scanner(System.in);
        int q = scan.nextInt();
        List<String> results = new ArrayList();
        while (q-- > 0) {
            int n = scan.nextInt();
            int leap = scan.nextInt();

            int[] game = new int[n];
            for (int i = 0; i < n; i++) {
                game[i] = scan.nextInt();
            }
            String result = (canWin(leap, game)) ? "YES" : "NO";
            results.add(result);
            System.out.println(result);
        }
        try {
            Files.write(Paths.get("results.txt"), results);
        } catch (IOException e) {
            e.printStackTrace();
        }
        scan.close();
    }

}
