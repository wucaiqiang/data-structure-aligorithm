package com.wu.demo;

import org.junit.Test;

import java.util.*;

/**
 * description:TODO
 *
 * @author simpson
 * @create 2021/02/23
 **/
public class HashScen {
    @Test
    public void test() {
        String str = "bca";
        char[] strArr = str.toCharArray();
        Arrays.sort(strArr);
        Map<String, String> map = new HashMap<>();
        map.put(new String(strArr), "1");
        System.out.println(map.containsKey("bac"));
    }

    /**
     * 变位词组
     * https://leetcode-cn.com/problems/group-anagrams-lcci/solution/9623-6606-by-bobby996-n1fz/
     *
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> hashMap = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            if (hashMap.containsKey(key)) {
                List<String> list = hashMap.get(key);
                list.add(str);
            } else {
                List<String> list = new ArrayList<>();
                list.add(str);
                hashMap.put(key, list);
            }
        }
        List<List<String>> bigList = new ArrayList<>();
        for (Map.Entry<String, List<String>> stringListEntry : hashMap.entrySet()) {
            List<String> value = stringListEntry.getValue();
            bigList.add(value);
        }
        return bigList;
    }

}
