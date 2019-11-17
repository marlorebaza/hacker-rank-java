package com.marlo.java;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class JavaList {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int listSize = scan.nextInt();
        List<Integer> list = new ArrayList();
        while (listSize-- > 0) {
            list.add(scan.nextInt());
        }
        int queriesQuantity = scan.nextInt();
        while (queriesQuantity-- > 0) {
            scan.nextLine();
            String query = scan.nextLine();
            if ("Insert".equals(query)) {
                int position = scan.nextInt();
                int value = scan.nextInt();
                list.add(position, value);
            } else if ("Delete".equals(query)) {
                int position = scan.nextInt();
                list.remove(position);
            }
        }
        System.out.println(list.stream().map(n -> n.toString()).collect(Collectors.joining(" ")));
        scan.close();
    }
}
