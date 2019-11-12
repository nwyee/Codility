/*
https://app.codility.com/programmers/lessons/4-counting_elements/perm_check/

https://app.codility.com/demo/results/trainingWB46ZW-TE5/
*/
// you can also use imports, for example:
import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int[] A) {
        // write your code in Java SE 8
        Arrays.sort(A);
        int check = 1;
        for(int n : A) {
            if(n != check) return 0;
            check++;
        }
        return 1;
    }
}