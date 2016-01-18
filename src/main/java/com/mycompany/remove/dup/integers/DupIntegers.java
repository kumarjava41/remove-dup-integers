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
        // add the ints into a set as no duplicates are allowed and 
        // linked hashset is used to maintain order
        Set<Integer> setString = new LinkedHashSet<>();
        //Iterate each element in an array of Integers
        for (Integer i : randomIntegers) {
            setString.add(i);
        }
        //initilalize an result array with size equal to 
        //the size of thee set from the above operation
        int[] result = new int[setString.size()];
        int i = 0;
        //Iterate through the set elements and add each element
        //to the result array
        for (Integer number : setString) {
            result[i++] = number;
        }
        return result;
    }

    public int[] remDuplicatesMap() {
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
        return result;
    }

    public int[] remDuplicatesSort() {
        if (randomIntegers == null || randomIntegers.length == 1) {
            return randomIntegers;
        }
        //Sort input array by its natural order
        Arrays.sort(randomIntegers);
        int count = 1;
        //Loop through the array elements and get the distinct element count
        for (int i = 1; i < randomIntegers.length; i++) {
            if (randomIntegers[i] != randomIntegers[i - 1]) {
                count++;
            }
        }
        //Initialize an result array with the size from earlier operation
        int[] result = new int[count];
        result[0] = randomIntegers[0];
        //Loop through the input array and add distinct elements to the result array
        //This will not maintain order as sort operation is involved.
        for (int i = 1, n = 1; i < randomIntegers.length; i++) {
            if (randomIntegers[i] != randomIntegers[i - 1]) {
                result[n++] = randomIntegers[i];
            }
        }
        return result;
    }

}
