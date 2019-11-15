/*

https://app.codility.com/programmers/lessons/4-counting_elements/frog_river_one/

https://app.codility.com/demo/results/trainingWCUA4N-MFH/

*/

class Solution {
    public int solution(int X, int[] A) {
        // write your code in Java SE 8
        int step = 0; 
        boolean[] hasLeaf = new boolean[X+1];
        for(int i = 0 ; i < A.length; i++) {
            if(!hasLeaf[A[i]] && A[i] <= X) {
                hasLeaf[A[i]] = true;
                step++;
            }
            if(step == X) return i;
        }
        return -1;
    }
}