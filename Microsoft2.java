/**
 * This problem was asked by Microsoft.
 * 
 * Let's represent an integer in a linked list format by having each node represent a digit in the number. The nodes make up the number in reversed order.
 * 
 * For example, the following linked list:
 * 
 * 1 -> 2 -> 3 -> 4 -> 5
 * is the number 54321.
 * 
 * Given two linked lists in this format, return their sum in the same linked list format.
 * 
 * For example, given
 * 
 * 9 -> 9
 * 5 -> 2
 * return 124 (99 + 25) as:
 * 
 * 4 -> 2 -> 1
 */


import java.util.LinkedList;

public class Microsoft2 {
    public static void main(String [] args) {
        LinkedList<Integer> numList1 = new LinkedList<>();
        for(int i = 1; i <= 5; i++) {
            numList1.addLast(i);    // 1 -> 2 -> 3 -> 4 -> 5 == 54321
        }
        LinkedList<Integer> numList2 = new LinkedList<>();
        for(int i = 4; i <= 7; i++) {
            numList2.addLast(i);    // 4 -> 5 -> 6 -> 7 == 7654
        }
        LinkedList<Integer> numList3 = sumLists(numList1, numList2);
        System.out.print(numList3); // Expected: 61975 == 5 -> 7 -> 9 -> 1 -> 6
    }

    public static LinkedList<Integer> sumLists(LinkedList<Integer> list1, LinkedList<Integer> list2) {
        int sum = getListNumber(list1) + getListNumber(list2);
        return intToList(sum);
    }

    public static int getListNumber(LinkedList<Integer> list) {
        int multiplier = 1;
        int totNumber = 0;
        for(int number : list) {
            totNumber += number * multiplier;
            multiplier *= 10;
        } 
        return totNumber;
    }
    public static LinkedList<Integer> intToList(int number) {
        LinkedList<Integer> numList = new LinkedList<>();
        while(number > 0) {
            int digit = number % 10;
            number = (number - digit) / 10;
            numList.addLast(digit);
        }
        return numList;
    }
}
