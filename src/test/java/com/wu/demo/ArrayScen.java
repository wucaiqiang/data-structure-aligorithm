package com.wu.demo;

import org.junit.Test;

import java.util.TreeMap;

/**
 * description:TODO
 *
 * @author simpson
 * @create 2021/02/21
 **/
public class ArrayScen {
    /**
     * 合并俩个有序数组
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // Make a copy of nums1.
        int[] nums1_copy = new int[m];
        System.arraycopy(nums1, 0, nums1_copy, 0, m);

        // Two get pointers for nums1_copy and nums2.
        int p1 = 0;
        int p2 = 0;

        // Set pointer for nums1
        int p = 0;

        // Compare elements from nums1_copy and nums2
        // and add the smallest one into nums1.
        while ((p1 < m) && (p2 < n))
            nums1[p++] = (nums1_copy[p1] < nums2[p2]) ? nums1_copy[p1++] : nums2[p2++];

        // if there are still elements to add
        if (p1 < m)
            System.arraycopy(nums1_copy, p1, nums1, p1 + p2, m + n - p1 - p2);
        if (p2 < n)
            System.arraycopy(nums2, p2, nums1, p1 + p2, m + n - p1 - p2);
    }

    /**
     * 有序数组的平方
     * https://leetcode-cn.com/problems/squares-of-a-sorted-array/solution/you-xu-shu-zu-de-ping-fang-by-leetcode-solution/
     *
     * @param nums
     * @return
     */
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int negative = -1;
        for (int i = 0; i < n; ++i) {
            if (nums[i] < 0) {
                negative = i;
            } else {
                break;
            }
        }

        int[] ans = new int[n];
        int index = 0, i = negative, j = negative + 1;
        while (i >= 0 || j < n) {
            if (i < 0) {
                ans[index] = nums[j] * nums[j];
                ++j;
            } else if (j == n) {
                ans[index] = nums[i] * nums[i];
                --i;
            } else if (nums[i] * nums[i] < nums[j] * nums[j]) {
                ans[index] = nums[i] * nums[i];
                --i;
            } else {
                ans[index] = nums[j] * nums[j];
                ++j;
            }
            ++index;
        }

        return ans;
    }

    /**
     * 滑动窗口
     * https://leetcode-cn.com/problems/max-consecutive-ones-iii/solution/fen-xiang-hua-dong-chuang-kou-mo-ban-mia-f76z/
     *
     * @param A
     * @param K
     * @return
     */
    public int longestOnes(int[] A, int K) {
        int N = A.length;
        int res = 0;
        int left = 0, right = 0;
        int zeros = 0;
        while (right < N) {
            if (A[right] == 0)
                zeros++;
            while (zeros > K) {
                if (A[left++] == 0)
                    zeros--;
            }
            res = Math.max(res, right - left + 1);
            right++;
        }
        return res;
    }

    /**
     * 给你一个整数数组 nums ，和一个表示限制的整数 limit，请你返回最长连续子数组的长度，该子数组中的任意两个元素之间的绝对差必须小于或者等于 limit 。
     * <p>
     * 链接：https://leetcode-cn.com/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit
     *
     * @param nums
     * @param limit
     * @return
     */
    public int longestSubarray(int[] nums, int limit) {
        TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
        int n = nums.length;
        int left = 0, right = 0;
        int ret = 0;
        while (right < n) {
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);
            while (map.lastKey() - map.firstKey() > limit) {
                map.put(nums[left], map.get(nums[left]) - 1);
                if (map.get(nums[left]) == 0) {
                    map.remove(nums[left]);
                }
                left++;
            }
            ret = Math.max(ret, right - left + 1);
            right++;
        }
        return ret;
    }


    /**
     * 所有奇数长度子数组的和
     * https://leetcode-cn.com/problems/sum-of-all-odd-length-subarrays/solution/c-hua-dong-chuang-kou-si-lu-chao-ji-jian-0yzq/
     *
     * @return
     */
    public int sumOddLengthSubarrays(int[] arr) {
        int sum = 0;//计算总和
        int size = arr.length;//数组长度
        for (int len = 1; len <= size; len += 2) {//len滑动窗口长度
            sum += window(arr, len);//将每次放回的和累加到一起
        }
        return sum;
    }

    private int pre = 0, cur = 0;

    /**
     * 斐波那契数
     *
     * @param x
     * @return
     */
    public int fib(int x) {
        if (x <= 2) {
            return x - 1;
        }
        return recursive(x);
    }

    public int recursive(int x) {
        int idex_0 = 0, idex_1 = 1;
        if (x == 2) {
            return idex_1 + idex_0;
        }
        int result = recursive(x - 1);
        this.cur = result + this.pre;
        this.pre = result;
        return cur;
    }

    //滑动窗口代码
    int window(int[] arr, int len) {
        int i = 0;//左指针
        int j = 0;//右指针
        int sum = 0;//当前滑动窗口的和
        int ssum = 0;//返回的总和
        while (j < arr.length) {
            sum += arr[j];
            if (j - i + 1 == len) {//长度等于len长度时就计算总和，然后移动左指针并处理当前滑动窗口的和
                ssum += sum;
                sum -= arr[i];
                i++;
            }
            j++;
        }
        return ssum;
    }

    public int searchTarget(int[] nums, int target) {
        if (nums == null) {
            return -1;
        }
        int n = nums.length;
        if (n == 1) {
            if (nums[0] == target) {
                return 0;
            }
        }
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = (right - left) / 2 + left;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[left] == target) {
                return left;
            }
            if (nums[right] == target) {
                return right;
            }
            if (nums[mid] < nums[right]) {
                if (target < nums[mid] || nums[right] < target) {
                    right = mid;
                } else {
                    left = mid;
                }
            } else if (nums[left] < nums[mid]) {
                if (nums[left] < target && target < nums[right]) {
                    right = mid;
                } else {
                    left = mid;
                }
            } else {
                right = right - 1;

            }
        }
        return -1;
    }

    /**
     * 旋转有序数据，查询最小
     *
     * @param nums
     * @return
     */
    public int searchMin(int[] nums) {
        if (nums == null) {
            return -1;
        }
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        int left = 0, right = n - 1;
        while (left < right) {
            if (right - left == 1) {
                return Math.min(nums[left], nums[right]);
            }
            int mid = (right - left) / 2 + left;
            if (nums[mid] < nums[right]) {
                right = mid;
            } else if (nums[mid] > nums[right]) {
                left = mid;
            } else {
                right = right - 1;
            }
        }
        return nums[left];
    }

    public static void main(String[] args) {
        ArrayScen arrayDemo = new ArrayScen();
        /*int[] arr = {1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0};
        System.out.println(arrayDemo.longestOnes(arr, 2));*/
//        int[] arr = {1, 5, 6, 7, 8, 10, 6, 5, 6};
//        System.out.println(arrayDemo.longestSubarray(arr, 4));
//        System.out.println(arrayDemo.fib(6));
        int[] arr = {6, 7, 8, 0, 1, 2, 3};
//        int[] arr = {3, 1, 1};
        System.out.println(arrayDemo.searchTarget(arr, 6));
    }

}
