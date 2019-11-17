package com.marlo.java.priotityQueue;

import java.util.*;

public class Priorities {

    public List<Student> getStudents(List<String> events) {
        Queue<Student> priorityQueue =
                new PriorityQueue<Student>(
                        (s1, s2) -> s1.getCGPA() == s2.getCGPA()
                                ? (s1.getName().equals(s2.getName())
                                    ? s1.getID() - s2.getID() : s1.getName().compareTo(s2.getName()))
                                : (s1.getCGPA() > s2.getCGPA() ? -1 : 1));
        for (String line : events) {
            if ("SERVED".equals(line)) {
                priorityQueue.poll();
            } else {
                String[] e = line.split(" ");
                priorityQueue.add(new Student(Integer.parseInt(e[3]), e[1], Double.parseDouble(e[2])));
            }
        }
        List<Student> result = new ArrayList();
        while (priorityQueue.size() > 0) result.add(priorityQueue.remove());
        return result;
    }

}
