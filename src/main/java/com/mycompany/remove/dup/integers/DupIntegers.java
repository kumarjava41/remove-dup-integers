/*
 1. Given the following class, write 3 methods that can be used to return an array that has no
duplicates.
2. You should define a method signature that you feel is appropriate to the problem.
3. We would prefer to see three implementations (one that should take into consideration #4 
below) and an explanation of what use-cases are suitable to each implementation 
4. What if we need to retain the original order?
5. What are the positives and negatives of your solution?
a. Can you implement it another way so as to avoid the negatives?
6. Your solution should be testable and “production ready.”
7. Your solution should be posted to a public github repo that SEI can clone.
 */
package com.mycompany.remove.dup.integers;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 *
 * @author Naresh
 */
public class DupIntegers {

    public int[] randomIntegers = {1, 2, 34, 34, 25, 1, 45, 3, 26, 85, 4, 34, 86, 25, 43, 2, 1, 10000, 11, 16, 19, 1, 18, 4, 9, 3,
        20, 17, 8, 15, 6, 2, 5, 10, 14, 12, 13, 7, 8, 9, 1, 2, 15, 12, 18, 10, 14, 20, 17, 16, 3, 6, 19,
        13, 5, 11, 4, 7, 19, 16, 5, 9, 12, 3, 20, 7, 15, 17, 10, 6, 1, 8, 18, 4, 14, 13, 2, 11};

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DupIntegers dupInt = new DupIntegers();
        System.out.println(Arrays.toString(dupInt.remDuplicatesSet()));
        System.out.println(Arrays.toString(dupInt.remDuplicatesMap()));
        System.out.println(Arrays.toString(dupInt.remDuplicatesSort()));
    }

    public int[] remDuplicatesSet() {
        long startTime1 = System.currentTimeMillis();
        Set<Integer> setString = new LinkedHashSet<>();
        for (Integer i : randomIntegers) {
            setString.add(i);
        }
        int[] result = new int[setString.size()];
        int i = 0;
        for (Integer number : setString) {
            result[i++] = number;
        }
        long startTime2 = System.currentTimeMillis();
        System.out.println("result of set1:" + (startTime2 - startTime1));
        return result;
    }

    public int[] remDuplicatesMap() {
        long startTime1 = System.currentTimeMillis();
        Map<Integer, Integer> numAndCount = new LinkedHashMap<>();
        // build hash table with count
        for (Integer number : randomIntegers) {
            Integer count = numAndCount.get(number);
            if (count == null) {
                numAndCount.put(number, 1);
            } else {
                numAndCount.put(number, ++count);
            }
        }
        // Get duplicate elements based on count 
        Set<Entry<Integer, Integer>> entrySet = numAndCount.entrySet();
        int[] result = new int[entrySet.size()];
        int count = 0;
        for (Entry<Integer, Integer> entry : entrySet) {
            result[count] = entry.getKey();
            count++;
        }
        long startTime2 = System.currentTimeMillis();
        System.out.println("result of set:" + (startTime2 - startTime1));
        return result;
    }

    public int[] remDuplicatesSort() {
        long startTime3 = System.currentTimeMillis();
        if (randomIntegers == null || randomIntegers.length == 1) {
            return randomIntegers;
        }
        Arrays.sort(randomIntegers);
        int count = 1;
        for (int i = 1; i < randomIntegers.length; i++) {
            if (randomIntegers[i] != randomIntegers[i - 1]) {
                count++;
            }
        }
        int[] result = new int[count];
        result[0] = randomIntegers[0];
        for (int i = 1, n = 1; i < randomIntegers.length; i++) {
            if (randomIntegers[i] != randomIntegers[i - 1]) {
                result[n++] = randomIntegers[i];
            }
        }
        long startTime4 = System.currentTimeMillis();
        System.out.println("result of set:" + (startTime4 - startTime3));
        return result;
    }

}
