public class Palindrome {
    public static boolean isPalindrome(String word) {
        char[] chars = word.toCharArray();
        int back = chars.length-1;
        for(int forward = 0 ; back >= forward; back--,forward++){
            if(Character.toLowerCase(chars[forward]) != Character.toLowerCase(chars[back])){
                return false;
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        System.out.println(Palindrome.isPalindrome("Deleveled"));
    }
}
