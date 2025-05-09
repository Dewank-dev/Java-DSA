package org.example;

//Input: nums = [1,1,2,3,3,4,4,8,8]
//Output: 2
//Example 2:
//
//Input: nums = [3,3,7,7,10,11,11]
//Output: 10

import java.util.Arrays;
import java.util.Collections;

public class SingleElementInASortedArray {

    public static void main(String[] args) {
        int [] arr = {1,1,2,3,3,4,4,8,8};

        Integer i = Arrays.stream(arr).boxed().filter(e ->
                Collections.frequency(Arrays.stream(arr).boxed().toList(), e) == 1).findFirst().get();
        System.out.println(i);


    }
}
