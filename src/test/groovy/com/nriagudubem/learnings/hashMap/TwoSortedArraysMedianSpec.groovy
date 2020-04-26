package com.nriagudubem.learnings.hashMap

import com.nriagudubem.learnings.TwoSortedArraysMedian
import spock.lang.Specification
import spock.lang.Unroll

class TwoSortedArraysMedianSpec extends Specification {

    TwoSortedArraysMedian twoSortedArraysMedian

    void setup() {
        twoSortedArraysMedian = new TwoSortedArraysMedian()
    }


    @Unroll('test findMedianSortedArrays with #nums1 and #nums2 should return #expectedMedian')
    def 'test findMedianSortedArrays happy-path'() {
        expect:
        twoSortedArraysMedian.findMedianSortedArrays(nums1, nums2) == expectedMedian

        where:
        nums1                 | nums2                    | expectedMedian
        [1, 2] as int[]       | [3, 4] as int[]          | 2.5 as double
        [1, 2, 3, 5] as int[] | [3, 4, 6, 7, 9] as int[] | 4 as double
    }

    def 'test findMedianSortedArrays with one empty arrays should return correct median'() {

    }

    def 'test findMedianSortedArrays with both empty array input should return 0'() {

    }
}
