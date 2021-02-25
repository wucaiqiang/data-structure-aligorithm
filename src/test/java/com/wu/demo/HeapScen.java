package com.wu.demo;

import org.junit.Test;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * description:TODO
 *
 * @author simpson
 * @create 2021/02/24
 **/
public class HeapScen {
    @Test
    public void test() {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        priorityQueue.offer(5);
        priorityQueue.offer(6);
        priorityQueue.offer(9);
        priorityQueue.offer(1);
        int size = priorityQueue.size();
        for (int i = 0; i < size; i++) {
            System.out.println(priorityQueue.peek());
            System.out.println(priorityQueue.poll());
        }
    }
}
