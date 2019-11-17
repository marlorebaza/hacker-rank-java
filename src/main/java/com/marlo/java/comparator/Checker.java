package com.marlo.java.comparator;

import java.util.Comparator;

public class Checker implements Comparator<Player> {

    // resultado negativo SIEMPRE manda primero a o1
    @Override
    public int compare(Player o1, Player o2) {
        // negativo: o1 es menor
        // 0: iguales
        // positivo: o2 es mayor
        return o1.score == o2.score ? o1.name.compareTo(o2.name) : o2.score - o1.score;
    }
}
