package com.mycompany.remove.dup.integers;

import java.util.Arrays;
import org.junit.Test;
import static org.junit.Assert.*;

public class DuplicateRemoverTest {
public int[] removeDuplicatesUnorderd = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 25, 26, 34, 43, 45, 85, 86, 10000};
public int[] orderedArray={1, 2, 34, 25, 45, 3, 26, 85, 4, 86, 43, 10000, 11, 16, 19, 18, 9, 20, 17, 8, 15, 6, 5, 10, 14, 12, 13, 7};
    @Test
    public void removesDuplicateSetTest() {       
        int[] expected = orderedArray;
        DupIntegers removeDups = new DupIntegers();
        int[] actual = removeDups.remDuplicatesSet();
        assertEquals(expected.length, actual.length);
        assertEquals(Arrays.toString(expected), Arrays.toString(actual));
    }
     @Test
    public void removesDuplicateMapTest() {       
        int[] expected = orderedArray;
        DupIntegers removeDups = new DupIntegers();
        int[] actual = removeDups.remDuplicatesMap();
        assertEquals(expected.length, actual.length);
        assertEquals(Arrays.toString(expected), Arrays.toString(actual));
    }

    @Test
    public void remDuplicatesSort() {
        int[] expected = removeDuplicatesUnorderd;
        DupIntegers removeDups = new DupIntegers();
        int[] actual = removeDups.remDuplicatesSort();
        assertEquals(expected.length, actual.length);
        assertEquals(Arrays.toString(expected), Arrays.toString(actual));
    }

}

