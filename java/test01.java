import java.util.*;

// "static void main" must be defined in a public class.
public class test01 {
    public static void main(String[] args) {
        subsets(new int[]{4,25,16,55});
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
}