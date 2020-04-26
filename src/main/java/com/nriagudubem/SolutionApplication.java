package com.nriagudubem;

import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;

public class SolutionApplication {


    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> numbers = Arrays.stream(nums).sorted()
                .boxed().collect(Collectors.toList());

        for (int i = 0; i < numbers.size(); i++) {
            int sum = numbers.get(i);
            for (int j = i + 1; j < numbers.size(); j++) {
                sum = sum + numbers.get(j);
                int seeked = 0 - sum;
                System.out.println("seeked " + seeked);
                int index = Collections.binarySearch(numbers, seeked);
                if (index > 0 && index != i && index != j) {
                    System.out.println("i" + i + " j" + j + " k" + index);
                    //we found the the 3sum
                    //create a list and add to the result
                    //add validSum to result
                    List<Integer> validSum = createValidSumList(i, j, index, numbers);
                    AtomicBoolean duplicate = new AtomicBoolean(false);
                    result.forEach(item -> {
                        if(item.stream().sorted().equals(validSum.stream().sorted())){
                            duplicate.set(true);
                        }
                    });

                    if(!duplicate.get()){
                        result.add(validSum);
                    }
                }
            }
        }

        return result;

    }

    private static List<Integer> createValidSumList(int i, int j, int k, List<Integer> numbers) {
        List<Integer> validSum = new ArrayList<>();
        validSum.add(numbers.get(i));
        validSum.add(numbers.get(j));
        validSum.add(numbers.get(k));

        return validSum;
    }

    public static void main(String... args) {
        //{-4,-1,-1,0,1,2}
        threeSum(new int[]{-1, 0, 1, 2, -1, -4});
    }
}
