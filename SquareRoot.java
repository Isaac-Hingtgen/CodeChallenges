/**
 * Given a real number n, find the square root of n. For example, given n = 9, return 3.
 */


public class SquareRoot {
    public static void main(String [] args) {
        double numToSqrt = .0000000019679;
        try {
            System.out.println("Square root of " + numToSqrt + " to 15 decimal places is : " + sqrt(numToSqrt));
        } 
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public static double sqrt(double n) throws Exception {
        if(n < 0) { throw new Exception("Number cannot be negative."); }
        return sqrtRecursive(n, 0, decimalWithHalfTheNumberOfDigits(n));  // get decimal with lowest number of digits the answer can be
    }
    public static double sqrtRecursive(double target, double curClosest, double decimal) {
        if(decimal < 0.000000000000001) { return curClosest; }

        for(int i = 0; i <= 10; i++) {
            double decPos = curClosest + i * decimal;
            double decSquared = decPos * decPos;
            double nextDecSquared = (decPos + decimal) * (decPos + decimal);
            if(decSquared <= (target) && nextDecSquared > (target)) {
                return Math.max(sqrtRecursive(target, decPos, decimal / 10.0), curClosest);
            }
        }
        return -1.0;
    }

    public static double decimalWithHalfTheNumberOfDigits(double n) {
        double decimal = 1;
        int mostSignificantDigit = 0;
        if(n >= 1) {
            while(n >= 10) {
                n /= 10;
                mostSignificantDigit++;
            }
        } else {
            while(n < 1) {
                n *= 10;
                mostSignificantDigit++;
            }
        }

        mostSignificantDigit /= 2;
        for(int i = 0; i < mostSignificantDigit; i++) {
            decimal *= 10;
        }
        
        decimal = (n < 1) ? 1 / decimal : decimal;
        return decimal;
    }
}
