package com.wu.demo;

import org.junit.Test;

import java.util.Random;

/**
 * description:TODO
 *
 * @author simpson
 * @create 2021/02/05
 * 参考文档地址：https://leetcode-cn.com/problems/sort-an-array/solution/fu-xi-ji-chu-pai-xu-suan-fa-java-by-liweiwei1419/
 **/
public class ArraySortSolution {
    private static final Random RANDOM = new Random();

    /**
     * 冒泡排序
     */
    @Test
    public void bubbleSort() {
        int[] nums = {1, 3, 5, 9, 2, 6, 4, 8, 7, 0};
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
        for (int item : nums) {
            System.out.print(item + ",");
        }
    }

    /**
     * 选择排序
     */
    @Test
    public void selectSort() {
        int[] nums = {1, 3, 5, 9, 2, 6, 4, 8, 7, 0};
        for (int i = 0; i < nums.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = nums[i];
            nums[i] = nums[minIndex];
            nums[minIndex] = temp;
        }
        for (int item : nums) {
            System.out.print(item + ",");
        }
    }

    /**
     * 插入排序
     */
    @Test
    public void insertSort() {
        int[] nums = {1, 3, 2, 9, 5, 6, 4, 8, 7, 0};
        for (int i = 0; i < nums.length; i++) {
            int temp = nums[i];
            int index = i;
            while (index > 0 && temp < nums[index - 1]) {
                nums[index] = nums[index - 1];
                index--;
            }
            nums[index] = temp;
        }
        for (int item : nums) {
            System.out.print(item + ",");
        }
    }

    /**
     * 归并排序
     */
    @Test
    public void mergeSort() {
//        int[] nums = {1, 5, 6, 8, 9, 0, 2, 3, 4, 7};
        int[] nums = {1, 3, 2, 9, 5, 6, 4, 8, 7, 0, 11, 19, 13, 16, 15, 14, 12, 17, 18};
        int[] temp = new int[nums.length];
        sortItem(nums, 0, nums.length - 1, temp);
        for (int item : nums) {
            System.out.print(item + ",");
        }

    }

    /**
     * 快速插入排序
     */
    @Test
    public void quickSort() {
//        int[] nums = {1, 5, 6, 8, 9, 0, 2, 3, 4, 7};
        int[] nums = {1, 3, 2, 9, 5, 6, 4, 8, 7, 0, 11, 19, 13, 16, 15, 14, 12, 17, 18};
        quickSortItem(nums, 0, nums.length - 1);
        for (int item : nums) {
            System.out.print(item + ",");
        }

    }

    /**
     * 堆排序
     */
    @Test
    public void heapSort() {
//        int[] nums = {1, 5, 6, 8, 0, 2, 3, 4, 7};
        int[] nums = {1, 3, 2, 9, 5, 6, 4, 8, 7, 0, 11, 19, 13, 16, 15, 14, 12, 17, 18, 20};
        for (int i = (nums.length - 1) / 2; i >= 0; i--) {
            siftDown(nums, i, nums.length - 1);
        }
        for (int i = nums.length - 1; i >= 1; i--) {
            swap(nums, 0, i);
            siftDown(nums, 0, i - 1);
        }
        for (int item : nums) {
            System.out.print(item + ",");
        }
    }

    public void siftDown(int[] nums, int index, int end) {
        while (2 * index + 1 <= end) {
            int k = 2 * index + 1;
            if (k + 1 <= end && nums[k] < nums[k + 1]) {
                k++;
            }
            if (nums[index] < nums[k]) {
                swap(nums, index, k);
            }
            index = k;
        }
    }

    public void quickSortItem(int[] nums, int left, int right) {
        if (right - left <= 7) {
            this.insertSort(nums, left, right);
            return;
        }
        int pIndex = partition(nums, left, right);
        quickSortItem(nums, left, pIndex - 1);
        quickSortItem(nums, pIndex + 1, right);

    }

    public int partition(int[] nums, int left, int right) {
        int randomIndex = RANDOM.nextInt(right - left) + left;
        swap(nums, left, randomIndex);
        int pivot = nums[left];
        int lt = left;
        for (int i = left + 1; i <= right; i++) {
            if (nums[i] < pivot) {
                lt++;
                swap(nums, lt, i);
            }
        }
        swap(nums, left, lt);
        return lt;
    }

    public void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;

    }

    public void sortItem(int[] nums, int left, int right, int[] temp) {
        if (right - left <= 7) {
            this.insertSort(nums, left, right);
            return;
        }
        int mid = (left + ((right - left)) / 2);
        sortItem(nums, left, mid, temp);
        sortItem(nums, mid + 1, right, temp);
        if (nums[mid] < nums[mid + 1]) {
            return;
        }
        mergeItem(nums, left, mid, right, temp);
    }

    public void insertSort(int[] nums, int left, int right) {
        for (int i = left; i <= right; i++) {
            int temp = nums[i];
            int preIndex = i;
            while (preIndex > left && temp < nums[preIndex - 1]) {
                nums[preIndex] = nums[preIndex - 1];
                preIndex--;
            }
            nums[preIndex] = temp;
        }
    }

    public void mergeItem(int[] nums, int left, int mid, int right, int[] temp) {
        System.arraycopy(nums, left, temp, left, (right - left) + 1);
        int leftIndex = left;
        int rightIndex = mid + 1;
        for (int i = left; i <= right; i++) {
            if (leftIndex == mid + 1) {
                nums[i] = temp[rightIndex];
                rightIndex++;
            } else if (rightIndex == right + 1) {
                nums[i] = temp[leftIndex];
                leftIndex++;
            } else if (temp[leftIndex] <= temp[rightIndex]) {
                nums[i] = temp[leftIndex];
                leftIndex++;
            } else {
                nums[i] = temp[rightIndex];
                rightIndex++;
            }
        }
    }
}
