package com.wu.demo;

import org.junit.Test;

import java.util.Collection;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * description:TODO
 *
 * @author simpson
 * @create 2021/02/24
 **/
public class DequeScen {
    @Test
    public void test() {
        Deque<Integer> deque = new LinkedList<>();
        deque.offer(5);
        deque.offer(6);
        deque.offer(1);
        int size = deque.size();
        for (int i = 0; i < size; i++) {
            System.out.println(deque.poll());
        }
    }
}
