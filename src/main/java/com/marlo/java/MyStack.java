package com.marlo.java;

import java.util.*;

public class MyStack {

    public static void main(String[] args)
    {

        Scanner sc = new Scanner(System.in);

        /*
            Solución interesante de un desarrollador
        while (sc.hasNext()) {
            String input = sc.next();
            while (input.length() != (input = input.replaceAll("\\(\\)|\\[\\]|\\{\\}", "")).length()) ;
            System.out.println(input.isEmpty());
        }
        */

        List<int[]> parenthesis = Arrays.asList(new int[][]{{'[', ']'}, {'{', '}'}, {'(', ')'}});

        while (sc.hasNext()) {
            String input = sc.next();
            Stack<Integer> stack = new Stack();
            boolean result = input.chars().allMatch(c -> {
                if (parenthesis.stream().anyMatch(p -> p[0] == c)) {
                    return stack.push(c) == c;
                } else if (!stack.isEmpty() && parenthesis.stream().filter(p -> p[1] == c).findFirst().orElse(new int[2])[0] == stack.pop()) {
                    return true;
                } else {
                    return false;
                }
            }) && stack.isEmpty();
            System.out.println(result);
        }

    }

}
