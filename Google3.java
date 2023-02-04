/*
 * Given an array of strictly the characters 'R', 'G', and 'B', segregate the values of the array 
 * so that all the Rs come first, the Gs come second, and the Bs come last. You can only swap elements of the array.
 * 
 * Do this in linear time and in-place.
 */

// import java.util.Arrays;

public class Google3 {
    public static void main (String [] args) {
        char [] arr = {'G', 'B', 'R', 'R', 'B', 'R', 'G', 'G', 'R', 'R', 'R', 'B', 'G', 'G'};
        sort(arr, 0, arr.length - 1);
        
        System.out.print(arr);
    }

    public static int partition(char[] chs, int head, int tail) {
        int pivot = tail;
        for(int i = head; i < tail; i++) {
            if(chs[i] > chs[pivot]) {
                swap(chs, head, i);
                head++;
            }
        }
        swap(chs, head, pivot);
        return head;
    }
    public static void sort(char[] chars, int start, int end) {
        if(start >= end) { return; }
        int p = partition(chars, start, end);
   
        sort(chars, start, p - 1); 
        sort(chars, p + 1, end);
    }

    public static void swap(char[] chars, int i1, int i2) {
        char temp = chars[i1];
        chars[i1] = chars[i2];
        chars[i2] = temp;
    }






    // public static void main(String [] args) {
    //    char [] arr = {'G', 'B', 'R', 'R', 'B', 'R', 'G'};
    //     int numBs = 0;

    //    for (int i = 0; i < arr.length; i++) {
    //         if(arr[i] == 'R') {
    //             push(arr, i);
    //         }
    //         if(arr[i] == 'B') {
    //             append(arr, i);
    //             i--;
    //             numBs++;
    //         }
    //         if(arr.length - numBs <= i) {
    //             break;
    //         }
    //         String str = Arrays.toString(arr);
    //     System.out.print(str);
    //    }

        
    // }

    // public static void push(char [] arr, int index) {
    //     char temp = arr[index];
    //     shiftRight(arr, index);
    //     arr[0] = temp;
    // }

    // public static void shiftRight(char [] arr, int index) {
    //     if(index <= 0) return;
    //     arr[index] = arr[index - 1];
    //     shiftRight(arr, index - 1);
    // }

    // public static void append(char [] arr, int index) {
    //     char temp = arr[index];
    //     shiftLeft(arr, index);
    //     arr[arr.length - 1] = temp;
    // }

    // public static void shiftLeft(char [] arr, int index) {
    //     if(index >= arr.length - 1) return;
    //     arr[index] = arr[index + 1];
    //     shiftLeft(arr, index + 1);
    // }
}
