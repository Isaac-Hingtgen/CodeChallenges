/*
 * Given a string, find the palindrome that can be made by inserting the 
 * fewest number of characters as possible anywhere in the word. 
 * If there is more than one palindrome of minimum length that can be made, 
 * return the lexicographically earliest one (the first one alphabetically).
 */

 import java.util.ArrayList;

public class Quora1 {
    public static void main(String [] argv) {
        String str = "zcdrace";
        String palindrome = makePalindrome(str, 0, str.length() - 1);
        System.out.print(palindrome);
    }
    public static String makePalindrome(String str, int li, int ri) {
        if(li >= ri) {
            return str;
        }
        if(str.charAt(li) == str.charAt(ri)) {
            return makePalindrome(str, li + 1, ri - 1);
        }

        String str1 = str.substring(0, ri+1) + str.charAt(li) + str.substring(ri+1);
        String str2 = str.substring(0, li) + str.charAt(ri) + str.substring(li);
        String pal1 = makePalindrome(str1, li, ri+1);
        String pal2 = makePalindrome(str2, li, ri+1);
        String bestPal = "";
        if(pal1.length() == pal2.length()) {
            bestPal = (pal1.compareTo(pal2) < 0) ? pal1 : pal2;
        } else {
            bestPal = (pal1.length() <= pal2.length()) ? pal1 : pal2;
        }
        return bestPal;
    }
    
}
