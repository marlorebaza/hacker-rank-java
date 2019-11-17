package com.marlo.java;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class MySort {

    public static void main(String[] args) {
        List<Integer> a = Arrays.asList(19, 5, 4, 1, 5, 15);
        // mayor a menor: resultado negativo SIEMPRE manda primero a n1
        a.sort((n1, n2) -> n2 - n1);
        a.forEach(System.out::println);
        System.out.println("---------------------");
        // menor a mayor: resultado negativo SIEMPRE manda primero a n1
        a.sort((n1, n2) -> n1 - n2);
        a.forEach(System.out::println);
        System.out.println("---------------------");
        int[] n = new int[]{19, 5, 4, 1, 5, 15};
        for (int i = 0; i < n.length; i++) {
            for (int j = (i+1); j < n.length; j++  ) {
                if (n[j] < n[i]) {
                    int t = n[i];
                    n[i] = n[j];
                    n[j] = t;
                }
            }
        }
        Arrays.stream(n).forEach(System.out::println);
    }
}
