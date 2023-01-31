/**
 * Given a string which we can delete at most k, return whether you can make a palindrome.
 * For example, given 'waterrfetawx' and a k of 2, you could delete f and x to get 'waterretaw'.
 */


public class Google4 {
   public static void main(String[] argv) {
        String palindrome = "waterrfetawx";
        int minSteps = palindromeFinder(palindrome, 0, palindrome.length() - 1, 0);
        int k = 2;
        System.out.print("Steps required: " + minSteps + "\nCan complete in " + k + " steps: " + (minSteps <= k));
   } 

   public static int palindromeFinder(String pal, int li, int ri, int k) {
    if(li >= ri) {
        return k;
    }

    if(pal.charAt(li) == pal.charAt(ri)) {
        return palindromeFinder(pal, li + 1, ri - 1, k);
    } 
        return Math.min(palindromeFinder(pal, li, ri - 1, k + 1), palindromeFinder(pal, li + 1, ri, k + 1));
    }
}
