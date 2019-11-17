package com.marlo.java.javaLambda1;

import java.util.stream.IntStream;

public class MyMath {

    public static boolean checker(PerformOperation p, int num) {
        return p.check(num);
    }

    public PerformOperation isOdd() {
        return n -> n % 2 != 0;
    }

    public PerformOperation isPrime() {
        return n -> IntStream.range(2, n).allMatch(i -> n % i != 0);
    }

    public PerformOperation isPalindrome() {
        return n -> n == Integer.parseInt(
                Integer.toString(n)
                        .chars()
                        .mapToObj(x -> String.valueOf((char) x))
                        .reduce((l, r) -> r + l)
                        .get());
    }


}
