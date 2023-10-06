/**
 * This problem was asked by Uber.
 * Write a program that determines the smallest number of perfect squares that sum up to N.
 * Here are a few examples:
 *	Given N = 4, return 1 (4)
 *	Given N = 17, return 2 (16 + 1)
 *	Given N = 18, return 2 (9 + 9)
 *
 */

public class LeastNumPerfectSquares {
  public static void main(String argv[]) {
    int[][] testCases = {
            {18,2},
            {9,1},
            {10,2},
            {17,2},
            {273,3},
            {125,2},
            {173,2},
            {324134123,5}
    };
    for(int[] test : testCases) {
      System.out.println("Result: " + leastNumPerfectSquares(test[0]) + ", Expected: " + test[1]);
      assert leastNumPerfectSquares(test[0]) == test[1];
    }
  }
  public static int leastNumPerfectSquares(int num) {
    if(num == 1) return 1;
    int result = floorPerfectSquare(num);
    result = Math.min(result, leastNumPerfectSquares(num/2) + leastNumPerfectSquares((int)Math.ceil(num/2.0)));
    return result;
  }
  public static int floorPerfectSquare(int num) {
    if(num <= 3) return num;
    int perfectSquare = (int)Math.pow((int)Math.floor(Math.sqrt(num)), 2);
    int remainder = num - perfectSquare;
    return 1 + floorPerfectSquare(remainder);
  }
}