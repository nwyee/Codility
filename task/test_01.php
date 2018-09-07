<?php
/*
Deepest Pit
*/
function solution_dp($A) {
    // write your code in PHP7.0
    $N = count($A);
    $depth = -1;
    
    for($i=0 ; $i < $N - 2; ){
        $p = $A[$i];
        
        $j = $i + 1;
        $temp_p = $p;
        while( $j < $N-1 && $A[$j] < $temp_p){
            $temp_p = $A[$j++];
        }
        
        if($j == $N-1){
            break;
        }
        if($j > $i + 1){
            $q = $A[$j-1];
        }else{
            $i++;
            continue;
        }
        $k = $j;
        $temp_q = $q;
        while( $k < $N && $A[$k] > $temp_q){
            $temp_q = $A[$k++];
        }
        if($k > $j){
            $r = $A[$k-1];
            $depth = max($depth, min($p - $q , $r - $q));
            $i = $k - 1;
        }else{
            $i = $j - 1;
        }
    }
    return max($depth,-1);
}

/*
multi- pairs 
*/
function solution_pair($A, $B) {
    // write your code in PHP7.0
    $divided = 1000000;
    $multi = 1000000000;
    $count = 0;
    $C = array();
    for($i = 0; $i < count($A); $i++){
        $C[$i] = $A[$i] + $B[$i] /$divided;
    }
    
    $pairs = array();
    
    for($i = 0 ; $i < count($C); $i++){
        for($j = $i+1 ; $j < count($C);$j++){
            if($C[$i] * $C[$j] >= $C[$i] + $C[$j]){
               $count++;
            }
        }
    }
    
    if($count > $multi){
        return $multi;
    }
    return $count;
}

