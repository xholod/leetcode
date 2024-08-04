package com.github.xholod.level.easy;
import java.util.Arrays;
/*
    https://leetcode.com/problems/merge-sorted-array/description/
 */

public class Problem88 {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int resultArraySize = m + n;
        int [] resultArray = new int[resultArraySize];
        int nums2Counter = 0;
        int resultArrayCounter = 0;

        if (nums1.length != 0 && nums2.length != 0) {

            for (int i = 0; i < m; i++) {
                if (nums1[i] < nums2[nums2Counter]) {
                    resultArray[resultArrayCounter] = nums1[i];
                    resultArrayCounter++;
                } else if (nums1[i] > nums2[nums2Counter]) {
                    resultArray[resultArrayCounter] = nums2[nums2Counter];
                    nums2Counter++;
                    resultArrayCounter++;
                } else {
                    resultArray[resultArrayCounter] = nums1[i];
                    resultArrayCounter++;
                    resultArray[resultArrayCounter] = nums1[i];
                    nums2Counter++;
                    resultArrayCounter++;
                }
            }

            for (int i = resultArrayCounter; i < resultArraySize - 1; i++) {
                resultArray[i] = nums2[nums2Counter] < nums2[nums2Counter + 1] ? nums2[nums2Counter] : nums2[nums2Counter + 1];
                nums2Counter++;
            }
            if (nums2Counter == nums2.length - 1) {
                resultArray[resultArraySize - 1] =  nums2[nums2.length - 1];
            }

        } else if (nums1.length == 0) {
            resultArray = nums2;
        } else if (nums2.length == 0) {
            resultArray = nums1;
        }
        System.arraycopy(resultArray, 0, nums1, 0, nums1.length);
        System.out.println(Arrays.toString(nums1));
    }

    public void run() {
        Problem88 problem88 = new Problem88();
        int[] nums1 = new int[] {1, 2, 3, 0, 0, 0};
        int[] nums2 = new int[] {2, 5, 6};
        int m = 3;
        int n = 3;
        problem88.merge(nums1, m, nums2, n);

        nums1 = new int[] {1};
        nums2 = new int[] {};
        m = 1;
        n = 0;
        problem88.merge(nums1, m, nums2, n);

        nums1 = new int[] {};
        nums2 = new int[] {1};
        m = 0;
        n = 1;
        problem88.merge(nums1, m, nums2, n);
    }
}
