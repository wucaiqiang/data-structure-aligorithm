package com.wu.demo;

import org.junit.Test;

import java.util.Stack;

/**
 * description:TODO
 *
 * @author simpson
 * @create 2021/02/22
 **/
public class StringScen {
    @Test
    public void test() {
        /*String str = "abc";
        char[] arr = str.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
        char temp = 'a';
        temp++;
        temp++;
        System.out.println(temp);*/
        int[] count = new int[26];
        String A = "abc";
        System.out.println(A.charAt(0));
        System.out.println(A.charAt(2) - 'a');
        count[2]++;
        System.out.println(count);
        Character.isLetter('c');
    }

    /**
     * 仅仅反转字母
     * https://leetcode-cn.com/problems/reverse-only-letters/solution/jin-jin-fan-zhuan-zi-mu-by-leetcode/
     *
     * @param S
     * @return
     */
    public String reverseOnlyLetters(String S) {
        Stack<Character> letters = new Stack();
        for (char c : S.toCharArray())
            if (Character.isLetter(c))
                letters.push(c);

        StringBuilder ans = new StringBuilder();
        for (char c : S.toCharArray()) {
            if (Character.isLetter(c))
                ans.append(letters.pop());
            else
                ans.append(c);
        }

        return ans.toString();
    }

    /**
     * 重复的子字符串
     * https://leetcode-cn.com/problems/repeated-substring-pattern/solution/zhong-fu-de-zi-zi-fu-chuan-by-leetcode-solution/
     *
     * @param s
     * @return
     */
    public boolean repeatedSubstringPattern(String s) {
        int n = s.length();
        for (int i = 1; i * 2 <= n; ++i) {
            if (n % i == 0) {
                boolean match = true;
                for (int j = i; j < n; ++j) {
                    if (s.charAt(j) != s.charAt(j - i)) {
                        match = false;
                        break;
                    }
                }
                if (match) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        StringScen stringScen = new StringScen();
        System.out.println(stringScen.repeatedSubstringPattern("abcabcab"));
    }


}
