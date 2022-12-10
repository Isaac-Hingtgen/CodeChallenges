// Given the mapping a = 1, b = 2, ... z = 26, and an encoded message, count the number of ways it can be decoded.

// For example, the message '111' would give 3, since it could be decoded as 'aaa', 'ka', and 'ak'.

// You can assume that the messages are decodable. For example, '001' is not allowed.

public class Facebook1 {
   public static void main (String [] argv) {
       System.out.println(findNumWays(11129121));
   } 

    public static int findNumWays(int input) {
        String str = Integer.toString(input);
        int count = 1;
        int total = 1;
        int i = 0;
        while (i < str.length()) {
            while ((i < str.length() && Character.getNumericValue(str.charAt(i)) <= 2)) {
                if (str.charAt(i) == '1') {
                    count++;
                    i++;
                }
                else if (Character.getNumericValue(str.charAt(i + 1)) <= 6) {
                    count++;
                    i++;
                }
                else {break;}
            }
            i += 1;
            total *= fibo(count);
            count = 0;
        }
        return total;
   }

   public static int fibo(int count) {
          if (count <= 1) {
               return 1;
          }
          return fibo(count - 1) + fibo(count - 2);
   }

          
      
}
