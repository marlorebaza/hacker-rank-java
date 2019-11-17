package com.marlo.java;

import java.util.*;
import java.util.concurrent.LinkedBlockingDeque;

public class MyDeque {

    public static class MutableInt {
        private int value = 1;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Deque<Integer> deque = new ArrayDeque();
        int n = in.nextInt();
        int m = in.nextInt();
        Map<Integer, MutableInt> numbers = new HashMap();
        Long result = 0L;
        for (int i = 0; i < n; i++) {
            int number = in.nextInt();
            deque.addLast(number);
            MutableInt mutableInt = numbers.get(number);
            if (mutableInt != null) {
                mutableInt.value++;
            } else {
                numbers.put(number, new MutableInt());
            }
            if (deque.size() == m) {
                if ((result = numbers.size() > result ? numbers.size() : result) == m) {
                    break;
                }
                int firstNumber = deque.removeFirst();
                for (Iterator<Map.Entry<Integer, MutableInt>> iterator = numbers.entrySet().iterator(); iterator.hasNext();) {
                    Map.Entry<Integer, MutableInt> entry = iterator.next();
                    if (firstNumber == entry.getKey())  {
                        if (entry.getValue().value == 1) {
                            iterator.remove();
                            break;
                        } else {
                            entry.getValue().value--;
                        }
                    }
                }
                /*
                mutableInt = numbers.get(deque.removeFirst());
                if (mutableInt.value == 1) {
                    numbers.remove(number);
                } else {
                    mutableInt.value--;
                }
                */
            }
        }
        System.out.println(result);
    }

    /*
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Deque<Integer> deque = new ArrayDeque();
        int totalLength = in.nextInt();
        int groupLength = in.nextInt();
        Long result = 0L;
        for (int i = 0; i < totalLength; i++) {
            deque.addLast(in.nextInt());
            if (deque.size() == groupLength) {
                Long count = deque.stream().distinct().count();
                if ((result = count > result ? count : result) == groupLength) {
                    break;
                }
                deque.removeFirst();
            }
        }
        System.out.println(result);
    }
    */

    // SOLO ALMACENAR LOS QUE SE REPITEN...
    /*
    public static void main(String[] args) {
        //practice();
        Scanner in = new Scanner(System.in);
        Deque<Integer> deque = new ArrayDeque();
        int totalLength = in.nextInt();
        int groupLength = in.nextInt();
        int counter = 0;
        int result = 0;
        for (int i = 0; i < totalLength; i++) {
            int inputNumber = in.nextInt();
            boolean existsInputNumber = false;
            int countFirstNumber = 0;
            boolean canRemoveFirstNumber = i >= (groupLength - i);
            if (deque.size() > 0) {
                Iterator<Integer> iterator = deque.iterator();
                iterator.next();
                while (iterator.hasNext()) {
                    int currentNumber = iterator.next();
                    if (!existsInputNumber
                            && (existsInputNumber = currentNumber == inputNumber)
                            && !canRemoveFirstNumber) {
                        break;
                    }
                    if (canRemoveFirstNumber && currentNumber == deque.peekFirst()) {
                        countFirstNumber++;
                    }
                }
            }
            if (deque.size() == 0 || (!existsInputNumber && inputNumber != deque.peekFirst())) {
                counter++;
            }
            if (canRemoveFirstNumber) {
                if ((result = counter > result ? counter : result) == groupLength) {
                    break;
                }
                if (deque.removeFirst() != inputNumber && countFirstNumber == 1) {
                    counter--;
                }
            }
            deque.addLast(inputNumber);
        }
        System.out.println(result);
    }
    */

    private static void practice() {
        // deque (double ended queue)
        Deque<Integer> deque1= new ArrayDeque();
        deque1.addFirst(1);
        deque1.addFirst(2);
        deque1.addFirst(3);
        deque1.addLast(6);
        deque1.addLast(5);
        deque1.addLast(4);
        deque1.forEach(System.out::println);
        System.out.println("-------------");
        System.out.println(deque1.peekFirst());
        System.out.println(deque1.peekLast());
        System.out.println("-------------");

        // Cola con reestricción de expansión (tamaño máximo de 10)
        Deque<Integer> deque2 = new LinkedBlockingDeque<>(10);
        deque2.add(1);
        deque2.add(2);
        deque2.add(3);
        deque2.add(4);
        deque2.add(5);
        deque2.add(6);
        deque2.add(7);
        deque2.add(8);
        deque2.add(9);
        deque2.add(10);
        // cuando se maneja una cola con restricción de tamaño es preferible hacer uso del método
        // offerFirst(), ya que devolverá un boolean que indica si se hizo la inserción o no.
        // En cambio el métoddo addFirst() arrojará la excepción IllegalStateException en caso
        // se excede el límite del tamaño
        System.out.println(deque2.offerFirst(0));
        deque2.addFirst(0);
    }

}
