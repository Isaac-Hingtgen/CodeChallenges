/*
 * Given a string, find the palindrome that can be made by inserting the 
 * fewest number of characters as possible anywhere in the word. 
 * If there is more than one palindrome of minimum length that can be made, 
 * return the lexicographically earliest one (the first one alphabetically).
 */

 import java.util.ArrayList;

public class Quora1 {
    public static void main(String [] argv) {
        String str = "race";
        String palindrome = getPalindrome(str);
    }

    public static String getPalindrome(String str) {
        char [] charArr = str.toCharArray();
        boolean duplicate = false;
        ArrayList<Character> list = new ArrayList<Character>();


        for(char c : charArr) {
            if(str.indexOf(c, str.indexOf(c) + 1) != -1) {
                duplicate = true;
                list.add(c);
            }
        }
        return null;
    }

    public static char [] reverse(char [] cArr) {
        char [] newArr = new char[cArr.length];
        for(char c : cArr) {
            
        }
        return null;
    }
}
