package com.wu.demo;

import org.junit.Test;

import java.util.Stack;

/**
 * description:TODO
 *
 * @author simpson
 * @create 2021/02/24
 **/
public class StackScen {
    @Test
    public void test() {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        int size = stack.size();
        /*for (int i = 0; i < size; i++) {
            System.out.println(stack.pop());
        }*/
        System.out.println(stack.peek());
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        if (chars.length == 0) {
            return false;
        }
        for (char c : chars) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else if (c == ')' || c == ']' || c == '}') {
                if (stack.empty()) {
                    return false;
                }
                char c1 = stack.peek();
                if (c == ')' && c1 != '(') {
                    return false;
                } else if (c == ']' && c1 != '[') {
                    return false;
                } else if (c == '}' && c1 != '{') {
                    return false;
                }
                stack.pop();
            }
        }
        if (stack.isEmpty()) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        StackScen stackScen = new StackScen();
        System.out.println(stackScen.isValid("(]"));
    }
}
