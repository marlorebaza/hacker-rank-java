package com.marlo.java;

import java.math.BigInteger;

public class CheckPrime {

    public static void main(String[] args) {
        Prime prime = new Prime();
        prime.checkPrime(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23);
        prime.checkPrime(4);

    }


}

class Prime {
    public void checkPrime(int... numbers) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int number : numbers) {
            if (BigInteger.valueOf(number).isProbablePrime(1)) {
                stringBuilder.append(" " + number);
            }
        }
        System.out.println(stringBuilder.length() == 0 ? "" : stringBuilder.toString().substring(1));
        /*
        System.out.println(Arrays.stream(n)
                .filter(x -> x > 1 && !IntStream.range(2, x).anyMatch(y -> x % y == 0))
                .mapToObj(String::valueOf)
                .collect( Collectors.joining(" ")));
                */
    }

}
