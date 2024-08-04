package com.github.xholod.level.easy;

import java.util.Arrays;
/*
    https://leetcode.com/problems/merge-sorted-array/description/
 */

public class Problem88 {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int resultArraySize = m + n;
        int[] resultArray = new int[resultArraySize];
        int firstArrayElementCounter = 0;
        int secondArrayElementCounter = 0;
        int resultArrayElementCounter = 0;
        System.out.println(Arrays.toString(nums1));
        System.out.println(Arrays.toString(nums2));

        if (nums1.length < nums2.length) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }

        if (nums1.length != 0 && nums2.length != 0) {
            for (int i = resultArrayElementCounter; i < resultArraySize; i++) {
                if (firstArrayElementCounter == m)  {
                    resultArray[i] = nums2[secondArrayElementCounter];
                    secondArrayElementCounter++;
                    continue;
                }

                if (secondArrayElementCounter == n) {
                    resultArray[i] = nums1[firstArrayElementCounter];
                    firstArrayElementCounter++;
                    continue;
                }


                if (nums1[firstArrayElementCounter] < nums2[secondArrayElementCounter]) {
                    resultArray[i] = nums1[firstArrayElementCounter];
                    firstArrayElementCounter++;
                } else if (nums1[firstArrayElementCounter] > nums2[secondArrayElementCounter]) {
                    resultArray[i] = nums2[secondArrayElementCounter];
                    secondArrayElementCounter++;
                } else {
                    resultArray[i] = nums1[firstArrayElementCounter];
                    firstArrayElementCounter++;
                }

                resultArrayElementCounter++;
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
        int m;
        int n;
        int[] nums1;
        int[] nums2;

        nums1 = new int[]{1, 2, 3, 0, 0, 0};
        nums2 = new int[]{2, 5, 6};
        m = 3;
        n = 3;
//        problem88.merge(nums1, m, nums2, n);

        nums1 = new int[]{1};
        nums2 = new int[]{};
        m = 1;
        n = 0;
//        problem88.merge(nums1, m, nums2, n);

        nums1 = new int[]{};
        nums2 = new int[]{1};
        m = 0;
        n = 1;
//        problem88.merge(nums1, m, nums2, n);

        nums1 = new int[]{2, 0};
        nums2 = new int[]{1};
        m = 1;
        n = 1;
//        problem88.merge(nums1, m, nums2, n);

        nums1 = new int[]{0,0,3,0,0,0,0,0,0};
        nums2 = new int[]{-1,1,1,1,2,3};
        m = 3;
        n = 6;
        problem88.merge(nums1, m, nums2, n);
    }
}
