// Given a string, return whether it represents a number. Here are the different kinds of numbers:

// "10", a positive integer
// "-10", a negative integer
// "10.1", a positive real number
// "-10.1", a negative real number
// "1e5", a number in scientific notation
// And here are examples of non-numbers:

// "a"
// "x 1"
// "a -2"
// "-"

public class LinkedIn1 {
    public static void main (String [] argv) {
        System.out.print(isNumber("1.231e-3.4"));
    }
    public static boolean isNumber(String str) {
        if(str.length() == 0) return false;

        int i = 0;
        boolean oneOrZeroPeriods = true;
        boolean oneOrZeroEs = true;

        if(str.charAt(i) == '-') {
            i++;
        } 

        while(Character.isDigit(str.charAt(i)) 
        || str.charAt(i) == '.' && oneOrZeroPeriods 
        || str.charAt(i) == 'e' && oneOrZeroEs
        ) {
            if(str.charAt(i) == '.') {
                oneOrZeroPeriods = false;
                if(i == 0 || str.length() == i + 1 || !Character.isDigit(str.charAt(i-1))) {
                    return false;
                }
            }
            if(str.charAt(i) == 'e') {
                oneOrZeroEs = false;
                oneOrZeroPeriods = true;
                if(i == 0 || str.length() == i + 1 || !Character.isDigit(str.charAt(i-1))) {
                    return false;
                }
                if(str.charAt(i+1) == '-') {
                    i++;
                } 
            }
            i++;
            if(i == str.length()) {
                return true;
            }
        }
        return false;
    }
}




