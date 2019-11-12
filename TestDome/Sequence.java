/**
 *
 * @author NWY
 * recursion for sequence print out.
 * eg.
 *
 * 5 4 3 2 1
 * 4 3 2 1
 * 3 2 1
 * 2 1
 * 1
 */
 
public class Sequence {
    static void  rev(int $n,int $last,String $str){
    if($last>=1){
        $str += $last + ( ($last==1)? "\n": " ");
        rev($n,$last-1,$str);
    }else{
        rev($n,$str);
    }
}

static void rev(int $n,String $str){
    if($n>=1){
        rev($n-1,$n,$str);
    }else{
        System.out.println($str);
    }
}

public static void main(String arg[]){
    rev(5,"");
}

}
