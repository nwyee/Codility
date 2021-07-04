import java.util.*;

// "static void main" must be defined in a public class.
public class test01 {
    public static void main(String[] args) {
        subsets(new int[]{4,25,16,55});
        printSumSet(new int[]{4,25,16,55}, 4);
    }
    
    static List<List<Integer>> res ;
    
    public static List<List<Integer>> subsets(int[] nums) {
        res = new ArrayList<>();
        int n = nums.length;
        
        for(int i = 0 ; i <=  n; i++) {
            backtracking(0, new ArrayList<>(), nums, i);
        }
        
        //prepare output
        int[] marks = new int[res.size()];
        int i = 0;
        // summary marks
        for(List<Integer> l : res) {
            marks[i++] = l.stream().reduce(0, Integer::sum);
        }
        //sort
        Arrays.sort(marks);
        // printing out.
        for(int num : marks) {
            System.out.println(num);
        }
        return res;
    }
    
    public static void backtracking(int start, ArrayList<Integer> curr, int[] nums, int size) {
        if(curr.size() == size) {
            res.add(new ArrayList<>(curr));
        }
        for(int i = start; i < nums.length; i++) {
            curr.add(nums[i]);
            backtracking(i+1, curr,nums,size);
            curr.remove(curr.size() - 1);
        }
    }
    
    // not timeout
    public static void printSumSet(int list[], int n) {
        int count = 0;
        int sum = 0;
        for(int i = 0 ; i < n; i++) {
            sum += list[i];
        }
        
        boolean[][] memo = new boolean[n+1][sum+1];
        
        
        for(int i = 0 ; i <= n; i++) {
            memo[i][0] = true;
        }
        
        for(int i = 1; i <= n; i++ ) {
            memo[i][list[i-1]] = true;
            for(int j = 1; j <= sum ; j++) {
                if(memo[i-1][j]) {
                    memo[i][j] = true;
                    memo[i][j + list[i-1]] = true;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int j = 0 ; j <= sum; j++) {
            if(memo[n][j]){
                count++;
                sb.append(j+"\n");
            }
        }
        System.out.println(count);
        System.out.println(sb);
    }
}
