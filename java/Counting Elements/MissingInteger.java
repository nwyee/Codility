/*
given an array A of N integers, returns the smallest positive integer (greater than 0) that does not occur in A.

For example, given A = [1, 3, 6, 4, 1, 2], the function should return 5.

Given A = [1, 2, 3], the function should return 4.

Given A = [−1, −3], the function should return 1.

Write an efficient algorithm for the following assumptions:

N is an integer within the range [1..100,000];
each element of array A is an integer within the range [−1,000,000..1,000,000].

https://app.codility.com/programmers/lessons/4-counting_elements/missing_integer/
https://app.codility.com/demo/results/trainingC97J43-7NK/
*/
// you can also use imports, for example:
import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int[] A) {
        // write your code in Java SE 8
        if(A.length == 0) return 1;
        Arrays.sort(A);
        int check = 1;
        for(int i = 0 ; i < A.length; i++) {
            if(A[i] <= 0 || (i > 0 && A[i] == A[i-1])) continue;
            if(A[i] != check) {
                return check;
            }
            check++;
        }
        return check; 
    }
}