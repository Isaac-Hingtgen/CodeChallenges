/**
 * Given a list of numbers and a number k, return whether any two numbers from the list add up to k.

For example, given [10, 15, 3, 7] and k of 17, return true since 10 + 7 is 17.

Bonus: Can you do this in one pass?
 */

import java.util.Scanner;
import java.util.Vector;

public class Google1 {
    public static void main (String [] argv) {
    Scanner input = new Scanner(System.in);
    input.close();
    String inputString = input.nextLine();
    Vector<Integer> list = new Vector<Integer>(1, 1);

    inputString = inputString.substring(1);
    while (inputString.indexOf(", ") >= 0){
        list.add(Integer.parseInt(inputString.substring(0, inputString.indexOf(", "))));
        inputString = inputString.substring(inputString.indexOf(", ") + 2);
    }
    list.add(Integer.parseInt(inputString.substring(0,inputString.indexOf("]"))));

    int k = input.nextInt();

    for (int i = 0; i < list.capacity(); i++) {
        for (int j = i + 1; j < list.capacity(); j++) {
            if ((int)list.elementAt(i) + (int)list.elementAt(j) == k){
                System.out.println("True");
            }
            else {
                System.out.println("false");
            }
        }
    }
    }
}