package com.nriagudubem.learnings;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class TwoSortedArraysMedian {

    private Log log = LogFactory.getLog(TwoSortedArraysMedian.class);

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int[] mergedNums = mergeArrays(nums1, nums2);

        if (mergedNums.length % 2 != 0) {
            int medianIndex = (mergedNums.length - 1) / 2;
            return mergedNums[medianIndex];
        } else {
            int firstIndex = (mergedNums.length - 1) / 2;
            int secondIndex = firstIndex + 1;
            int firstMedian = mergedNums[firstIndex];
            int secondMedian = mergedNums[secondIndex];
            return (firstMedian + secondMedian) / 2.0;
        }
    }

    private int[] mergeArrays(int[] nums1, int[] nums2) {
        int[] mergedNums = new int[nums1.length + nums2.length];
        int firstPointer = 0;
        int secondPointer = 0;
        int arrayIndex = 0;

        while (firstPointer < nums1.length && secondPointer < nums2.length) {
            if (nums1[firstPointer] < nums2[secondPointer]) {
                mergedNums[arrayIndex] = nums1[firstPointer];
                firstPointer++;
                arrayIndex++;
                continue;
            }

            if (nums1[firstPointer] == nums2[secondPointer]) {
                mergedNums[arrayIndex] = nums1[firstPointer];
                firstPointer++;
                arrayIndex++;
                continue;
            }

            if (nums2[secondPointer] < nums1[firstPointer]) {
                mergedNums[arrayIndex] = nums2[secondPointer];
                secondPointer++;
                arrayIndex++;
            }
        }

        if (nums1.length != firstPointer) {
            copyRemainingItems(mergedNums, arrayIndex, nums1, firstPointer);
        }

        if (nums2.length != secondPointer) {
            log.info("arrayIndex " + arrayIndex);
            copyRemainingItems(mergedNums, arrayIndex, nums2, secondPointer);
        }

        return mergedNums;
    }

    private void copyRemainingItems(int[] mergedNums, int index, int[] numbers, int pointer) {
        while (pointer < numbers.length) {
            mergedNums[index] = numbers[pointer];
            index++;
            pointer++;
        }
    }
}
